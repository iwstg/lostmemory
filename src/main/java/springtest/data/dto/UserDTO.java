package springtest.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {

    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;

}