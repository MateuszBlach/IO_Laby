package properties;

public class ApplicationProperties {
    static public int nextAdminID = 0;
    static public int nextPaymentID = 0;
    static public int nextBuslineID = 0;
    static public int nextStationID = 0;
    static public int nextTicketID = 0;
    static public int getNextAdminID(){
        int id = nextAdminID;
        nextAdminID++;
        return id;
    }
    static public int getNextPaymentID(){
        int id = nextPaymentID;
        nextPaymentID++;
        return id;
    }

    static public int getNextBuslineID(){
        int id = nextBuslineID;
        nextBuslineID++;
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
