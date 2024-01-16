import dao.CityDao;
import dao.CustomerDao;
import dao.FilmDao;
import entity.film.Category;
import entity.film.Film;
import entity.film.FilmText;
import entity.film.Inventory;
import entity.location.Address;
import entity.location.City;
import entity.location.Country;
import entity.location.Language;
import entity.payment.Payment;
import entity.payment.Rental;
import entity.payment.Store;
import entity.persons.Actor;
import entity.persons.Customer;
import entity.persons.Staff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;


public class FilmTest {

    @Test
    public void testImport() {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Store.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Staff.class)
                .buildSessionFactory();

        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            new CustomerDao(sessionFactory).getById(609);
        } catch (Exception e) {
            System.err.println("Error with data base");
            e.printStackTrace();
        }

    }
}
