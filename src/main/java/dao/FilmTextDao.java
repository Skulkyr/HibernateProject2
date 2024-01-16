package dao;

import entity.film.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDao extends GenericDao<FilmText> {
    public FilmTextDao(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }

    @Override
    public <V extends Number> FilmText getById(V id) {
        return super.getById(id.shortValue());
    }
}
