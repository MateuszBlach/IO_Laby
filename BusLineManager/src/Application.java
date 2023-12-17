import businessLayer.BusLine;
import businessLayer.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static List<User> users = new ArrayList<User>();
    public static List<BusLine> busLines = new ArrayList<>();
    public int loggedUser = -1;
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void addBusLine(BusLine line){
        busLines.add(line);
    }
    public static BusLine findBusLine(String lineNumber){
        return busLines.stream()
                .filter(busline -> lineNumber.equals(busline.getLineNumber()))
                .findAny()
                .orElse(null);
    }

    public static List<BusLine> getBusLines(){
        return busLines;
    }
    public static void deleteBusLine(int lineID){
        busLines.remove(busLines.stream()
                .filter(busLine -> lineID == busLine.getID())
                .findAny()
                .orElse(null)
        );
    }
    public static void updateLine(BusLine line){
        //TODO
    }
    public static void updateTicketPrice(String lineNumber, double newPrice){
        busLines.stream()
                .filter(busline -> lineNumber.equals(busline.getLineNumber()))
                .findAny()
                .orElse(null)
                .setTicketPrice(newPrice);
    }

    public void login(String login, String password){
        loggedUser = Objects.requireNonNull(users.stream()
                        .filter(user -> login.equals(user.getLogin()) && password.equals(user.getPassword()))
                        .findAny()
                        .orElse(null))
                        .getID();
    }

    public void logOut(){
        loggedUser = -1;
    }

    public void register(User user){
        users.add(user);
    }

    public void deleteUser(int ID){
        users.remove(findUser(ID));
    }

    public User findUser(int ID){
        return users.stream()
                .filter(user -> ID == user.getID())
                .findAny()
                .orElse(null);
    }

    public void updateUserData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID uzytkownika ktorego chcesz zmodyfikowac: ");
        int ID = Integer.parseInt(scanner.nextLine());
        User user = findUser(ID);
    }
}