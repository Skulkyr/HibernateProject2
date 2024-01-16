package dao;

import entity.persons.Actor;
import org.hibernate.SessionFactory;

public class ActorDao extends GenericDao<Actor> {
    public ActorDao(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }

    @Override
    public <V extends Number> Actor getById(V id) {
        return super.getById(id.shortValue());
    }
}
