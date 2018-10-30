package com.blak.daoImpl;

import com.blak.dao.DocumentDAO;
import com.blak.model.Document;
import com.blak.model.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentDAOImpl implements DocumentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Document getDocument(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Document document = currentSession.get(Document.class, id);
        return document;
    }

    @Override
    public void saveDocument(Document document) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(document);
    }

    @Override
    public boolean deleteDocument(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Document document = currentSession.get(Document.class, id);
        currentSession.delete(document);
        if(currentSession.get(Document.class, id) == null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Document> findDocumentByResource(Resource resource) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Document> theQuery = currentSession.createQuery("from Document where Document.resourceId = :id", Document.class).setParameter("id",resource.getId());
        List<Document> documents = ((org.hibernate.query.Query) theQuery).getResultList();
        return documents;
    }

    @Override
    public List<Document> getDocuments() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Document> theQuery = currentSession.createQuery("from Document ", Document.class);
        List<Document> documents = ((org.hibernate.query.Query) theQuery).getResultList();
        return documents;
    }
}
