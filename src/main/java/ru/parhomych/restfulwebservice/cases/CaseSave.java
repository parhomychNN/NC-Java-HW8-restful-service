package ru.parhomych.restfulwebservice.cases;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;
import ru.parhomych.restfulwebservice.model.Customer;
import ru.parhomych.restfulwebservice.utils.HibernateUtil;

public class CaseSave {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setLastname("Вася");
        customer.setDiscount(30.3);
        customer.setDistrict("Приокский");

        session.save(customer);
        transaction.commit();

    }

}
