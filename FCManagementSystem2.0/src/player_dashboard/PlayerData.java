package player_dashboard;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PlayerData
{
    private final StringProperty ID;
    private final StringProperty lastName;
    private final StringProperty firstName;
    private final StringProperty email;
    private final StringProperty DOB;

    public PlayerData(String id, String lastname, String firstname, String dob, String email)
    {
        this.ID = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(firstname);
        this.lastName = new SimpleStringProperty(lastname);
        this.DOB = new SimpleStringProperty(dob);
        this.email = new SimpleStringProperty(email);
    }

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getDOB() {
        return DOB.get();
    }

    public StringProperty DOBProperty() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB.set(DOB);
    }
}
