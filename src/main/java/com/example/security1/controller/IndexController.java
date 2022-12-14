package com.example.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
