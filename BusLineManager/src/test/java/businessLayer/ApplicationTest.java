package businessLayer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ApplicationTest {
    @Test
    void addBusLine() {
        int sizeBeforeAdding = Application.getBusLines().size();
        Application.addBusLine(new BusLine(1,5.6));
        assertEquals(sizeBeforeAdding+1,Application.getBusLines().size());
    }

    @Test
    void deleteBusLine() {
        Application.addBusLine(new BusLine(1,5.6));
        int sizeBeforeDeleting = Application.getBusLines().size();
        Application.deleteBusLine(1);
        assertEquals(sizeBeforeDeleting-1,Application.getBusLines().size());
    }

    @Test
    void updateTicketPrice() {
        Application.addBusLine(new BusLine(1,5.6));
        double newPrice = 5.5;
        Application.updateTicketPrice(1,newPrice);
        assertEquals(newPrice,Application.getBusLines().get(0).getTicketPrice());
    }
}