package dao;

import entity.location.Language;
import org.hibernate.SessionFactory;

public class LanguageDao extends GenericDao<Language> {
    public LanguageDao(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }

    @Override
    public <V extends Number> Language getById(V id) {
        return super.getById(id.byteValue());
    }
}
