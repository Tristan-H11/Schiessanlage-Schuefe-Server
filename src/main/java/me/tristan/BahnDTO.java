package me.tristan;

public class BahnDTO {

    public int counter;
    public String shot; //großer, kleiner, treffer
    public boolean closed;
    public boolean alert;

    public BahnDTO(int counter, String shot, boolean closed, boolean alert) {
        this.counter = counter;
        this.shot = shot;
        this.closed = closed;
        this.alert = alert;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getShot() {
        return shot;
    }

    public void setShot(String shot) {
        this.shot = shot;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }
}
