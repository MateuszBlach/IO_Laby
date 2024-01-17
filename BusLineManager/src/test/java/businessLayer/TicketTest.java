package businessLayer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void isValid() {
        Ticket ticket = new Ticket("normalny",new BusLine(1,5.2),new Payment("123"));
        assertEquals(true,ticket.isValid());
    }
}