package com.example.tobi.springbootbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
- http?
-> 상태코드 200, 404, 500...
- headers, body?
- url요청 방식
GET, POST, PUT, DELETE
- rest api?
- MVC패턴?
- 템플릿엔진?
 */

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

}
