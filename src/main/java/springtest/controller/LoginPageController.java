package springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import springtest.data.entity.UserEntity;
import springtest.data.repository.UserRepository;
import springtest.service.LoginPageService;

@RestController
public class LoginPageController {

    private final LoginPageService loginservice;

    @Autowired
    public LoginPageController(LoginPageService loginservice) {
        this.loginservice = loginservice;
    }

    @GetMapping("/")
    public String MainLoginPage(Model model, @SessionAttribute(name = "userId", required = false) String userId){

        model.addAttribute("loginType", "session-login");
        model.addAttribute("pageName", "세션 로그인");

        if(loginservice.existcheckUserId(userId)){
            model.addAttribute("nickname", userId);
        }else{
            //로그인 정보에 ID가 없음
        }

        //로그인 세션 확인

        //세션 확인 후 진행

        //로그인 로직
        return "mainpage";
    }


}
