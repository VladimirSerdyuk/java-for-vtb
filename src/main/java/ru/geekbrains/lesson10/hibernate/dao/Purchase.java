package ru.geekbrains.lesson10.hibernate.dao;

import javax.persistence.*;

@Entity
@Table(name = "purchase")
@NamedQueries({
        @NamedQuery(name = "Purchase.FindAll", query = "SELECT p FROM Purchase p"),
        @NamedQuery(name = "Purchase.FindPurchaseByConsumerAndProduct", query = "SELECT p FROM Purchase p WHERE p.consumerName = :consumerName AND p.productName = :productName")
})
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "purchaseDateTime")
    private String purchaseDateTime;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @Column(name = "consumer_Name")
    private String consumerName;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;

    @Column(name = "product_Name")
    private String productName;

    @Column(name = "product_Price")
    private int productPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public void setPurchaseDateTime(String purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Purchase() {
    }

    public Purchase(String purchaseDateTime, Consumer consumer, String consumerName, Product product, String productName, int productPrice) {
        this.purchaseDateTime = purchaseDateTime;
        this.consumer = consumer;
        this.consumerName = consumerName;
        this.product = product;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}