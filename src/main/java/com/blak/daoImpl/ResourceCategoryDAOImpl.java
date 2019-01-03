package com.blak.daoImpl;

import com.blak.dao.ResourceCategoryDAO;
import com.blak.model.Category;
import com.blak.model.ResourceCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceCategoryDAOImpl implements ResourceCategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ResourceCategory getResourceCategory(int id) {
        return null;
    }

    @Override
    public void saveResourceCategory(ResourceCategory resourceCategory) {

    }

    @Override
    public boolean deleteResourceCategory(int id) {
        return false;
    }

    @Override
    public List<ResourceCategory> findCategoriesByResource(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public List<ResourceCategory> findResourceByCategory(int id) {
        return null;
    }

    @Override
    public List<ResourceCategory> getResources() {
        return null;
    }


    public List<Category> getCategoriesOfResource(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Category> categories = currentSession.createQuery(
                "select cat from Category cat" +
                        " join cat.resourceCategories rc where rc.resourceId ="+id).getResultList();
        return categories;
    }

    @Override
    public void updateCategoriesForResource(int id, List<Integer> categoryIds) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createSQLQuery("DELETE FROM res2category " +
                "WHERE resourceId =:id")
                .setParameter("id", id)
        .executeUpdate();
        for (int catId:categoryIds) {
            currentSession.createSQLQuery("INSERT INTO res2category " +
                    "(resourceId, categoryId) VALUES (:resId, :catId)")
                    .setParameter("resId", id)
                    .setParameter("catId", catId)
            .executeUpdate();
        }
    }
}
