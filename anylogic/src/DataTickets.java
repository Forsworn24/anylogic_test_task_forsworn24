package src;

public class DataTickets {
    public String departure_time;
    public String departure_date;
    public String arrival_time;
    public String arrival_date;

    public DataTickets(String departure_time, String departure_date, String arrival_time,  String arrival_date) {
        this.departure_time = departure_time;
        this.departure_date = departure_date;
        this.arrival_time = arrival_time;
        this.arrival_date = arrival_date;
    }

    @Override
    public String toString() {
        return " departure date: " + departure_date +
                " departure time: " + departure_time +
                " arrival date: " + arrival_date +
                " arrival time: " + arrival_time;
    }
}
