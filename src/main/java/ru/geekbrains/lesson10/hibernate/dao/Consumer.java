package ru.geekbrains.lesson10.hibernate.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consumer")
@NamedQueries({
        @NamedQuery(name = "Consumer.FindAll", query = "SELECT c FROM Consumer c"),
        @NamedQuery(name = "Consumer.FindByName", query = "SELECT c FROM Consumer c WHERE c.firstName = :name"),
        @NamedQuery(name = "Consumer.FindConsumersByProductName", query = "SELECT c FROM Consumer c INNER JOIN c.purchases p WHERE p.product.name = :productName")
})
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @OneToMany(mappedBy = "consumer", orphanRemoval = true)
    private List<Purchase> purchases;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Consumer() {
    }

    public Consumer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Покупатель: %s %s (ID: %d)", firstName, lastName, id);
    }
}
