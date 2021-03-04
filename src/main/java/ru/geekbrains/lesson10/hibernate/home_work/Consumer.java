package ru.geekbrains.lesson10.hibernate.home_work;

import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consumer")
@NamedQueries({
        @NamedQuery(name = "Consumer.findAll", query = "SELECT c FROM Consumer c"),
        @NamedQuery(name = "Consumer.findByName", query = "SELECT c FROM Consumer c WHERE c.firstName = :name")
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

    public void addConsumerToDb(Session session) {
        session.saveOrUpdate(this);
        System.out.println("Покупатель \"" + firstName + " " + lastName + "\" успешно добавлен в БД с ID: " + id);
    }

    public Consumer getConsumerFromDb(Session session, Long consumerId) {
        id = session.get(Consumer.class, consumerId).getId();
        firstName = session.get(Consumer.class, consumerId).getFirstName();
        lastName = session.get(Consumer.class, consumerId).getLastName();
        purchases = session.get(Consumer.class, consumerId).getPurchases();
        System.out.println("Данные покупателя успешно загружены из БД: ID: " + id + ", Имя: " + firstName + ", Фамилия: " + lastName + ".");
        return this;
    }
}
