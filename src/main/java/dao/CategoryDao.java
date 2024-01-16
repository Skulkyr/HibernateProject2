package dao;

import entity.film.Category;
import org.hibernate.SessionFactory;

public class CategoryDao extends GenericDao<Category> {

    public CategoryDao(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }

    @Override
    public <V extends Number> Category getById(V id) {
        return super.getById(id.byteValue());
    }
}
