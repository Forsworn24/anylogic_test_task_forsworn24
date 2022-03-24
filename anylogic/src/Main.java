package src;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        JsonParser parser = new JsonParser();

        List<DataTickets> ticketsList = parser.parse();

        CalculateBlock calc_time = new CalculateBlock();

        List<Double> flightTimeList = calc_time.getListTime(ticketsList);

        double averageFlightTime = calc_time.getAverageFlightTime(flightTimeList);
        double percentile = calc_time.getPrecentile(flightTimeList, 90);

        System.out.println("Среднее время полёта между городами Владивосток и Тель-Авив : " + averageFlightTime);
        System.out.println("90-й процентиль времени полета между городами  Владивосток и Тель-Авив: " + percentile);

    }
}
