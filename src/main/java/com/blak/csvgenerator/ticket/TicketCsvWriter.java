package com.blak.csvgenerator.ticket;

import com.blak.model.Ticket;
import com.blak.service.TicketService;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class TicketCsvWriter {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketCSVMapper ticketCSVMapper;

    private static final String CSV_TITLE = "./KRIM-Tickets.csv";

    public void writeCsv(Path path) throws Exception {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_TITLE))) {
            List<Ticket> tickets = ticketService.getTickets();
            List<CsvTicket> csvTickets = ticketCSVMapper.toCsvTicket(tickets);

            final CustomMappingStrategy<CsvTicket> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(CsvTicket.class);

            final StatefulBeanToCsv<CsvTicket> beanToCsv = new StatefulBeanToCsvBuilder<CsvTicket>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            beanToCsv.write(csvTickets);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[] {"ID", "First Name", "Last Name", "Email", "Tel", "Type", "Active", "AddTime", "DateFrom", "DateTo", "Note", "UserID","OwnerID","ResourceID",};

    @Override
    public String[] generateHeader() {
        return HEADER;
    }
}
