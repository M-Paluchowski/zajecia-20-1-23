package com.javastart.demo.example.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Random;

//@Component
//@Repository
@Service
public class RandomNumberService {

    public int getRandomNumber() {
        return new Random().nextInt();
    }

}
