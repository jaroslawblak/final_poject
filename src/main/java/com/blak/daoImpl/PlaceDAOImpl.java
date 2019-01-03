package com.blak.daoImpl;

import com.blak.dao.PlaceDAO;
import com.blak.model.Place;
import com.blak.model.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceDAOImpl implements PlaceDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Place getPlace(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Place place = currentSession.get(Place.class, id);
        return place;
    }

    @Override
    public void savePlace(Place place) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(place);
    }

    @Override
    public boolean deletePlace(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Place place = currentSession.get(Place.class, id);
        currentSession.delete(place);
        if(currentSession.get(Place.class, id) == null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Place> findPlaceByResource(Resource resource) {
        Session currentSession = sessionFactory.getCurrentSession();
        org.hibernate.query.Query theQuery<Place> theQuery = currentSession.createQuery("from Place where Place.id = :id", Place.class).setParameter("id",resource.getPlaceId());
        List<Place> places = ((org.hibernate.query.Query) theQuery).getResultList();
        return places;
    }

    @Override
    public List<Place> getPlaces() {
        Session currentSession = sessionFactory.getCurrentSession();
        org.hibernate.query.Query<Place> theQuery = currentSession.createQuery("from Place ", Place.class);
        List<Place> places = ((org.hibernate.query.Query) theQuery).getResultList();
        return places;
    }
}
