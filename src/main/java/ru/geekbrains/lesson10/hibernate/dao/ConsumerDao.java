package ru.geekbrains.lesson10.hibernate.dao;

import org.hibernate.Session;

import java.util.List;

public class ConsumerDao<T> extends ObjectDao<T> {
    public ConsumerDao(Class<T> cl) {
        super(cl);
    }

    public List<Consumer> showConsumersByProductName(String productName) {
        Session session = HibernateUtils.getCurrentSession();
        session.getTransaction().begin();
        List<Consumer> consumersList = session.createNamedQuery(Consumer.class.getSimpleName() + ".FindConsumersByProductName", Consumer.class).setParameter("productName", productName).getResultList();
        if (consumersList.isEmpty()) {
            throw new RuntimeException("\033[0;31m" + "ОШИБКА: Товар \"" + productName + "\" ещё никто не покупал." + "\033[0m");
        }
        session.getTransaction().commit();
        return consumersList;
    }
}