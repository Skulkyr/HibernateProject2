package dao;

import entity.location.Address;
import org.hibernate.SessionFactory;

public class AddressDao extends GenericDao<Address>{
    public AddressDao(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }

    @Override
    public <V extends Number> Address getById(V id) {
        return super.getById(id.shortValue());
    }

}
