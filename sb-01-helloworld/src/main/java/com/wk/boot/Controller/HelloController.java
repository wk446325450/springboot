package com.wk.boot.Controller;

import com.wk.boot.bean.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： TODO
 */
//@Controller
//@ResponseBody
@RestController
public class HelloController {

    @Autowired
   private  Pet mypet;

    @RequestMapping("/hello")
    public String handle_Hello(){
        return "hello,springboot2";
    }
    @RequestMapping("/mypet")
    public String mypet(){
        return mypet.toString();
    }
}
