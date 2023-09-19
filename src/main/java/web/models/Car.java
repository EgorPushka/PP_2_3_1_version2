package web.models;

public class Car {
    private String model;
    private String color;
    private int made;

    public Car(String model, String color, int manufacture) {
        this.model = model;
        this.color = color;
        this.made = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMade() {
        return made;
    }

    public void setMade(int made) {
        this.made = made;
    }
}
