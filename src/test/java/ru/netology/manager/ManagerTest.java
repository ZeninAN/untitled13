package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private final Manager man = new Manager(new TicketRepository());
    private final Ticket first = new Ticket(1, 400, "LED", "KUF", 4);
    private final Ticket second = new Ticket(2, 300, "KUF", "LED", 7);
    private final Ticket third = new Ticket(3, 130, "OGZ", "GOJ", 9);
    private final Ticket four = new Ticket(4, 400, "LED", "KUF", 6);
    private final Ticket fifth = new Ticket(5, 600, "GOJ", "KUF", 2);
    private final Ticket six = new Ticket(5, 450, "GOJ", "KUF", 3);
    private final Ticket seven = new Ticket(5, 100, "GOJ", "KUF", 1);

    @Test
    public void search() {
        man.saveProduct(first);
        man.saveProduct(second);
        man.saveProduct(third);

        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = man.searchBy("LED", "KUF");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void search2() {
        man.saveProduct(first);

        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = man.searchBy("LED", "KUF");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void search3() {

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = man.searchBy("LED", "KUF");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void sort() {
        man.saveProduct(first);
        man.saveProduct(second);
        man.saveProduct(third);

        Ticket[] expected = new Ticket[]{third, second, first};
        Ticket[] actual = new Ticket[]{second, third, first};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void sort3() {
        man.saveProduct(first);
        man.saveProduct(second);
        man.saveProduct(third);
        man.saveProduct(fifth);
        man.saveProduct(six);
        man.saveProduct(seven);

        Ticket[] expected = new Ticket[]{seven,third, second, first,six,fifth};
        Ticket[] actual = new Ticket[]{third,seven,first,second,fifth,six};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void sort2() {
        man.saveProduct(first);
        man.saveProduct(four);

        Ticket[] expected = new Ticket[]{first, four};
        Ticket[] actual = new Ticket[]{first, four};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        man.saveProduct(first);
        man.saveProduct(third);
        man.saveProduct(second);

        man.removeById(2);

        Ticket[] expected = new Ticket[]{first, third};
        Ticket[] actual = new Ticket[]{first, third};


        assertArrayEquals(expected, actual);
    }

}
