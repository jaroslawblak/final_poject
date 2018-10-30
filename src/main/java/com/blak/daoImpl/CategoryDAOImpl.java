package com.blak.daoImpl;

import com.blak.dao.CategoryDAO;
import com.blak.model.Category;
import com.blak.model.Resource;
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
    public void saveCategory(Category category) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(category);
    }

    @Override
    public boolean deleteCategory(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Category category = currentSession.get(Category.class, id);
        currentSession.delete(category);
        if(currentSession.get(Category.class, id) == null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Category> findCategoryByResource(Resource resource) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Category> theQuery = currentSession.createQuery("from Category where Category.id = :id", Category.class).setParameter("id",resource.getId());
        List<Category> categories = ((org.hibernate.query.Query) theQuery).getResultList();
        return categories;
    }

    @Override
    public List<Category> getCategories() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Category> theQuery = currentSession.createQuery("from Category ", Category.class);
        List<Category> categories = ((org.hibernate.query.Query) theQuery).getResultList();
        return categories;
    }
}
