package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ticketRepository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class managerTest {
    private manager man = new manager(new ticketRepository());
    private Ticket first = new Ticket(1, 400, "LED", "KUF", 4);
    private Ticket second = new Ticket(2, 300, "KUF", "LED", 4);
    private Ticket third = new Ticket(3, 130, "OGZ", "GOJ", 4);
    private Ticket four = new Ticket(4, 400, "LED", "KUF", 6);

    @Test
    public void search() {
        man.saveProduct(first);
        man.saveProduct(second);

        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = man.searchBy("LED", "KUF");

        assertArrayEquals(expected, actual);
    }
    @Test
    public void sort() {
        man.saveProduct(first);
        man.saveProduct(second);

        Ticket[] expected = new Ticket[]{first,second};
        Ticket[] actual = new Ticket[]{second,first};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void sort2() {
        man.saveProduct(first);
        man.saveProduct(four);

        Ticket[] expected = new Ticket[]{first,four};
        Ticket[] actual = new Ticket[]{first,four};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void sort3() {
        man.saveProduct(first);
        man.saveProduct(third);

        Ticket[] expected = new Ticket[]{first,third};
        Ticket[] actual = new Ticket[]{first,third};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void removeById() {
        man.saveProduct(first);
        man.saveProduct(third);
        man.saveProduct(second);

        man.removeById(2);

        Ticket[] expected = new Ticket[]{first,third};
        Ticket[] actual = new Ticket[]{first,third};


        assertArrayEquals(expected, actual);
    }
}
