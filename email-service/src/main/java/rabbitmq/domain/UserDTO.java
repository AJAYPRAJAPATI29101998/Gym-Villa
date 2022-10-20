package rabbitmq.domain;

import com.stackroute.emailservice.pojo.GymSubscription;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {


    private Integer bookingId;
    private String userName;
    private String userEmail;
    private String createdAt;
    private String gymOwnerEmail;
    private int slotId;
    private GymSubscription gymSubscription;
    private int gymId;
}
