package com.stackroute.emailservice.pojo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Email {
    @Id
    @javax.validation.constraints.Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String recipientId;

    @NotNull
    @Size(max = 60,message = "Subject must be within 60 characters")
    private String subject;

    @Size(max = 1000)
    private String MessageBody;

    @Override
    public String toString() {
        return "Email{" +
                "recipientId=" + recipientId +
                ", subject='" + subject + '\'' +
                ", MessageBody='" + MessageBody + '\'' +
                '}';
    }
}
