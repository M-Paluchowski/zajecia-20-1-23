package com.javastart.demo.exercises.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstExerciseController {

    @ResponseBody
    @GetMapping("/test/test1")
    String hello(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);

        return "Cześć tutaj Marcin. Wszystko działa";
    }
}
