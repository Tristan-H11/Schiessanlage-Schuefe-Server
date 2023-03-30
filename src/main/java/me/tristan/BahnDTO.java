package me.tristan;

public class BahnDTO {

    private int counter = 0;
    private String shot = ""; //großer, kleiner, treffer
    private boolean closed = true;
    private boolean alert = false;

    public BahnDTO() {
    }

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
