package com.kingbbode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by YG-MAC on 2017. 3. 25..
 */
@Controller
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "hello";
    }
}
