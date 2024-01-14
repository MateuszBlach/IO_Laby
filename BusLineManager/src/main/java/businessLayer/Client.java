package businessLayer;

import properties.ApplicationProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends User{
    private List<Ticket> tickets = new ArrayList<>();

    private String phoneNumber;
    private String city;
    private String adress;

    public Client(String login, String password, String name, String surname,
                  String phoneNumber, String city, String adress) {
        super(login, password, name, surname);
        super.ID = ApplicationProperties.getNextUserID();
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.adress = adress;
    }

    public void buyTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public void manageTickets(){
        System.out.println("""
                Wybierz akcje:
                1. Zakup biletu
                2. Sprawdzenie statusu posiadanych biletow
                """);
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.println("Podaj numer lini autobusowej");
                int lineNumber = Integer.parseInt(scanner.nextLine());
                BusLine findBus = Application.findBusLine(lineNumber);
                if(findBus != null){
                    System.out.println("""
                            Wybierz typ biletu
                            1. Normalny
                            2. Ulgowy
                            """);
                    int ticketType = Integer.parseInt(scanner.nextLine());
                    System.out.println("Podaj numer konta:");
                    String accountNumber = scanner.nextLine();
                    Payment payment = new Payment(accountNumber);
                    String type = "";
                    switch (ticketType){
                        case 1:
                            payment.setPrice(findBus.getTicketPrice());
                            type = "normalny";
                            break;
                        case 2:
                            payment.setPrice(findBus.getTicketPrice()/2);
                            type = "ulgowy";
                            break;
                        default:
                            break;
                    }
                    payment.pay();
                    this.buyTicket(new Ticket(type,findBus,payment));
                }
                break;
            case 2:
                for(Ticket ticket : tickets){
                    System.out.println(ticket.toString());
                }
                break;
            default:
                break;
        }
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

    @Override
    public void showMenu() {
        //TODO
    }
}
