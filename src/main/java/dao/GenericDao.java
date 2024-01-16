package dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public abstract class GenericDao<T>  {
    private final Class<T> clazz;
    protected final SessionFactory sessionFactory;

    public GenericDao(Class<T> clazz, SessionFactory sessionFactory) {
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
    }

    public <V extends Number> T getById(V id) {
        System.out.println(sessionFactory.getCurrentSession().getTransaction().isActive());
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }

    public List<T> getItems(int offset, int count) {
        Query query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName(), clazz);
        query.setFirstResult(offset);
        query.setMaxResults(count);
        return query.getResultList();
    }

    public T save(T entity) {
        sessionFactory.getCurrentSession().persist(entity);
        return entity;
    }


    public void deleteEntity(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }


    public void deleteById(int id) {
        sessionFactory.getCurrentSession().delete(getById(id));
    }
}
