package businessLayer;

import properties.ApplicationProperties;

public class Payment extends StandardObject{
    private String accountNumber;
    private String paymentState;
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
        this.paymentState = paymentState;
    }
}
