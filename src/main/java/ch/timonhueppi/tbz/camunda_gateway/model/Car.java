package ch.timonhueppi.tbz.camunda_gateway.model;

public class Car {
    String make;
    String model;
    String year;
    Boolean status_ok;

    public Car(String make, String model, String year, Boolean status_ok) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.status_ok = status_ok;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Boolean getStatus_ok() {
        return status_ok;
    }

    public void setStatus_ok(Boolean status_ok) {
        this.status_ok = status_ok;
    }
}
