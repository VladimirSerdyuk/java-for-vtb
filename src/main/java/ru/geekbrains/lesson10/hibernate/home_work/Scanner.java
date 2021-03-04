package ru.geekbrains.lesson10.hibernate.home_work;

import org.hibernate.Session;

import java.util.List;

public class Scanner {
    private String consumerName;

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public Scanner() {
    }

    public void showProductsByConsumer(Session session, Consumer consumer) {
        List<Consumer> consumers = session.createNamedQuery("Consumer.findByName", Consumer.class).setParameter("name", consumer.getFirstName()).getResultList();
        for (Consumer c : consumers) {
            List<Purchase> purchases = c.getPurchases();
            StringBuilder productsList = new StringBuilder();
            productsList.append("Список покупок для покупателя \"" + consumer.getFirstName() + "\": ");
            for (Purchase purchase : purchases) {
                productsList.append(purchase.getProductName() + ", ");
            }
            productsList.setLength(productsList.length() - 2);
            productsList.append(".");
            System.out.println(productsList);
        }
    }

    public void showProductsByConsumerName(Session session, String consumerName) {
        List<Consumer> consumers = session.createNamedQuery("Consumer.findByName", Consumer.class).setParameter("name", consumerName).getResultList();
        for (Consumer c : consumers) {
            List<Purchase> purchases = c.getPurchases();
            StringBuilder productsList = new StringBuilder();
            productsList.append("Список покупок для покупателя \"" + consumerName + "\": ");
            for (Purchase purchase : purchases) {
                productsList.append(purchase.getProductName() + ", ");
            }
            productsList.setLength(productsList.length() - 2);
            productsList.append(".");
            System.out.println(productsList);
        }
    }

    public void deleteProductByName(Session session, String productName) {
        List<Product> products = session.createNamedQuery("Product.findByName", Product.class).setParameter("name", productName).getResultList();
        StringBuilder deletedProductsList = new StringBuilder();
        deletedProductsList.append("Произведено удаление продукта(ов) c названием \"" + productName + "\": ");
        for (Product p : products) {
            deletedProductsList.append("ID: " + p.getId() + ", Название: " + p.getName() + ", Цена: " + p.getPrice() + ";\n");
            session.delete(p);
        }
        deletedProductsList.setLength(deletedProductsList.length() - 2);
        deletedProductsList.append(".");
        System.out.println(deletedProductsList);
    }

    public void deleteProduct(Session session, Product product) {
        List<Product> products = session.createNamedQuery("Product.findByName", Product.class).setParameter("name", product.getName()).getResultList();
        StringBuilder deletedProductsList = new StringBuilder();
        deletedProductsList.append("Произведено удаление продукта(ов) c названием \"" + product.getName() + "\": ");
        for (Product p : products) {
            deletedProductsList.append("ID: " + p.getId() + ", Название: " + p.getName() + ", Цена: " + p.getPrice() + ";\n");
            session.delete(p);
        }
        deletedProductsList.setLength(deletedProductsList.length() - 2);
        deletedProductsList.append(".");
        System.out.println(deletedProductsList);
    }

    public void showConsumersByProduct(Session session, Product product) {
        List<Product> products = session.createNamedQuery("Product.findByName", Product.class).setParameter("name", product.getName()).getResultList();
        for (Product p : products) {
            List<Purchase> purchases = p.getPurchases();
            StringBuilder consumersList = new StringBuilder();
            consumersList.append("Список покупателей товара \"" + product.getName() + "\": ");
            for (Purchase purchase : purchases) {
                consumersList.append(purchase.getConsumerName() + ", ");
            }
            consumersList.setLength(consumersList.length() - 2);
            consumersList.append(".");
            System.out.println(consumersList);
        }
    }

    public void showConsumersByProductName(Session session, String productName) {
        List<Product> products = session.createNamedQuery("Product.findByName", Product.class).setParameter("name", productName).getResultList();
        for (Product p : products) {
            List<Purchase> purchases = p.getPurchases();
            StringBuilder consumersList = new StringBuilder();
            consumersList.append("Список покупателей товара \"" + productName + "\": ");
            for (Purchase purchase : purchases) {
                consumersList.append(purchase.getConsumerName() + ", ");
            }
            consumersList.setLength(consumersList.length() - 2);
            consumersList.append(".");
            System.out.println(consumersList);
        }
    }

    public void deleteConsumerByName(Session session, String consumerName) {
        List<Consumer> consumers = session.createNamedQuery("Consumer.findByName", Consumer.class).setParameter("name", consumerName).getResultList();
        StringBuilder deletedConsumersList = new StringBuilder();
        deletedConsumersList.append("Произведено удаление покупателя(лей) c именем \"" + consumerName + "\": ");
        for (Consumer c : consumers) {
            deletedConsumersList.append("ID: " + c.getId() + ", Имя: " + c.getFirstName() + ", Фамилия: " + c.getLastName() + ";\n");
            session.delete(c);
        }
        deletedConsumersList.setLength(deletedConsumersList.length() - 2);
        deletedConsumersList.append(".");
        System.out.println(deletedConsumersList);
    }

    public void deleteConsumer(Session session, Consumer consumer) {
        List<Consumer> consumers = session.createNamedQuery("Consumer.findByName", Consumer.class).setParameter("name", consumer.getFirstName()).getResultList();
        StringBuilder deletedConsumersList = new StringBuilder();
        deletedConsumersList.append("Произведено удаление покупателя(лей) c именем \"" + consumer.getFirstName() + "\": ");
        for (Consumer c : consumers) {
            deletedConsumersList.append("ID: " + c.getId() + ", Имя: " + c.getFirstName() + ", Фамилия: " + c.getLastName() + ";\n");
            session.delete(c);
        }
        deletedConsumersList.setLength(deletedConsumersList.length() - 2);
        deletedConsumersList.append(".");
        System.out.println(deletedConsumersList);
    }

    public void getProductPriceByConsumerAndProduct(Session session, Consumer consumer, Product product) {
        List<Purchase> purchases = session.createNamedQuery("Purchase.findPurchaseByConsumerAndProduct", Purchase.class).setParameter("consumerName", consumer.getFirstName()).setParameter("productName", product.getName()).getResultList();
        if (purchases.size() > 0) {
            StringBuilder consumerPurchasesList = new StringBuilder();
            consumerPurchasesList.append("Клиент \"" + consumer.getFirstName() + "\" покупал товар \"" + product.getName() + "\" " + purchases.size() + " раз: ");
            for (Purchase p : purchases) {
                consumerPurchasesList.append(p.getPurchaseDateTime() + " по цене " + p.getProductPrice() + " рублей, ");
            }
            consumerPurchasesList.setLength(consumerPurchasesList.length() - 2);
            consumerPurchasesList.append(".");
            System.out.println(consumerPurchasesList);
        } else {
            System.out.println("В ДБ нет записей о том, что клиент \"" + consumer + "\" когда либо покупал товар \"" + product.getName() + ".");
        }
    }
}
