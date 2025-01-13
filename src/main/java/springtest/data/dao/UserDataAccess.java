package springtest.data.dao;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtest.data.dto.UserDTO;
import springtest.data.entity.UserEntity;
import springtest.data.repository.UserRepository;

@Service
@Transactional
public class UserDataAccess {
    UserRepository userRepo;

    @Autowired
    public UserDataAccess(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // 전달받은 ID가 DB에 존재하는지 체크
    public boolean existcheckUserId(String userId) {
        return userRepo.existsById(userId);
    }

    // 전달받은 ID와 PW로 로그인 진행


    // 회원가입 진행
    public boolean RegisterInDB(UserDTO user){
        if(userRepo.existsById(user.getUserId())){ // DB에 user정보중 ID와 일치하는게 있는 경우
            return false;
        }else{
            UserEntity entity = new UserEntity(user.getUserId(), user.getUserName(),
                    user.getUserEmail(), user.getUserPassword());
            userRepo.save(entity);
            return true;
        }
    }


}
