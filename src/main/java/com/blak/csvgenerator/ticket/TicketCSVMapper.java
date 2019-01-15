package com.blak.csvgenerator.ticket;

import com.blak.model.Ticket;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class TicketCSVMapper implements Serializable {
    public TicketCSVMapper() {
    }

    public static CsvTicket toCsvTicket(Ticket ticket){
        if(ticket == null) {
            return null;
        }
        CsvTicket csvTicket = new CsvTicket();

        csvTicket.setId(ticket.getId());
        csvTicket.setFirstName(ticket.getFirstName());
        csvTicket.setLastName(ticket.getLastName());
        csvTicket.setEmail(ticket.getEmail());
        csvTicket.setTel(ticket.getTel());
        csvTicket.setType(ticket.getType());
        csvTicket.setActive(ticket.getActive());
        csvTicket.setAddTime(ticket.getAddTime());
        csvTicket.setDateFrom(ticket.getDateFrom());
        csvTicket.setDateTo(ticket.getDateTo());
        csvTicket.setNote(ticket.getNote());

        if (ticket.getUser() != null) {
            csvTicket.setUserId(ticket.getUser().getId());
        }
        if (ticket.getOwner() != null) {
            csvTicket.setOwnerId(ticket.getOwner().getId());
        }
        if (ticket.getResource() != null) {
            csvTicket.setResourceId(ticket.getResource().getId());
        }

        return csvTicket;
    }


    public List<CsvTicket> toCsvTicket(List<Ticket> tickets){
        if(tickets == null){
            return null;
        }
        List<CsvTicket> csvTickets = new ArrayList<>();
        for(Ticket ticket: tickets){
            CsvTicket tempCsvTicket = this.toCsvTicket(ticket);
            csvTickets.add(tempCsvTicket);
        }
        return csvTickets;
    }
}
