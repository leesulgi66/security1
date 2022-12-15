package com.example.security1.controller;

import com.example.security1.model.User;
import com.example.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //localhost:8080/
    //localhost:8080
    @GetMapping({"","/"})
    public String index() {
        //머스테치 기본폴더 : src/main/resources/
        //뷰리졸버 설정 : templates (prefix), mustache (suffinx) <-기본으로 잡히기 때문에 설정 생략 가능
        return "index"; // src/main/resources/templates/index.mustache가 기본이지만 Webconfig 설정으로 확장자를 html을 읽을 수 있게 변경.
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    //스프링시큐리티가 해당주소를 낚아챔.
    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(User user) {
        System.out.println(user);
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);

        userRepository.save(user); //회원가입이 되지만 비밀번호가 노출됨 -> 시큐리티로 로그인을 할 수 없음. 이유는 패스워드가 암호화가 되지 않았기 때문.
        return "redirect:/loginForm";
    }
}
