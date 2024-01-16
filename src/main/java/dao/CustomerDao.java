package dao;

import entity.persons.Customer;
import org.hibernate.SessionFactory;

public class CustomerDao extends GenericDao<Customer> {
    public CustomerDao(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }

    @Override
    public <V extends Number> Customer getById(V id) {
        return super.getById(id.shortValue());
    }
}
