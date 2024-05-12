package com.example.alohcmute_v2.Messenger.Model;

public class ChatModel {
    private String sender;
    private String receiver;
    private String message;

    private boolean issent;

    public ChatModel() {
    }

    public ChatModel(String sender, String receiver, String message, boolean issent) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.issent = issent;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIssent() {
        return issent;
    }

    public void setIssent(boolean issent) {
        this.issent = issent;
    }
}
