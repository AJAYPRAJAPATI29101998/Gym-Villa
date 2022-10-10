package com.stackroute.emailservice.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Email {
    @Id
    private String recipientId;

    @NotNull
    private String subject;

    private String MessageBody;

    public Email() {
    }

    public Email(String recipientId, String subject, String messageBody) {
        this.recipientId = recipientId;
        this.subject = subject;
        MessageBody = messageBody;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return MessageBody;
    }

    public void setMessageBody(String messageBody) {
        MessageBody = messageBody;
    }

    @Override
    public String toString() {
        return "Email{" +
                "recipientId=" + recipientId +
                ", subject='" + subject + '\'' +
                ", MessageBody='" + MessageBody + '\'' +
                '}';
    }
}
