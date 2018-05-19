package com.flyer.zww.user;

import com.flyer.zww.user.model.User;
import com.flyer.zww.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/***
 * @Description:
 * @Author: kangqing
 * @date: 2018/5/12 13:31
 * @version:1.0
 *
 *
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService service;

    public String index(){
        return "redirect:/users/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("do","add");
        return "users/update.html";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(String id,Model model){
        model.addAttribute("user",service.findById(id));
        model.addAttribute("do","update");
        return "users/update.html";
    }

    @RequestMapping("/add")
    public String add(User user,Model model){
        service.insert(user);
        return "redirect:/users/list";
    }

    @RequestMapping("/update")
    public String update(User user,Model model){
        int rows = service.update(user);
        System.out.println("更新行数：" + rows + ",id:" + user.getId());
        return "redirect:/users/list";
    }


    @RequestMapping("/list")
    public String list(Model model){
        List<User> users = service.list();
        for(User u : users){
            System.out.println("userid:" + u.getId());
        }
        model.addAttribute("users",users);
        return "users/list.html";
    }
}
