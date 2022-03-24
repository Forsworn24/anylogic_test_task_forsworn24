package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class CalculateBlock {

    public List<Double> getListTime(List<DataTickets> ticketsList) {

        List<Double> listFlightTime = new ArrayList<>();

        try {
            for (DataTickets tickets : ticketsList) {

                double departure_time =
                        new SimpleDateFormat("dd.MM.yy HH:mm", new Locale("ru"))
                                .parse(tickets.departure_date + " " + tickets.departure_time).getTime();

                double arrival_time =
                        new SimpleDateFormat("dd.MM.yy HH:mm", new Locale("ru"))
                                .parse(tickets.arrival_date + " " + tickets.arrival_time).getTime();

                listFlightTime.add((arrival_time - departure_time) / (1000 * 60));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listFlightTime;
    }

    public double getAverageFlightTime(List<Double> listFlightTime) {

        double average_flight_time = 0;
        double summ_flight_time = 0;

        for (Double it: listFlightTime) {
            summ_flight_time += it;
        }

        average_flight_time = summ_flight_time / listFlightTime.size();

        return average_flight_time;
    }

    public double getPrecentile(List<Double> listFlightTime, int percentile) {

        Collections.sort(listFlightTime);
        return listFlightTime.get((int) Math.ceil(percentile / 100.0 * listFlightTime.size() - 1));
    }

}
