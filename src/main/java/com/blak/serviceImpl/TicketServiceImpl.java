package com.blak.serviceImpl;

import com.blak.csvgenerator.ticket.TicketCsvWriter;
import com.blak.dao.TicketDAO;
import com.blak.model.Ticket;
import com.blak.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO ticketDAO;

    @Autowired
    private TicketCsvWriter ticketCsvWriter;

    @Override
    @Transactional
    public void saveTicket(Ticket ticket) {
        ticketDAO.saveTicket(ticket);
    }

    @Override
    @Transactional
    public void acceptTicket(int id) {
        ticketDAO.acceptTicket(id);
    }

    @Override
    @Transactional
    public void rejectTicket(int id) {
        ticketDAO.rejectTicket(id);
    }

    @Override
    @Transactional
    public boolean deleteTicket(int id) {
        return ticketDAO.deleteTicket(id);
    }

    @Override
    @Transactional
    public List<Ticket> getTickets() {
        return ticketDAO.getTickets();
    }

    @Override
    @Transactional
    public Ticket getTicket(int id) {
        return ticketDAO.getTicket(id);
    }

    @Override
    @Transactional
    public void getCSVTicket(Path path) throws Exception {
        this.ticketCsvWriter.writeCsv(path);
    }

    @Override
    @Transactional
    public List<Ticket> getTicketsByUser(int id) {
        return ticketDAO.getTicketsByUser(id);
    }

    @Override
    @Transactional
    public List<Ticket> getTicketsByOwner(int id) {
        return ticketDAO.getTicketsByOwner(id);
    }

    @Override
    @Transactional
    public List<Ticket> getNotActiveTicketsByOwner(int id) {
        return ticketDAO.getNotActiveTicketsByOwner(id);
    }

    @Override
    @Transactional
    public List<Ticket> getNotActiveTicketsByUser(int id) {
        return ticketDAO.getNotActiveTicketsByUser(id);
    }

    @Override
    @Transactional
    public List<Ticket> getNotActiveTicketsByEmail(String email) {
        return ticketDAO.getNotActiveTicketsByEmail(email);
    }

    @Override
    @Transactional
    public List<Ticket> getActiveTickets() {
        return ticketDAO.getActiveTickets();
    }
    @Override
    @Transactional
    public List<Ticket> getNotActiveTickets() {
        return ticketDAO.getActiveTickets();
    }

    @Override
    @Transactional
    public List<Ticket> getNotActiveTicketRent() {
        return this.ticketDAO.getNotActiveTicketRent();
    }

    @Override
    @Transactional
    public List<Ticket> getNotActiveTicketScrap() {
        return this.ticketDAO.getNotActiveTicketScrap();
    }
}
