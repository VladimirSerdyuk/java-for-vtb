package ru.geekbrains.lesson10.hibernate.dao;

import org.hibernate.Session;

import java.util.List;

public class ProductDao<T> extends ObjectDao<T> {
    public ProductDao(Class<T> cl) {
        super(cl);
    }

    public List<Product> showProductsByConsumerName(String consumerName) {
        Session session = HibernateUtils.getCurrentSession();
        session.getTransaction().begin();
        List<Product> productsList = session.createNamedQuery(Product.class.getSimpleName() + ".FindProductsByConsumerName", Product.class).setParameter("consumerName", consumerName).getResultList();
        if (productsList.isEmpty()) {
            throw new RuntimeException("\033[0;31m" + "ОШИБКА: Покупатель \"" + consumerName + "\" ещё ничего не покупал." + "\033[0m");
        }
        session.getTransaction().commit();
        return productsList;
    }
}