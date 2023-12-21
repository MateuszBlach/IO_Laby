package properties;

public class ApplicationProperties {
    static public int nextPaymentID = 0;
    static public int nextBusLineID = 0;
    static public int nextStationID = 0;
    static public int nextTicketID = 0;
    static public int nextUserID = 0;
    static public  int getNextUserID(){
        int id = nextUserID;
        nextUserID++;
        return id;
    }
    static public int getNextPaymentID(){
        int id = nextPaymentID;
        nextPaymentID++;
        return id;
    }

    static public int getNextBuslineID(){
        int id = nextBusLineID;
        nextBusLineID++;
        return id;
    }
    static public int getNextStationID(){
        int id = nextStationID;
        nextStationID++;
        return id;
    }
    static public int getNextTicketID(){
        int id = nextTicketID;
        nextTicketID++;
        return id;
    }
}
