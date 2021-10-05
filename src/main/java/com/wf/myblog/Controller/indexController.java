package com.wf.myblog.Controller;

import com.wf.myblog.Bean.User;
import com.wf.myblog.Service.UserService;
import com.wf.myblog.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class indexController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/blog")
    public String Blog() {
        return "blog";
    }

    @RequestMapping("/about")
    public String About() {
        return "about";
    }

    @RequestMapping("/archives")
    public String archives() {
        return "archives";
    }

    @RequestMapping("/category")
    public String category() {
        return "category";
    }

    @RequestMapping("/tags")
    public String tags() {
        return "tags";
    }

//    @RequestMapping("/admin/login")
//    public String adminLogin() {
//        return "admin/login";
//    }
//
//    @RequestMapping("/admin/index")
//    public String adminIndex() {
//        return "admin/index";
//    }
//
//    @RequestMapping("/admin/manage")
//    public String adminManage() {
//        return "admin/manage";
//    }
//
//    @RequestMapping("/admin/post_blogs")
//    public String adminPostBlogs() {
//        return "admin/post_blogs";
//    }

//    @RequestMapping("/getAllUser")
//    public String getAllUser(Model model) {
//        List<User> users = userService.findAll();
//        System.out.println(users.toString());
//        model.addAttribute("users", users);
//        return "test";
//    }
}
