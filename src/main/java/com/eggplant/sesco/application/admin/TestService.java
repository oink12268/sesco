package com.eggplant.sesco.application.admin;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String getTest() {
        return "hello";
    }

    public String getTest2() {
        return "hello2";
    }
}
