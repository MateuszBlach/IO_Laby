package businessLayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    Station station;

    @BeforeEach
    void setUp() {
        station = new Station("test name", "test location");
    }

    @Test
    @Order(1)
    void getName() {
        assertEquals("test name", station.getName());
    }

    @Test
    @Order(2)
    void setName() {
        station.setName("new name");

        assertEquals("new name", station.getName());
    }

    @Test
    @Order(3)
    void getLocation() {
        assertEquals("test location", station.getLocation());
    }

    @Test
    @Order(4)
    void setLocation() {
        station.setLocation("new location");

        assertEquals("new location", station.getLocation());
    }
}