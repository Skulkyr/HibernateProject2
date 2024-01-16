package dao;

import entity.persons.Staff;
import org.hibernate.SessionFactory;

public class StaffDao extends GenericDao<Staff> {
    public StaffDao(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }

    @Override
    public <V extends Number> Staff getById(V id) {
        return super.getById(id.byteValue());
    }
}
