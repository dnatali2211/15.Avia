package ru.netology.avia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AviaSoulsTest {

    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket("Saint-Petersburg", "Toronto", 63_000, 13_00, 20_00);
    Ticket ticket2 = new Ticket("Saint-Petersburg", "Toronto", 52_000, 14_00, 24_00);
    Ticket ticket3 = new Ticket("Saint-Petersburg", "Toronto", 82_000, 3_00, 19_00);
    Ticket ticket4 = new Ticket("Saint-Petersburg", "Toronto", 159_000, 4_00, 23_00);
    Ticket ticket5 = new Ticket("Saint-Petersburg", "Toronto", 63_000, 16_00, 23_00);

    @Test
    void compareToIfLess() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(-1, ticket2.compareTo(ticket3));
    }

    @Test
    void compareToIfMore() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(1, ticket4.compareTo(ticket1));
    }

    @Test
    void compareToIfSame() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(0, ticket1.compareTo(ticket5));
    }

    @Test
    public void testSearch() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket2, ticket1, ticket5, ticket3, ticket4};
        Ticket[] actual = aviaSouls.search("Saint-Petersburg", "Toronto");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testComparatorToIfLess() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(-1, timeComparator.compare(ticket2, ticket4));
    }

    @Test
    void testComparatorToIfMore() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(1, timeComparator.compare(ticket3, ticket5));
    }

    @Test
    void testComparatorToIfSame() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(0, timeComparator.compare(ticket1, ticket5));
    }

    @Test
    public void testSearchAndSortComparator() {

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] expected = {ticket1, ticket5, ticket2, ticket3, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("Saint-Petersburg", "Toronto", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchFindAll() {

        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets);

        Ticket[] expected = {ticket5, ticket4};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSearchAndSortComparatorFindAll() {

        aviaSouls.add(ticket3);
        aviaSouls.add(ticket5);
        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket5, ticket3};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}