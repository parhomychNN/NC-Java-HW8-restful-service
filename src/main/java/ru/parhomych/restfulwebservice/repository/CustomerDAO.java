package ru.parhomych.restfulwebservice.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.parhomych.restfulwebservice.model.Customer;
import ru.parhomych.restfulwebservice.utils.HibernateUtil;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public class CustomerDAO implements JpaRepository {


    @Override
    public Object save(Object o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = (Customer) o;
        //System.out.println(customer + " <<<<<<<=== Customer Repo");
        session.persist(customer);
        //session.save(customer);
        transaction.commit();
        return customer;
    }

    @Transactional
    @Override
    public Optional findById(Object o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)o;
        Customer customer = session.get(Customer.class, id);
        //System.out.println(customer + "<<<<<<<<<<<<<============== public Optional findById до save");
        //session.save(customer);
        transaction.commit();
        System.out.println(customer);
        return Optional.ofNullable(customer);
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public List findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customersList = session.createQuery("from Customer").list();
        transaction.commit();
        return customersList;
    }

    @Override
    public List findAll(Sort sort) {
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List findAllById(Iterable iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Object o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)o;
        Customer customer = session.load(Customer.class, id);
        session.delete(customer);
        //System.out.println(customer + "<<<<<<<<<<<<<============== public Optional findById до save");
        //session.save(customer);
        transaction.commit();
        System.out.println("Удалён: " + customer);
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void deleteAll(Iterable iterable) {

    }

    @Override
    public void deleteAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from Customer").executeUpdate();

        session.flush();
        transaction.commit();

        System.out.println("Удалёны все записи из таблицы Customers");
    }

    @Override
    public void flush() {

    }

    @Override
    public void deleteInBatch(Iterable iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Object getOne(Object o) {
        return null;
    }

    @Override
    public List findAll(Example example, Sort sort) {
        return null;
    }

    @Override
    public List findAll(Example example) {
        return null;
    }

    @Override
    public Object saveAndFlush(Object o) {
        return null;
    }

    @Override
    public List saveAll(Iterable iterable) {
        return null;
    }

    @Override
    public Optional findOne(Example example) {
        return Optional.empty();
    }

    @Override
    public Page findAll(Example example, Pageable pageable) {
        return null;
    }

    @Override
    public long count(Example example) {
        return 0;
    }

    @Override
    public boolean exists(Example example) {
        return false;
    }
}
