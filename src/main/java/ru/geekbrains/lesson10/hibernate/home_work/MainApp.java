package ru.geekbrains.lesson10.hibernate.home_work;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.lesson10.hibernate.PrepareDataApp;

public class MainApp {
    public static void main(String[] args) {
        PrepareDataApp.forcePrepareData();

        SessionFactory factory = new Configuration()
                .configure("configs/home_work/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Создание и добавление в БД покупателей
//            Consumer consumer1 = new Consumer("Иван","Иванов");
//            Consumer consumer2 = new Consumer("Пётр","Петров");
//            Consumer consumer3 = new Consumer("Сидoр","Сидоров");
//            Consumer consumer4 = new Consumer("Владимир","Путин");
//            consumer1.addConsumerToDb(session);
//            consumer2.addConsumerToDb(session);
//            consumer3.addConsumerToDb(session);
//            consumer4.addConsumerToDb(session);

            //Создание и добавление в БД продуктов
//            Product product1 = new Product("Хлеб", 50);
//            Product product2 = new Product("Молоко", 80);
//            Product product3 = new Product("Сыр", 217);
//            Product product4 = new Product("Мясо", 300);
//            Product product5 = new Product("Рыба", 450);
//            Product product6 = new Product("Вода", 30);
//            Product product7 = new Product("Творог", 76);
//            Product product8 = new Product("Йогурт", 45);
//            Product product9 = new Product("Сигареты", 218);
//            Product product10 = new Product("Водка", 250);
//            product1.addProductToDb(session);
//            product2.addProductToDb(session);
//            product3.addProductToDb(session);
//            product4.addProductToDb(session);
//            product5.addProductToDb(session);
//            product6.addProductToDb(session);
//            product7.addProductToDb(session);
//            product8.addProductToDb(session);
//            product9.addProductToDb(session);
//            product10.addProductToDb(session);

            //Получение покупателя из БД
            Consumer consumer1 = new Consumer().getConsumerFromDb(session, 1L);
            Consumer consumer2 = new Consumer().getConsumerFromDb(session, 2L);
            Consumer consumer3 = new Consumer().getConsumerFromDb(session, 3L);
            Consumer consumer4 = new Consumer().getConsumerFromDb(session, 4L);

            //Получение товара из БД
            Product product1 = new Product().getProductFromDb(session, 1L);
            Product product2 = new Product().getProductFromDb(session, 2L);
            Product product3 = new Product().getProductFromDb(session, 3L);
            Product product4 = new Product().getProductFromDb(session, 4L);
            Product product5 = new Product().getProductFromDb(session, 5L);
            Product product6 = new Product().getProductFromDb(session, 6L);
            Product product7 = new Product().getProductFromDb(session, 7L);
            Product product8 = new Product().getProductFromDb(session, 8L);
            Product product9 = new Product().getProductFromDb(session, 9L);
            Product product10 = new Product().getProductFromDb(session, 10L);

            //Создание и сохранение покупок в БД
            Purchase purchase0 = new Purchase().buyProduct(session, consumer1, product8);
            Purchase purchase1 = new Purchase().buyProduct(session, consumer1, product7);
            Purchase purchase2 = new Purchase().buyProduct(session, consumer1, product3);
            Purchase purchase3 = new Purchase().buyProduct(session, consumer1, product10);

            Purchase purchase4 = new Purchase().buyProduct(session, consumer2, product1);
            Purchase purchase5 = new Purchase().buyProduct(session, consumer2, product9);
            Purchase purchase6 = new Purchase().buyProduct(session, consumer2, product2);
            Purchase purchase7 = new Purchase().buyProduct(session, consumer2, product5);

            Purchase purchase8 = new Purchase().buyProduct(session, consumer3, product3);
            Purchase purchase9 = new Purchase().buyProduct(session, consumer3, product8);
            Purchase purchase10 = new Purchase().buyProduct(session, consumer3, product10);
            Purchase purchase11 = new Purchase().buyProduct(session, consumer3, product4);

            Purchase purchase12 = new Purchase().buyProduct(session, consumer4, product6);
            Purchase purchase13 = new Purchase().buyProduct(session, consumer4, product2);
            Purchase purchase14 = new Purchase().buyProduct(session, consumer4, product8);
            Purchase purchase15 = new Purchase().buyProduct(session, consumer4, product3);


            Scanner scanner = new Scanner();
            //Распечатать в консоль товары, которые приобрел покупатель, по имени покупателя
            //По покупателю
            scanner.showProductsByConsumer(session, consumer1);
            //По имени покупателя
            scanner.showProductsByConsumerName(session, "Иван");

            //Распечатать имена покупателей, купивших указанный товар, по названию товара
            //По товару
            scanner.showConsumersByProduct(session, product1);
            //По названию товара
            scanner.showConsumersByProductName(session, "Хлеб");

            //Предоставить возможность удалять из базы товары/покупателей по названию/имени
            //По покупателю
            scanner.deleteConsumer(session, consumer1);
            //По имени покупателя
            scanner.deleteConsumerByName(session, "Иван");
            //По товару
            scanner.deleteProduct(session, product1);
            //По названию товара
            scanner.deleteProductByName(session, "Хлеб");

            //По паре покупатель-товар нужна детализация: стоимость товара на момент покупки клиентом
            scanner.getProductPriceByConsumerAndProduct(session, consumer2, product2);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
