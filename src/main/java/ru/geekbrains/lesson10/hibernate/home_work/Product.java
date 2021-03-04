package ru.geekbrains.lesson10.hibernate.home_work;

import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<Purchase> purchases;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Product() {
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void addProductToDb(Session session) {
        System.out.println("Добавляем продукт \"" + name + "\" в БД.");
        session.saveOrUpdate(this);
        System.out.println("Продукт \"" + name + "\" успешно добавлен в БД с ID: " + id);
    }

    public Product getProductFromDb(Session session, Long productId) {
        id = session.get(Product.class, productId).getId();
        name = session.get(Product.class, productId).getName();
        price = session.get(Product.class, productId).getPrice();
        System.out.println("Данные продукта успешно загружены из БД: ID: " + id + ", Название продукта: " + name + ", Цена: " + price + ".");
        return this;
    }
}
