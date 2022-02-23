package ru.netology.ticket;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int time;

    @Override
    public int compareTo(Ticket o) {
        Ticket t = (Ticket) o;
        if (this.price > t.price){
            return -1;
        } else if (this.price < t.price){
            return 1;
        }
         else{
            return 0;
        }
    }

    public Ticket(int id, int price, String from,String to,int time) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public Ticket() {
    }

    public String getTo() {
        return to;}


    public String getFrom() {
        return from;
    }


    public int getId() {
        return id;
    }

}
