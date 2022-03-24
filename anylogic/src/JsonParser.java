package src;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public List<DataTickets> parse() {

        JSONParser parser = new JSONParser();
        List<DataTickets> ticketsList = new ArrayList<>();

        try  {

            Reader reader = new InputStreamReader(new FileInputStream("jsonFiles/tickets.json"));
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONArray ticketsJsonArray = (JSONArray) jsonObject.get("tickets");

            for (Object it: ticketsJsonArray) {
                JSONObject ticketsJsonObject = (JSONObject) it;

                String dep_time = (String) ticketsJsonObject.get("departure_time");
                String dep_date = (String) ticketsJsonObject.get("departure_date");
                String arr_time = (String) ticketsJsonObject.get("arrival_time");
                String arr_date = (String) ticketsJsonObject.get("arrival_date");

                DataTickets ticket = new DataTickets(dep_time, dep_date, arr_time,  arr_date);

                ticketsList.add(ticket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ticketsList;
    }
}
