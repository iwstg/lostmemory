package springtest.data.repository;


import springtest.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import springtest.data.entity.UserEntity;
import springtest.data.dto.UserDTO;

public interface UserRepository extends JpaRepository<UserEntity, String>{
}

