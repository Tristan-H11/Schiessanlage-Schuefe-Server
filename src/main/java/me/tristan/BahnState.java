package me.tristan;

public class BahnState {

    public static BahnState BAHN_A = new BahnState();
    public static BahnState BAHN_B = new BahnState();
    public static BahnState BAHN_C = new BahnState();

    // 0 = offen, 1 = schreiber geschlossen, 2 = deckung geschlossen
    private int closed = 0;
    private boolean alert = false;
    private String lastShot = "";

    public BahnState() {
    }

    public static BahnDTO getADTO(boolean notify) {
        return new BahnDTO(
                YamlHandler.getA(),
                BAHN_A.getLastShot(),
                BAHN_A.isClosed(),
                BAHN_A.isAlert(),
                notify);
    }

    public static BahnDTO getBDTO(boolean notify) {
        return new BahnDTO(
                YamlHandler.getB(),
                BAHN_B.getLastShot(),
                BAHN_B.isClosed(),
                BAHN_B.isAlert(),
                notify);
    }

    public static BahnDTO getCDTO(boolean notify) {
        return new BahnDTO(
                YamlHandler.getC(),
                BAHN_C.getLastShot(),
                BAHN_C.isClosed(),
                BAHN_C.isAlert(),
                notify);
    }

    public String getLastShot() {
        return this.lastShot;
    }

    public void setLastShot(String lastShot) {
        this.lastShot = lastShot;
    }

    public int isClosed() {
        return this.closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }

    public boolean isAlert() {
        return this.alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }
}
