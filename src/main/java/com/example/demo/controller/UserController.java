package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@RestController // 리턴시에 그 문자를 그대로 응답
@Controller // 리턴시에 파일을 응답 // 파일을 찾아서 포워드 해줌 // 템플릿엔진
public class UserController {

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
//        String username = request.getParameter("username"); // x폼
//        String password = request.getParameter("password"); // x폼
//        String email = request.getParameter("email"); // x폼

        System.out.println("username : " + username);
        System.out.println("password : " + password);
        System.out.println("email : " + email);

        if (username.length() > 10) {
            return "error-404";
        }

        return "redirect:/main";
    }


}
