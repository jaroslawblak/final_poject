package com.blak.service;

import com.blak.model.Ticket;

import java.util.List;

public interface TicketService {
    public void saveTicket(Ticket ticket);
    public void acceptTicket(int id);
    public void rejectTicket(int id);
    public boolean deleteTicket (int id);
    public List<Ticket> getTickets();
    public Ticket getTicket(int id);
    public List<Ticket> getTicketsByUser(int id);
    public List<Ticket> getTicketsByOwner(int id);
    public List<Ticket> getNotActiveTicketsByOwner(int id);
    public List<Ticket> getNotActiveTicketsByUser(int id);
    public List<Ticket> getNotActiveTicketsByEmail(String email);
    public List<Ticket> getActiveTickets();
    public List<Ticket> getNotActiveTickets();
    public List<Ticket> getNotActiveTicketRent();
    public List<Ticket> getNotActiveTicketScrap();

}
