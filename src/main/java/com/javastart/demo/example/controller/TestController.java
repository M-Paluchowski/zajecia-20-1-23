package com.javastart.demo.example.controller;

import com.javastart.demo.example.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Random;

@Controller
@RequestMapping("/examples")
class TestController {

//    @Autowired
    private RandomNumberService randomNumberService;

    @Autowired
    public TestController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    @PostMapping
//    @DeleteMapping
    @GetMapping("/hello")
    @ResponseBody
    void hello() {
        System.out.println("Hello");
    }

    @GetMapping("/print")
    @ResponseBody
    String printSomething() {
        System.out.println("Ktoś wywołał metodę print");
        return "<h1> Losowa liczba: </h1>" + new Random().nextInt();
    }

    @GetMapping("/hello2")
    String returnView() {
        System.out.println("Ktoś wywołał /hello2");
        return "/test.html";
    }

    @GetMapping("/hello3")
    @ResponseBody
    void headers(HttpServletRequest request) {
//        request.getParameter()
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " : " + value);
        }
    }

    @ResponseBody
    @GetMapping("/params")
    String parameters(HttpServletRequest request) {
        String name = request.getParameter("name");
        String ageAsString = request.getParameter("age");
        int age = Integer.parseInt(ageAsString);
        return String.format("Siema %s, masz %d lat", name, age);
    }

    @ResponseBody
    @GetMapping("/params2")
    String parametersWithAnnotation(@RequestParam(value = "name", required = false, defaultValue = "Rafał") String imie, @RequestParam int age) {
        return age + " " + imie;
    }

    @GetMapping("/logout")
    String redirect() {
        return "redirect:/examples/print";
    }
}
