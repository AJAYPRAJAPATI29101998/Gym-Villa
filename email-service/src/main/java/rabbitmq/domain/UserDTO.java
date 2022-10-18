package rabbitmq.domain;

import com.stackroute.emailservice.pojo.GymSubscriptions;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
public class UserDTO {

    private Integer bookingId;

    private String userName;

    private String userEmail;

    private String gymOwnerEmail;


    private int slotId;

    private GymSubscriptions subscriptionPlan;

    private Integer gymOwnerId;

   private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "UserDTO{" +
                "bookingId=" + bookingId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", gymOwnerEmail='" + gymOwnerEmail + '\'' +
                ", slotId=" + slotId +
                ", subscriptionPlan=" + subscriptionPlan +
                ", gymOwnerId=" + gymOwnerId +
                ", dateTime=" + dateTime +
                '}';
    }
}
