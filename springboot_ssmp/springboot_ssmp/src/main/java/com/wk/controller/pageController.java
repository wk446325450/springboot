package com.wk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： TODO
 */
//@RestController
public class pageController {
    @RequestMapping("/")
    public String hello(){
        return "forward:/pages/books.html";
    }
}
