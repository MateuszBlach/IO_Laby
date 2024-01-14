package businessLayer;

import properties.ApplicationProperties;

public class Station extends StandardObject{
    private String name;
    private String location;
    public Station(String name, String location){
        super();
        this.name = name;
        this.location = location;
        super.ID = ApplicationProperties.getNextStationID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
