package ru.netology.manager;

import ru.netology.ticket.Ticket;
import ru.netology.repository.ticketRepository;

public class manager {
    private ticketRepository repository;

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;// "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
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
