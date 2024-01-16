package dao;

import entity.film.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FilmDao extends GenericDao<Film>{
    public FilmDao(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    @Override
    public <V extends Number> Film getById(V id) {
        return super.getById(id.shortValue());
    }

    public Film getFirstAvailableFilmToRent() {
        Query<Film> query = sessionFactory.getCurrentSession()
                .createQuery("select f from Film f where f.id not in (select distinct film.id from Inventory)");
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
