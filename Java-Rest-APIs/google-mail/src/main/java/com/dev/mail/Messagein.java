package com.dev.mail;

public class Messagein {
    String emailId;
    String subject;
    String body;
    public Messagein() {
    }
    public Messagein(String emailId, String subject, String body) {
        this.emailId = emailId;
        this.subject = subject;
        this.body = body;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
