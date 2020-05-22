package com.hmq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.net.http.HttpRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login(HttpSession httpSession, String username, String password) {
        System.out.println(username + "   " + password);
        if ("admin".equals(username) && "123456".equals(password)) {
            httpSession.setAttribute("userInfo", "admin");
            return "redirect:/book/getAllBooks";
        } else {
            httpSession.removeAttribute("userInfo");
            return "redirect:/index.jsp";
        }
    }
}
