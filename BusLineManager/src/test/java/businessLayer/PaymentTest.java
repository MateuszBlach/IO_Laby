package businessLayer;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class PaymentTest {
    private Payment payment;

    @BeforeEach
    void setUp() { payment = new Payment("123456789"); }

    @Test
    void testPaymentConstructor(){
        Assertions.assertNotNull(payment);
        Assertions.assertEquals("123456789", payment.getAccountNumber());
        Assertions.assertEquals("unpaid", payment.getPaymentState());
    }

    @Test
    public void testGettersAndSetters() {
        payment.setAccountNumber("987654321");
        Assertions.assertEquals("987654321", payment.getAccountNumber());
        payment.setPaymentState("processing");
        Assertions.assertEquals("processing", payment.getPaymentState());
        payment.setPrice(100.0);
        Assertions.assertEquals(100.0, payment.getPrice(), 0.001);
    }

    @Test
    public void testPaymentMethod() {
        payment.setPaymentState("processing");
        Assertions.assertEquals("processing", payment.getPaymentState());
        payment.pay();
        Assertions.assertEquals("paid", payment.getPaymentState());
    }

    @Test
    public void testSetPriceWithEdgeCases() {
        Payment payment = new Payment("1234567890");

        payment.setPrice(0);
        Assertions.assertEquals(0, payment.getPrice(), 0.001);

        payment.setPrice(Double.MAX_VALUE);
        Assertions.assertEquals(Double.MAX_VALUE, payment.getPrice(), 0.001);
    }

    @Test
    public void testSetPriceWithNegativeValueThrowsException() {
        Payment payment = new Payment("1234567890");

        // Sprawdzanie, czy rzucany jest wyjątek IllegalArgumentException przy ujemnej cenie
        IllegalArgumentException thrown = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> payment.setPrice(-10.0),
                "Powinien zostać rzucony wyjątek IllegalArgumentException, gdy cena jest ujemna"
        );

        // (Opcjonalnie) Sprawdzanie, czy komunikat wyjątku jest odpowiedni
        Assertions.assertTrue(thrown.getMessage().contains("Cena nie może być ujemna"));
    }
    @Test
    public void testSetPaymentStateWithValidStates() {
        payment.setPaymentState("paid");
        Assertions.assertEquals("paid", payment.getPaymentState());

        payment.setPaymentState("unpaid");
        Assertions.assertEquals("unpaid", payment.getPaymentState());

        payment.setPaymentState("processing");
        Assertions.assertEquals("processing", payment.getPaymentState());
    }

    @Test
    public void testSetPaymentStateWithInvalidState() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            payment.setPaymentState("invalidState");
        });
        
        String expectedMessage = "Nieprawidłowy stan płatności: invalidState";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}