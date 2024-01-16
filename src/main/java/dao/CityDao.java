package dao;

import entity.location.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class CityDao extends GenericDao<City>{
    public CityDao(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getCityByName(String name) {
            Session session = sessionFactory.getCurrentSession();
            Query<City> query = session.createQuery("select c from City c where c.city = :name", City.class);
            query.setParameter("name", name);
            return query.getResultList().get(0);
    }

    @Override
    public <V extends Number> City getById(V id) {
        return super.getById(id.shortValue());
    }
}
