package ru.geekbrains.lesson10.hibernate.dao;

import org.hibernate.Session;

import java.util.List;

public class ObjectDao<T> {
    private Class<T> cl;

    public ObjectDao(Class<T> cl) {
        this.cl = cl;
    }

    public T findById(Long id) {
        Session session = HibernateUtils.getCurrentSession();
        session.getTransaction().begin();
        T object = session.get(cl, id);
        session.getTransaction().commit();
        return object;
    }

    public List<T> findByName(String name) {
        Session session = HibernateUtils.getCurrentSession();
        session.getTransaction().begin();
        List<T> list = session.createNamedQuery(cl.getSimpleName() + ".FindByName", cl).setParameter("name", name).getResultList();
        session.getTransaction().commit();
        return list;
    }

    public T saveOrUpdate(T object) {
        Session session = HibernateUtils.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(object);
        session.getTransaction().commit();
        return object;
    }

    public List<T> getAll() {
        Session session = HibernateUtils.getCurrentSession();
        session.getTransaction().begin();
        List<T> list = session.createNamedQuery(cl.getSimpleName() + ".FindAll", cl).getResultList();
        session.getTransaction().commit();
        return list;
    }

    public List<T> deleteByName(String name) {
        Session session = HibernateUtils.getCurrentSession();
        session.getTransaction().begin();
        List<T> list = session.createNamedQuery(cl.getSimpleName() + ".FindByName", cl).setParameter("name", name).getResultList();
        if (list.isEmpty()) {
            throw new RuntimeException("\033[0;31m" + "ОШИБКА: Невозможно произвести удаление, т.к. в БД нет ни одной записи с заданным именем \"" + name + "\"." + "\033[0m");
        }
        for (T object : list) {
            session.delete(object);
        }
        session.getTransaction().commit();
        return list;
    }
}