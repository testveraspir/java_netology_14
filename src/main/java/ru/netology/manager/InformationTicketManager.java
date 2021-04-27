package ru.netology.manager;

import ru.netology.domain.InformationTicket;
import ru.netology.repository.InformationTicketRepository;

public class InformationTicketManager {
    private InformationTicketRepository repository;
    private String from;
    private String to;

    public InformationTicketManager(InformationTicketRepository repository) {
        this.repository = repository;
    }

    public InformationTicket[] searchByAirport(String from, String to) {
        InformationTicket[] tickets = repository.findAll();
        int count = 0;
        for (InformationTicket ticket : tickets) {
            if (from.equalsIgnoreCase(ticket.getDepartureAirport()) && to.equalsIgnoreCase(ticket.getArrivalAirport()))
                count++;
        }
        InformationTicket[] result = new InformationTicket[count];
        int index = 0;
        for (InformationTicket ticket : tickets) {
            if (from.equalsIgnoreCase(ticket.getDepartureAirport()) && to.equalsIgnoreCase(ticket.getArrivalAirport())) {
                result[index] = ticket;
                index++;
            }
        }
        return result;
    }
}







