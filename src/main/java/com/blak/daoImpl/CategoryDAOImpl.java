package com.blak.daoImpl;

import com.blak.dao.CategoryDAO;
import com.blak.model.Category;
import com.blak.model.ResourceOfResource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Category getCategory(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Category category = currentSession.get(Category.class, id);
        return category;
    }

    @Override
    public Category getCategoryByName(String name) {
        Query query= sessionFactory.getCurrentSession().
                createQuery("from Category where name=:name");
        query.setParameter("name", name);
        Category category = (Category) query.uniqueResult();
        return category;
    }

    @Override
    public void saveCategory(Category category) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(category);
    }

    @Override
    public boolean deleteCategory(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Category category = currentSession.get(Category.class, id);
        currentSession.delete(category);
        if (currentSession.get(Category.class, id) == null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Category> findCategoryByResource(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Category> theQuery = currentSession.createQuery(
                "FROM Category AS c JOIN ResourceCategory AS r ON c.id = r.categoryId WHERE r.resourceId = :id");
        List<Category> categories = ((org.hibernate.query.Query) theQuery).list();
        return null;
    }

    @Override
    public List<Category> getCategories() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Category> theQuery = currentSession.createQuery("from Category ", Category.class);
        List<Category> categories = ((org.hibernate.query.Query) theQuery).getResultList();
        return categories;
    }
}
