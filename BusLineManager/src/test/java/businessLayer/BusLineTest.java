package businessLayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("BusLine")
class BusLineTest {

    BusLine busLine;

    @BeforeEach
    void setUp() {
        busLine = new BusLine(15, 2.5);
    }



    @Test
    void getTicketPrice() {
        double value = busLine.getTicketPrice();
        assertEquals(2.5,value);
    }

    @Test
    @Order(1)
    void addStation() {
        Station station = new Station("test", "test");
        busLine.addStation(station);

        int count = busLine.getStations().size();

        assertEquals(1, count);

        Station getStation = busLine.getStations().get(0);

        assertEquals("test", getStation.getName());
        assertEquals("test", getStation.getLocation());
    }

    @Test
    void getStations() {

        List<Station> stations = new ArrayList<>();

        stations.add(new Station("test1", "test1"));
        stations.add(new Station("test2", "test2"));

        List<Station> result = busLine.getStations();

        for (int i = 0; i < result.size(); i++)
        {
            assertEquals(stations.get(i).getName(), result.get(i).getName() );
            assertEquals(stations.get(i).getLocation(), result.get(i).getLocation() );
        }

    }

    @Test
    @Order(2)
    void removeStation() {
        Station station = new Station("test", "test");
        busLine.addStation(station);

        assertFalse(busLine.getStations().size() != 1);

        busLine.removeStation("test");

        assertTrue(busLine.getStations().size() == 0);
    }

    @Test
    void setTicketPrice() {

        busLine.setTicketPrice(5.5);

        assertEquals(5.5, busLine.getTicketPrice());
    }

    @Test
    void getLineNumber() {

        assertEquals(15, busLine.getLineNumber());

    }
}