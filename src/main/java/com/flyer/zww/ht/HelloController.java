package com.flyer.zww.ht;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: gavin
 * @Date: 2018/5/11 22:05
 * @Description:
 */

@Controller
public class HelloController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "world")String name,Model model){
        model.addAttribute("name",name);
        System.out.println("hello " + name);
        return "greeting";
    }

}
