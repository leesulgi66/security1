package com.example.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

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
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/joinProc")
    public @ResponseBody String joinProc() {
        return "회원가입 완료됨!";
    }
}
