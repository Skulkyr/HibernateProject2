import dao.CityDao;
import dao.CountryDao;
import entity.film.*;
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
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;


public class CityTest {
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
            City city = new CityDao(sessionFactory).getCityByName("Moscow");
            System.out.println(city);
        } catch (Exception e) {
            System.err.println("Error with data base");
            e.printStackTrace();
        }

    }
}
