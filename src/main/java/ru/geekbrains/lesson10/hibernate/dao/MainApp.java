package ru.geekbrains.lesson10.hibernate.dao;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        try {
            HibernateUtils.init();

            //Создание и добавление в БД покупателей
            Consumer consumer1 = new Consumer("Иван", "Иванов");
            Consumer consumer2 = new Consumer("Пётр", "Петров");
            Consumer consumer3 = new Consumer("Сидoр", "Сидоров");
            Consumer consumer4 = new Consumer("Владимир", "Путин");
            Consumer consumer5 = new Consumer("Сергей", "Сергеев");
            ObjectDao<Consumer> consumerObjectDao = new ObjectDao<>(Consumer.class);
            consumerObjectDao.saveOrUpdate(consumer1);
            consumerObjectDao.saveOrUpdate(consumer2);
            consumerObjectDao.saveOrUpdate(consumer3);
            consumerObjectDao.saveOrUpdate(consumer4);
            consumerObjectDao.saveOrUpdate(consumer5);

            //Создание и добавление в БД продуктов
            Product product1 = new Product("Хлеб", 50);
            Product product2 = new Product("Молоко", 80);
            Product product3 = new Product("Сыр", 217);
            Product product4 = new Product("Мясо", 300);
            Product product5 = new Product("Рыба", 450);
            Product product6 = new Product("Вода", 30);
            Product product7 = new Product("Творог", 76);
            Product product8 = new Product("Йогурт", 45);
            Product product9 = new Product("Сигареты", 218);
            Product product10 = new Product("Водка", 250);
            ObjectDao<Product> productObjectDao = new ObjectDao<>(Product.class);
            productObjectDao.saveOrUpdate(product1);
            productObjectDao.saveOrUpdate(product2);
            productObjectDao.saveOrUpdate(product3);
            productObjectDao.saveOrUpdate(product4);
            productObjectDao.saveOrUpdate(product5);
            productObjectDao.saveOrUpdate(product6);
            productObjectDao.saveOrUpdate(product7);
            productObjectDao.saveOrUpdate(product8);
            productObjectDao.saveOrUpdate(product9);
            productObjectDao.saveOrUpdate(product10);

            //Получение покупателя из БД по Id
            ObjectDao<Consumer> consumerObjectDao1 = new ObjectDao(Consumer.class);
            Consumer consumer = consumerObjectDao1.findById(1L);
            System.out.println(consumer.toString());

            //Получение товара из БД по Id
            ObjectDao<Product> productObjectDao1 = new ObjectDao(Product.class);
            Product product = productObjectDao1.findById(1L);
            System.out.println(product.toString());

            //Получение покупателя из БД по Имени
            ObjectDao<Consumer> consumerObjectDao2 = new ObjectDao(Consumer.class);
            System.out.println(consumerObjectDao2.findByName("Иван"));

            //Получение товара из БД по Названию
            ObjectDao<Product> productObjectDao2 = new ObjectDao(Product.class);
            System.out.println(productObjectDao2.findByName("Молоко"));

            //Получение списка всех покупателей из БД
            ObjectDao<Consumer> consumerObjectDao3 = new ObjectDao(Consumer.class);
            List<Consumer> consumersList = consumerObjectDao3.getAll();
            if (consumersList.isEmpty()) {
                System.out.println("\033[0;31m" + "В БД для данного класса не найдено ни одной записи." + "\033[0m");
            } else {
                for (Consumer c : consumersList) {
                    System.out.println(c);
                }
            }

            //Получение списка всех продуктов из БД
            ObjectDao<Product> productObjectDao3 = new ObjectDao(Product.class);
            List<Product> productsList = productObjectDao3.getAll();
            if (productsList.isEmpty()) {
                System.out.println("\033[0;31m" + "В БД для данного класса не найдено ни одной записи." + "\033[0m");
            } else {
                for (Product p : productsList) {
                    System.out.println(p);
                }
            }

            //По паре покупатель-товар нужна детализация: стоимость товара на момент покупки клиентом.
            String consumerName = "Иван";
            String productName = "Молоко";
            PurchaseDao purchaseDao = new PurchaseDao(Purchase.class);
            List<Purchase> purchasesList = purchaseDao.getProductPriceByConsumerAndProduct(consumerName, productName);
            StringBuilder consumerPurchasesList = new StringBuilder();
            consumerPurchasesList.append("Клиент \"" + consumerName + "\" покупал товар \"" + productName + "\" " + purchasesList.size() + " раз: ");
            for (Purchase p : purchasesList) {
                consumerPurchasesList.append(p.getPurchaseDateTime() + " по цене " + p.getProductPrice() + " рублей, ");
            }
            consumerPurchasesList.setLength(consumerPurchasesList.length() - 2);
            consumerPurchasesList.append(".");
            System.out.println(consumerPurchasesList);

            //Распечатать в консоль товары, которые приобрел покупатель, по имени покупателя.
            ProductDao productDao = new ProductDao(Product.class);
            System.out.println(productDao.showProductsByConsumerName("Иван"));

            //Распечатать имена покупателей, купивших указанный товар, по названию товара.
            ConsumerDao consumerDao = new ConsumerDao(Consumer.class);
            System.out.println(consumerDao.showConsumersByProductName("Молоко"));

            //Предоставить возможность удалять из базы товары/покупателей по названию/имени;
            ObjectDao<Product> productObjectDao4 = new ObjectDao<>(Product.class);
            List<Product> deletedObjects = productObjectDao4.deleteByName("Молоко");
            System.out.println("Список удалённых объектов:\n" + deletedObjects);

            //Реализовать возможность “покупки товара” по id покупателя и товара.
            PurchasesService purchasesService = new PurchasesService(3L, 3L);
            purchasesService.buy();

        } finally {
            HibernateUtils.shutdown();
        }
    }
}