package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @RestController
 *  <p>컴퍼넌트스캔을하는데 기준점은 demo 그 이하에 있는 모든 클래스를 스캔한다.</p>
 *  <p>어노테이션을 찾아서 자기가 만든 자료형에 담는데 그걸 IOC(inversion of control)라고 한다.</p>
 *  <p>스프링에게 new의 제어권을 빼앗겼다. 그래서 IOC라고 함.</p>
 *  <p>IOC컨테이너에 뜬다.</p>
 */
@RestController
public class HelloController {

    public HelloController() {
        System.out.println("HelloController 컴포넌트 스캔됨");
    }

    /**
     * 어노테이션으로 찾으니까 메소드명은 중요하지 않다.
     */
    @GetMapping("/home")
    public void home() {
        System.out.println("home 호출됨");
    }

    /**
     *  정적 페이지.
     *  서버측에서 캐싱하라고 프로토콜에 맞춰서 헤더에 알려줌.
     *  클라이언트가 캐싱하게 되면 서버측에서는 비용이 준다.
     */
    @GetMapping("/hello")
    public String hello() {
        String name = "홍길동";
        return "<h1>hello " + name + "</h1>";
    }

    /**
     *
     *  실행할 때마다 변하는 페이지 : "동적 페이지" 라고 한다.
     */
    @GetMapping("/random")
    public String random() {
        Random r = new Random();
        int num = r.nextInt(5)+1;
        return "<h1>random " + num + "</h1>";
    }
}

