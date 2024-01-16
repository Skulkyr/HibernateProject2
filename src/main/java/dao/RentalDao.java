package dao;

import entity.payment.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class RentalDao extends GenericDao<Rental> {
    public RentalDao(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }
    
    public Rental getAnyUnreturned() {
        Query<Rental> query = sessionFactory.getCurrentSession()
                .createQuery("select r from Rental r where r.returnDate is null", Rental.class);
        List<Rental> rentalList = query.getResultList();
        if (rentalList.isEmpty())
            return null;
        return rentalList.get((int) Math.random() * rentalList.size());
    }
}
