package ru.parhomych.restfulwebservice.cases;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.parhomych.restfulwebservice.model.Customer;
import ru.parhomych.restfulwebservice.utils.HibernateUtil;

import java.util.List;

public class CaseShowAll {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query q = session.createQuery("from Customer where discount>30");

        List<Customer> customerList = q.list();
        for(Customer customer : customerList){
            System.out.println(customer);
        }

        transaction.commit();

    }

}
