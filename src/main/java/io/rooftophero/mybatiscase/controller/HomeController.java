package io.rooftophero.mybatiscase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/boards";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("data", "Hello");
        return "test";
    }

}
