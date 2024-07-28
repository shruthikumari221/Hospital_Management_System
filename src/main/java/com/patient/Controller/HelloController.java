package com.patient.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController
{
    @GetMapping("/")
    public String getHomePage(Model model)
    {
        return "Home/home";
    }
    @GetMapping("/hello")
    public String sayHello(Model model)
    {
        model.addAttribute("date",new java.util.Date());
        return "helloworld";
    }
}