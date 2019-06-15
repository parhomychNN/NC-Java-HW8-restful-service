package ru.parhomych.restfulwebservice.cases;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.parhomych.restfulwebservice.model.Customer;
import ru.parhomych.restfulwebservice.utils.HibernateUtil;

public class CaseFetch {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = (Customer) session.get(Customer.class, 1);

        session.save(customer);
        transaction.commit();
        System.out.println(customer);
    }
}
