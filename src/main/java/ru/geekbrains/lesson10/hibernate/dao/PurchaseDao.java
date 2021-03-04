package ru.geekbrains.lesson10.hibernate.dao;

import org.hibernate.Session;

import java.util.List;

public class PurchaseDao<T> extends ObjectDao<T> {
    public PurchaseDao(Class<T> cl) {
        super(cl);
    }

    public List<Purchase> getProductPriceByConsumerAndProduct(String consumerName, String productName) {
        Session session = HibernateUtils.getCurrentSession();
        session.getTransaction().begin();
        List<Purchase> purchasesList = session.createNamedQuery("Purchase.FindPurchaseByConsumerAndProduct", Purchase.class)
                .setParameter("consumerName", consumerName)
                .setParameter("productName", productName).getResultList();
        if (purchasesList.isEmpty()) {
            throw new RuntimeException("\033[0;31m" + "В ДБ нет записей о том, что клиент \"" + consumerName + "\" когда либо покупал товар \"" + productName + "." + "\033[0m");
        }
        session.getTransaction().commit();
        return purchasesList;
    }
}
