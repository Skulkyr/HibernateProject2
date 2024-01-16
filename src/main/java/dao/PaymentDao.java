package dao;

import entity.payment.Payment;
import org.hibernate.SessionFactory;

public class PaymentDao extends GenericDao<Payment> {
    public PaymentDao(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }

    @Override
    public <V extends Number> Payment getById(V id) {
        return super.getById(id.shortValue());
    }
}
