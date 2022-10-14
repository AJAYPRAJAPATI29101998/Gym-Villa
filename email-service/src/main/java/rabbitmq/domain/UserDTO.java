package rabbitmq.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserDTO {

    private String bookingId;

    private String userEmail;

    private String gymOwnerEmail;

    private String gymId;

    private String userName;

    private String bookingDate;

    private String slotInfo;

    private String subscriptionPlan;


    @Override
    public String toString() {
        return "UserDTO{" +
                "bookingId='" + bookingId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", gymOwnerEmail='" + gymOwnerEmail + '\'' +
                ", gymId='" + gymId + '\'' +
                ", userName='" + userName + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", slotInfo='" + slotInfo + '\'' +
                ", subscriptionPlan='" + subscriptionPlan + '\'' +
                '}';
    }
}
