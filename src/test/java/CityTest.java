import entity.location.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;


public class CityTest {
    @Test
    public void testImport() {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(entity.location.City.class)
                .addAnnotatedClass(entity.location.Country.class)
                .buildSessionFactory();

        try(Session session = sessionFactory.openSession()) {
            City city = session.get(City.class, 1);
            //Query<City> query = session.createQuery("from City", City.class);
            //City city = query.list().get(0);
            System.out.println(city);
        } catch (Exception e) {
            System.err.println("Error with data base");
            e.printStackTrace();
        }

    }
}
