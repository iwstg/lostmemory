package springtest.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "UserInfo")
public class UserEntity {
    @Id
    private String userID;

    private String userName;

    private String userPassword;
}
