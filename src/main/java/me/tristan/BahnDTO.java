package me.tristan;

public class BahnDTO {

    private int counter = 0;
    private String shot = ""; //großer, kleiner, treffer
    private int closed = 1;
    private boolean alert = false;
    private boolean notify = false;

    public BahnDTO() {
    }

    public BahnDTO(int counter, String shot, int closed, boolean alert, boolean notify) {
        this.counter = counter;
        this.shot = shot;
        this.closed = closed;
        this.alert = alert;
        this.notify = notify;
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

    public int getClosed() {
        return closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }
}
