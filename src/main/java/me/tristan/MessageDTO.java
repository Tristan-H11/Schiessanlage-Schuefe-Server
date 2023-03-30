package me.tristan;

public class MessageDTO {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageDTO() {
    }

    public MessageDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
