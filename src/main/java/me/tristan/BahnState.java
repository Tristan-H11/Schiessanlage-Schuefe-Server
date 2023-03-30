package me.tristan;

public class BahnState {

    public static BahnState BAHN_A = new BahnState();
    public static BahnState BAHN_B = new BahnState();
    public static BahnState BAHN_C = new BahnState();

    private boolean closed = true;
    private boolean alert = false;

    public BahnState() {
    }

    public BahnState(boolean closed, boolean alert) {
        this.closed = closed;
        this.alert = alert;
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
