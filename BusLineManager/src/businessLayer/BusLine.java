package businessLayer;

import properties.ApplicationProperties;

import java.util.ArrayList;
import java.util.List;

public class BusLine extends StandardObject{
    private List<Station> stations;
    private final int lineNumber;
    private double ticketPrice;

    public BusLine(int lineNumber,double ticketPrice){
        super();
        this.lineNumber = lineNumber;
        this.ticketPrice = ticketPrice;
        this.stations = new ArrayList<>();
        super.ID = ApplicationProperties.getNextBuslineID();
    }
    public List<Station> getStations() {
        return stations;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void addStation(Station station){
        this.stations.add(station);
    }

    public void removeStation(Station station){
        this.stations.remove(station);
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public int getLineNumber() {
        return lineNumber;
    }
}
