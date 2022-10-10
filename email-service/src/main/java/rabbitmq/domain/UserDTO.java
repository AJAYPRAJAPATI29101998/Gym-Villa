package rabbitmq.domain;

public class UserDTO {

    private String recipientId;

    private String subject;

    private String MessageBody;

    public UserDTO() {
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
}
