package businessLayer;

import properties.ApplicationProperties;

public class Payment extends StandardObject{
    private String accountNumber;
    private String paymentState;

    private double price;
    public Payment(String accountNumber){
        super();
        this.accountNumber = accountNumber;
        super.ID = ApplicationProperties.getNextPaymentID();
        this.paymentState = "unpaid";
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        if (!"paid".equals(paymentState) && !"unpaid".equals(paymentState) && !"processing".equals(paymentState)) {
            throw new IllegalArgumentException("Nieprawidłowy stan płatności: " + paymentState);
        }
        this.paymentState = paymentState;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Cena nie może być ujemna: " + price);
        }
        this.price = price;
    }


    public void pay(){
        this.paymentState = "paid";
    }
}
