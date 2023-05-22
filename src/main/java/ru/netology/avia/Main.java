package ru.netology.aviaTickets;

import ru.netology.avia.Ticket;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("Moscow", "Milan", 57_000, 13, 20);
        Ticket ticket2 = new Ticket("Paris", "Istanbul", 63_000, 14, 23);
        Ticket ticket3 = new Ticket("Rome", "Saint-Petersburg", 82_000, 3, 19);
        Ticket ticket4 = new Ticket("Boston", "Dubai", 159_000, 4, 23);
        Ticket ticket5 = new Ticket("Astana", "Abu Dhabi", 63_000, 16, 5);

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);
    }
}