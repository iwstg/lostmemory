package springtest.data.dao;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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



}
