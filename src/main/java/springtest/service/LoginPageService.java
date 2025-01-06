package springtest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtest.data.dao.UserDataAccess;
import springtest.data.entity.UserEntity;
import springtest.data.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginPageService {

    UserDataAccess userDAO;

    @Autowired
    public LoginPageService(UserDataAccess userDAO) {
        this.userDAO = userDAO;
    }

    // DB에 ID가 존재하는지 확인
    public boolean existcheckUserId(String userId) {
        return userDAO.existcheckUserId(userId);
    }


}
