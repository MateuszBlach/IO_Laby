package businessLayer;

import properties.ApplicationProperties;

import java.util.Scanner;

public class Administrator extends User {
    public Administrator(String login, String password, String name, String surname) {
        super(login,password,name,surname);
        super.ID = ApplicationProperties.getNextAdminID();
    }

    private void deleteUser(int userID){
        Application.deleteUser(userID);
    }

    private void manageBusLinesTimetables(){
        System.out.println("""
                Wybierz akcje:
                1. Modyfikacja cen
                2. Modyfikacja lini autobusowych
                """);
        Scanner scanner = new Scanner(System.in);
        int lineNumber;
        BusLine busLine;
        double newPrice;
        int lineID;
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.println("Podaj numer lini autobusowej");
                lineNumber = Integer.parseInt(scanner.nextLine());
                busLine = Application.findBusLine(lineNumber);
                if(busLine != null){
                    System.out.println("Podaj nowa cene biletu");
                    newPrice = Double.parseDouble(scanner.nextLine());
                    busLine.setTicketPrice(newPrice);
                }
                break;
            case 2:
                System.out.println("""
                        Wybierz akcje:
                        1. Dodanie nowej lini autobusowej
                        2. Usunięcie lini autobusowej
                        3. Modyfikacja lini autobusowej
                        """);
                int secondChoice = Integer.parseInt(scanner.nextLine());
                switch (secondChoice){
                    case 1:
                        System.out.println("Podaj numer lini autobusowej");
                        lineNumber = Integer.parseInt(scanner.nextLine());
                        busLine = Application.findBusLine(lineNumber);
                        if(busLine != null){
                            System.out.println("Podaj cene biletu");
                            newPrice = Double.parseDouble(scanner.nextLine());
                            Application.addBusLine(new BusLine(lineNumber,newPrice));
                        }
                        break;
                    case 2:
                        System.out.println("Podaj ID lini autobusowej");
                        lineID = Integer.parseInt(scanner.nextLine());
                        Application.deleteBusLine(lineID);
                        break;
                    case 3:
                        System.out.println("Podaj numer lini autobusowej");
                        lineNumber = Integer.parseInt(scanner.nextLine());
                        BusLine updateLine = Application.findBusLine(lineNumber);
                        if(updateLine == null) break;
                        System.out.println("""
                                Wybierz akcje:
                                1. Dodaj stacje do lini autobusowej
                                2. Usun stacje z lini autobusowej
                                """);
                        int thirdChoice = Integer.parseInt(scanner.nextLine());
                        String name;
                        switch (thirdChoice){
                            case 1:
                                System.out.println("Podaj nazwe stacji");
                                name = scanner.nextLine();
                                System.out.println("Podaj lokalizacje");
                                String location = scanner.nextLine();
                                updateLine.addStation(new Station(name,location));
                                break;
                            case 2:
                                System.out.println("Podaj nazwe stacji");
                                name = scanner.nextLine();
                                updateLine.removeStation(name);
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }


    }
}
