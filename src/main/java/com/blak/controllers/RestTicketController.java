package com.blak.controllers;

import com.blak.controllers.HandlersException.UserNotFoundException;
import com.blak.model.Ticket;
import com.blak.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class RestTicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/ticket")
    public List<Ticket> getTickets() {
        List<Ticket> tickets = ticketService.getTickets();
        if (tickets.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return tickets;
    }
    @GetMapping("/tickets/csv")
    public void getCsvTickets() throws Exception {
        Path p1 = Paths.get("/tmp/foo");
        ticketService.getCSVTicket(p1);
    }


    @GetMapping("/ticket/{id}")
    public Ticket getTicket(@PathVariable int id) {
        Ticket ticket = ticketService.getTicket(id);
        if (ticket == null) {
            throw new UserNotFoundException("User not found - " + id);
        }
        return ticket;
    }

    @PostMapping("/ticket")
    public void saveTicket(@RequestBody Ticket ticket) {
        ticket.setId(0);
        ticket.setAddTime(LocalDate.now());
        ticketService.saveTicket(ticket);
    }

    @PutMapping("/ticket")
    public void updateTicket(@RequestBody Ticket ticket) {
        ticketService.saveTicket(ticket);
    }

    @DeleteMapping("/ticket/{id}")
    public void deleteUser(@PathVariable int id) {
        Ticket ticket = ticketService.getTicket(id);
        if (ticket == null) {
            throw new UserNotFoundException("User not found - " + id);
        }
        ticketService.deleteTicket(id);
    }


    @GetMapping("/ticket/active")
    public List<Ticket> getActiveTickets() {
        List<Ticket> tickets = ticketService.getActiveTickets();
        if (tickets.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return tickets;
    }

    @PostMapping("/ticket/accept/{id}")
    public void acceptTicket(@PathVariable int id) {
        ticketService.acceptTicket(id);
    }

    @PostMapping("/ticket/reject/{id}")
    public void rejectTicket(@PathVariable int id) {
        ticketService.rejectTicket(id);

    }

    @GetMapping("/ticket/notactive")
    public List<Ticket> getNotActiveTickets() {
        List<Ticket> tickets = ticketService.getNotActiveTickets();
        if (tickets.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return tickets;
    }

    @GetMapping("/ticket/owner/{id}")
    public List<Ticket> getTicketByOwner(@PathVariable int id) {
        List<Ticket> tickets = ticketService.getTicketsByOwner(id);
        if (tickets.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return tickets;
    }
    @GetMapping("/ticket/user/{id}")
    public List<Ticket> getTicketByUser(@PathVariable int id) {
        List<Ticket> tickets = ticketService.getTicketsByUser(id);
        if (tickets.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return tickets;
    }

    @GetMapping("/ticket/notactive/{email}")
    public List<Ticket> getNotActiveTicketsByEmail(@PathVariable String email) {
        List<Ticket> tickets = ticketService.getNotActiveTicketsByEmail(email);
        if (tickets.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return tickets;
    }
    @GetMapping("/ticket/notactive/user/{id}")
    public List<Ticket> getNotActiveTicketsByUser(@PathVariable int id) {
        List<Ticket> tickets = ticketService.getNotActiveTicketsByUser(id);
        if (tickets.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return tickets;
    }
    @GetMapping("/ticket/notactive/owner/{id}")
    public List<Ticket> getNotActiveTicketsByOwner(@PathVariable int id) {
        List<Ticket> tickets = ticketService.getNotActiveTicketsByOwner(id);
        if (tickets.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return tickets;
    }
    @GetMapping("/ticket/notactive/rent/")
    public List<Ticket> getNotActiveTicketRent() {
        List<Ticket> tickets = ticketService.getNotActiveTicketRent();
        if (tickets.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return tickets;
    }
    @GetMapping("/ticket/notactive/scrap/")
    public List<Ticket> getNotActiveTicketScrap() {
        List<Ticket> tickets = ticketService.getNotActiveTicketScrap();
        if (tickets.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return tickets;
    }
}
