package manager_dashboard;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PlayerData
{
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty position;
    private final StringProperty age;
    private final StringProperty height;
    private final StringProperty weight;
    private final StringProperty nationality;
    private final StringProperty appearance;



    public PlayerData(String id, String name, String position, String age, String height, String weight, String nationality, String appearance)
    {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.position = new SimpleStringProperty(position);
        this.age = new SimpleStringProperty(age);
        this.height = new SimpleStringProperty(height);
        this.weight = new SimpleStringProperty(weight);
        this.nationality = new SimpleStringProperty(nationality);
        this.appearance = new SimpleStringProperty(appearance);

    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public String getAge() {
        return age.get();
    }

    public StringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getHeight() {
        return height.get();
    }

    public StringProperty heightProperty() {
        return height;
    }

    public void setHeight(String height) {
        this.height.set(height);
    }

    public String getWeight() {
        return weight.get();
    }

    public StringProperty weightProperty() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight.set(weight);
    }

    public String getNationality() {
        return nationality.get();
    }

    public StringProperty nationalityProperty() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality.set(nationality);
    }

    public String getAppearance() {
        return appearance.get();
    }

    public StringProperty appearanceProperty() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance.set(appearance);
    }
}
