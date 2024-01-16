package dao;

import entity.payment.Store;
import org.hibernate.SessionFactory;

public class StoreDao extends GenericDao<Store>{
    public StoreDao(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }

    @Override
    public <V extends Number> Store getById(V id) {
        return super.getById(id.byteValue());
    }
}
