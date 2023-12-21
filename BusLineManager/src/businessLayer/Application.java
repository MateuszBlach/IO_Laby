package businessLayer;

import businessLayer.BusLine;
import businessLayer.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static List<User> users = new ArrayList<User>();
    public static List<BusLine> busLines = new ArrayList<>();
    public static int loggedUser = -1;
    public static void main(String[] args) {
        addBusLine(new BusLine(1,5.6));
        addBusLine(new BusLine(2,3.1));
        register(new Administrator("admin","admin","Jan","Kowalski"));
        register(new Client("client","client","Maciej","Bąk","890142842","Wrocław","Sucha  3/15"));
        Scanner scanner = new Scanner(System.in);

        int mainChoice = -1;

        do {
            do{
                System.out.println("Podaj login: ");
                String login = scanner.nextLine();
                System.out.println("Podaj haslo" );
                String password = scanner.nextLine();
                login(login,password);
            }while (loggedUser == -1);
            if(isAdminLogged()){
                Administrator admin = (Administrator)findUser(loggedUser);
            }else{

            }

            //TODO
            // menu dla uzytkownika i admina z wszystkimi akcjami

            //wyswietlenie menu

            user.showMenu();
            switch (mainChoice){

            }




            logOut();
        }while (mainChoice != -1);


        System.out.println(loggedUser);




    }

    public static void addBusLine(BusLine line){
        busLines.add(line);
    }
    public static BusLine findBusLine(int lineNumber) {
        return busLines.stream()
                .filter(busline -> lineNumber == busline.getLineNumber())
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
    public static void updateTicketPrice(int lineNumber, double newPrice){
        busLines.stream()
                .filter(busline -> lineNumber == busline.getLineNumber())
                .findAny()
                .orElse(null)
                .setTicketPrice(newPrice);
    }

    public static void login(String login, String password){
        loggedUser = Objects.requireNonNull(users.stream()
                        .filter(user -> login.equals(user.getLogin()) && password.equals(user.getPassword()))
                        .findAny()
                        .orElse(null))
                        .getID();
    }

    public static  boolean isAdminLogged(){
        User user = findUser(loggedUser);
        return user instanceof Administrator;
    }
    public static void logOut(){
        loggedUser = -1;
    }

    public static void register(User user){
        users.add(user);
    }

    public static void deleteUser(int ID){
        users.remove(findUser(ID));
    }

    public static User findUser(int ID){
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