package businessLayer;

import mockit.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ApplicationTest {

    @BeforeEach
    void setUp()
    {
        Application.busLines = new ArrayList<>();
        Application.users = new ArrayList<>();
        Application.loggedUser = -1;
    }

    @Test
    void getBusLines() {

        assertEquals(0,Application.getBusLines().size());

        List<BusLine> lines = new ArrayList<>();
        lines.add(new BusLine(1,5.6));
        lines.add(new BusLine(2,2.5));
        lines.add(new BusLine(3,8.0));
        lines.add(new BusLine(4,3.3));

        Application.addBusLine(new BusLine(1,5.6));
        Application.addBusLine(new BusLine(2,2.5));
        Application.addBusLine(new BusLine(3,8.0));
        Application.addBusLine(new BusLine(4,3.3));

        List<BusLine> result = Application.getBusLines();

        for (int i = 0; i < result.size(); i++)
        {
            assertEquals(lines.get(i).getLineNumber(), result.get(i).getLineNumber());
        }

    }

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

    @ParameterizedTest
    @CsvSource({"0","1", "2", "3", "4", "5"})
    void findBusLine(int number) {
        Application.addBusLine(new BusLine(1,5.6));
        Application.addBusLine(new BusLine(2,2.5));
        Application.addBusLine(new BusLine(3,8.0));
        Application.addBusLine(new BusLine(4,3.3));

        if(number>0 && number< 5)
            assertNotNull(Application.findBusLine(number));
        else
            assertNull(Application.findBusLine(number));

    }

    @Test
    void login() {
        Application.register(new Client("client","client","Maciej","Bąk","890142842","Wrocław","Sucha  3/15"));

        assertEquals(-1, Application.loggedUser);

        Application.login("client", "client");

        assertNotEquals(-1, Application.loggedUser);

    }

    @Test
    void isAdminLogged() {
        Application.register(new Client("client","client","Maciej","Bąk","890142842","Wrocław","Sucha  3/15"));
        Application.register(new Administrator("admin","admin","Jan","Kowalski"));

        Application.login("client", "client");

        assertFalse(Application.isAdminLogged());

        Application.login("admin", "admin");

        assertTrue(Application.isAdminLogged());

    }

    @Test
    void logOut() {
        Application.loggedUser = 5;

        Application.logOut();

        assertEquals(-1, Application.loggedUser);
    }

    @Test
    void register() {
        Administrator admin = new Administrator("admin","admin","Jan","Kowalski");
        Application.register(admin);

        assertEquals(1 ,Application.users.size());
        assertTrue(Application.users.contains(admin));

    }

    @Test
    void deleteUser() {

    }

    @Test
    void findUser() {

    }

    @Test
    void updateUserData() {
    }
}