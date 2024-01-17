package businessLayer;

import properties.ApplicationProperties;

import java.time.LocalDateTime;

public class Ticket extends StandardObject{
    private String status;
    private String type;
    private LocalDateTime expirationDate;
    private BusLine line;
    private Payment payment;

    public Ticket(String type, BusLine line, Payment payment){
        super();
        super.ID = ApplicationProperties.getNextTicketID();
        this.type = type;
        this.line = line;
        this.payment = payment;
        this.expirationDate = LocalDateTime.now().plusHours(1);
    }

    boolean isValid(){
        return this.expirationDate.isAfter(super.getTimeCreated());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BusLine getLine() {
        return line;
    }

    public void setLine(BusLine line) {
        this.line = line;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "status='" + status + '\'' +
                ", typ='" + type + '\'' +
                ", data wygasniecia=" + expirationDate +
                ", linia=" + line.getLineNumber() +
                ", status platnosci=" + payment.getPaymentState() +
                ", ID=" + ID +
                '}';
    }
}
