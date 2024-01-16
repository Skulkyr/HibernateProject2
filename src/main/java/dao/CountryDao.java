package dao;

import entity.location.Country;
import org.hibernate.SessionFactory;

public class CountryDao extends GenericDao<Country>{
    public CountryDao(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }

    @Override
    public <V extends Number> Country getById(V id) {
        return super.getById(id.shortValue());
    }
}
