package springtest.controller;

import jakarta.transaction.UserTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springtest.data.dto.UserDTO;
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

    // 메인페이지 접근 -> 로그인페이지로
    @GetMapping("/")
    public ModelAndView MainLoginPage() {
        //MainLoginPage(Model model, @SessionAttribute(name = "userId", required = false) String userId)
//        model.addAttribute("loginType", "session-login");
//        model.addAttribute("pageName", "세션 로그인");
//
//        if(loginservice.existcheckUserId(userId)){
//            model.addAttribute("nickname", userId);
//        }else{
//            //로그인 정보에 ID가 없음
//        }

        //로그인 세션 확인

        //세션 확인 후 진행

        //로그인 로직
        ModelAndView mav = new ModelAndView();
        mav.setViewName("LoginPage.html");
        return mav;
    }

    // 로그인페이지 접근 -> 회원가입 페이지로 리다이랙션
//    @GetMapping("RegistPage")
//    public String RegistPage(){
//        return ":thymleafversion/RegistPage";
//    }

    // 회원가입
    @PostMapping("/RegistPage")
    public String register(UserDTO userDTO){
//        if (userPassword.equals(userPasswordcheck)){
//            UserDTO userinfo = new UserDTO(userId, userName, userEmail, userPassword);
//            loginservice.Register(userinfo);
//            return true;
//        } else {
//            System.out.println("[CONTROLLER] - 회원가입 실패");
//            return false;
//        }

        if (loginservice.Register(userDTO)){
            System.out.println("[CONTROLLER] - 회원가입 성공");
            return "MainPage";
        } else {
            System.out.println("[CONTROLLER] - 회원가입 실패");
            return "RegistPage";
        }
    }

    @GetMapping("/testpage")
    public String testPage(Model model, UserDTO resuserDTO){
        model.addAttribute("DTO", resuserDTO);
        return "testpage";
    }
    // 테스트
    @PostMapping("/testpage")
    public String testpage(@ModelAttribute("DTO") UserDTO resuserDTO){
        System.out.println(resuserDTO.toString());
        return "";
    }
}
