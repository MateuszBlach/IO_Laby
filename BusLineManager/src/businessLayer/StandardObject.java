package businessLayer;

import java.time.LocalDateTime;

public class StandardObject {


    protected int ID;

    private LocalDateTime timeCreated;

    public StandardObject() {
        this.timeCreated = LocalDateTime.now();
    }

    public int getID() {
        return ID;
    }
    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }
}
