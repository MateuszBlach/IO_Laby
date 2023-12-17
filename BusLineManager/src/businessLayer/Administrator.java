package businessLayer;

import properties.ApplicationProperties;

public class Administrator extends User {
    public Administrator(String login, String password, String name, String surname) {
        super(login,password,name,surname);
        super.ID = ApplicationProperties.getNextAdminID();
    }

    private void deleteUser(int userID){
        //dodac kod usuwajacy
    }

    private void manageBusTimetables(){
        //dodac kod
    }
}
