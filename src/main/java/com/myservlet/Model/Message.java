package com.myservlet.Model;
import java.util.Date;

public class Message {
    int messageType;
    String messageContent;
    String name;
    String date;

    public Message(int messageType, String messageContent, String name) {
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.name = name;
        this.date = new Date().toString();
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

}
