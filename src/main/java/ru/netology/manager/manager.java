package ru.netology.manager;

import ru.netology.ticket.Ticket;
import ru.netology.repository.ticketRepository;

import java.util.Arrays;

public class manager {
    private ticketRepository repository;

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                int lenght = result.length + 1;
                Ticket[] tmp = new Ticket[lenght];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from) && ticket.getTo().contains(to)) {
            return true;
        } else {
            return false;
        }
    }

    public manager(ticketRepository repository) {
        this.repository = repository;
    }

    public void saveProduct(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAllProducts(String from, String to) {
        return repository.findAll();
    }

    public Ticket[] removeById(int id) {
        return repository.removeById(id);
    }
}
