package ouhk.comps380f.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ouhk.comps380f.service.TicketService;

@Controller
public class IndexController {

     @Autowired
    private TicketService ticketService;
     
    @RequestMapping("/")
    public String list() {
        return "redirect:/ticket/list";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }
    @RequestMapping("index")
     public String list(ModelMap model) {
        model.addAttribute("ticketDatabase", ticketService.getTickets());
        return "index";
    }
}
