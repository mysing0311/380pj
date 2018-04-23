package ouhk.comps380f.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

}
