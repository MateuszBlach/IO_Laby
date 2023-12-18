package businessLayer;

import properties.ApplicationProperties;

import java.util.ArrayList;
import java.util.List;

public class Client extends User{
    private List<Ticket> tickets = new ArrayList<>();

    private String phoneNumber;
    private String city;
    private String adress;

    public Client(String login, String password, String name, String surname,
                  String phoneNumber, String city, String adress) {
        super(login, password, name, surname);
        super.ID = ApplicationProperties.getNextClientID();
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.adress = adress;
    }

    public void buyTicket(){
        //TODO
    }

    public void manageTickets(){
        //TODO
    }

    public List<Ticket> getTickets() {
        return tickets;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}
