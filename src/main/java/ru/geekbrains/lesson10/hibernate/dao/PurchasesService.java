package ru.geekbrains.lesson10.hibernate.dao;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class PurchasesService {
    private String purchaseDateTime;
    private Long consumerId;
    private Long productId;

    public PurchasesService(Long consumerId, Long productId) {
        this.consumerId = consumerId;
        this.productId = productId;
    }

    public void buy() {
        ObjectDao<Consumer> consumerObjectDao = new ObjectDao(Consumer.class);
        Consumer consumer = consumerObjectDao.findById(consumerId);
        if (consumer == null) {
            throw new IllegalArgumentException("\033[0;31m" + "ОШИБКА: В БД для класса \"Покупатель\" записи с ID: " + consumerId + " не найдено. Покупка не будет произведена." + "\033[0m");
        }

        ObjectDao<Product> productObjectDao = new ObjectDao(Product.class);
        Product product = productObjectDao.findById(productId);
        if (product == null) {
            throw new RuntimeException("\033[0;31m" + "ОШИБКА: В БД для класса \"Продукт\" записи с ID: " + productId + " не найдено. Покупка не будет произведена." + "\033[0m");
        }

        purchaseDateTime = ZonedDateTime.now(ZoneId.of("Europe/Moscow"))
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        Purchase purchase = new Purchase(purchaseDateTime, consumer, consumer.getFirstName(), product, product.getName(), product.getPrice());
        PurchaseDao purchaseDao = new PurchaseDao(Purchase.class);
        purchaseDao.saveOrUpdate(purchase);
    }
}
