package com.blak.daoImpl;

import com.blak.dao.TicketDAO;
import com.blak.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Ticket getTicket(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Ticket ticket = currentSession.get(Ticket.class, id);
        return ticket;
    }

    @Override
    public List<Ticket> getTicketsByOwner(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket t where t.active = 1 and t.user.id =:id", Ticket.class).setParameter("id", id);
        List<Ticket> tickets = ((org.hibernate.query.Query) theQuery).getResultList();
        return tickets;
    }

    @Override
    public List<Ticket> getTicketsByUser(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket t where t.active = 1 and t.owner.id =:id", Ticket.class).setParameter("id", id);
        List<Ticket> tickets = ((org.hibernate.query.Query) theQuery).getResultList();
        return tickets;
    }

    @Override
    public List<Ticket> getNotActiveTicketsByOwner(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket t where t.active = 0 and t.user.id =:id", Ticket.class).setParameter("id", id);
        List<Ticket> tickets = ((org.hibernate.query.Query) theQuery).getResultList();
        return tickets;
    }

    @Override
    public List<Ticket> getNotActiveTicketsByUser(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket t where t.active = 0 and t.owner.id =:id", Ticket.class).setParameter("id", id);
        List<Ticket> tickets = ((org.hibernate.query.Query) theQuery).getResultList();
        return tickets;
    }

    @Override
    public List<Ticket> getNotActiveTicketsByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket t where t.active = 0 and t.email =:email", Ticket.class).setParameter("email", email);
        List<Ticket> tickets = ((org.hibernate.query.Query) theQuery).getResultList();
        return tickets;
    }

    @Override
    public void saveTicket(Ticket ticket) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(ticket);
    }

    @Override
    public boolean deleteTicket(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Ticket ticket = currentSession.get(Ticket.class, id);
        currentSession.delete(ticket);
        if (currentSession.get(Ticket.class, id) == null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Ticket> getTickets() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket ", Ticket.class);
        List<Ticket> tickets = ((org.hibernate.query.Query) theQuery).getResultList();
        return tickets;
    }

    @Override
    public List<Ticket> getActiveTickets() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket t where t.active = 1", Ticket.class);
        List<Ticket> tickets = ((org.hibernate.query.Query) theQuery).getResultList();
        return tickets;

    }

    @Override
    public List<Ticket> getNotActiveTickets() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket t where t.active = 0", Ticket.class);
        List<Ticket> tickets = ((org.hibernate.query.Query) theQuery).getResultList();
        return tickets;
    }

    @Override
    public List<Ticket> getNotActiveTicketRent() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket t where t.active = 0 and t.type = 1", Ticket.class);
        List<Ticket> tickets = ((org.hibernate.query.Query) theQuery).getResultList();
        return tickets;
    }

    @Override
    public List<Ticket> getNotActiveTicketScrap() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket t where t.active = 0 and t.type = 0", Ticket.class);
        List<Ticket> tickets = ((org.hibernate.query.Query) theQuery).getResultList();
        return tickets;
    }
    @Override
    public void acceptTicket(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createSQLQuery("UPDATE Ticket t SET t.active = 1 " +
                "WHERE t.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }
    @Override
    public void rejectTicket(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createSQLQuery("UPDATE Ticket t SET t.active = NULL " +
                "WHERE t.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }

}
