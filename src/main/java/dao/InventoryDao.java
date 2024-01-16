package dao;

import entity.film.Inventory;
import org.hibernate.SessionFactory;

public class InventoryDao extends GenericDao<Inventory> {
    public InventoryDao(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}
