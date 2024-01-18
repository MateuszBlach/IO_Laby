package businessLayer;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class ClientTest {

    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client("login", "password", "name", "surname", "123456789", "city", "address");
    }

    @Test
    void testConstructor() {
        Assertions.assertNotNull(client);
        Assertions.assertEquals("login", client.getLogin());
        Assertions.assertEquals("password", client.getPassword());
        Assertions.assertEquals("name", client.getName());
        Assertions.assertEquals("surname", client.getSurname());
        Assertions.assertEquals("123456789", client.getPhoneNumber());
        Assertions.assertEquals("city", client.getCity());
        Assertions.assertEquals("address", client.getAdress());
    }

    @Test
    void testSettersAndGetters() {
        client.setLogin("newLogin");
        Assertions.assertEquals("newLogin", client.getLogin());
        client.setPassword("newPassword");
        Assertions.assertEquals("newPassword", client.getPassword());
        client.setName("newName");
        Assertions.assertEquals("newName", client.getName());
        client.setSurname("newSurname");
        Assertions.assertEquals("newSurname", client.getSurname());
        client.setPhoneNumber("987654321");
        Assertions.assertEquals("987654321", client.getPhoneNumber());
        client.setCity("newCity");
        Assertions.assertEquals("newCity", client.getCity());
        client.setAdress("newAddress");
        Assertions.assertEquals("newAddress", client.getAdress());
    }

    @Test
    void testBuyTicket() {
        Ticket ticket = new Ticket("normalny", new BusLine(1, 5.6), new Payment("123"));
        client.buyTicket(ticket);
        Assertions.assertFalse(client.getTickets().isEmpty());
        Assertions.assertEquals(1, client.getTickets().size());
    }

    @Test
    void testBuyingMultipleTickets() {
        // Przygotowanie danych testowych
        Ticket ticket1 = new Ticket("normalny", new BusLine(1, 5.6), new Payment("123"));
        Ticket ticket2 = new Ticket("ulgowy", new BusLine(2, 3.3), new Payment("456"));
        Ticket ticket3 = new Ticket("normalny", new BusLine(3, 4.4), new Payment("789"));

        client.buyTicket(ticket1);
        client.buyTicket(ticket2);
        client.buyTicket(ticket3);

        List<Ticket> tickets = client.getTickets();
        Assertions.assertEquals(3, tickets.size());
        Assertions.assertTrue(tickets.contains(ticket1));
        Assertions.assertTrue(tickets.contains(ticket2));
        Assertions.assertTrue(tickets.contains(ticket3));
    }


}
