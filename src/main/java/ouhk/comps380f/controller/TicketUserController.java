package ouhk.comps380f.controller;

import java.io.IOException;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import ouhk.comps380f.dao.TicketUserRepository;
import ouhk.comps380f.model.TicketUser;

@Controller
@RequestMapping("user")
public class TicketUserController {

    @Resource
    TicketUserRepository ticketUserRepo;

    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("ticketUsers", ticketUserRepo.findAll());
        return "listUser";
    }

    public static class Form {

        private String username;
        private String password;
        private String[] roles;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String[] getRoles() {
            return roles;
        }

        public void setRoles(String[] roles) {
            this.roles = roles;
        }

    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("addUser", "ticketUser", new Form());
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public View create(Form form) throws IOException {
        TicketUser user = new TicketUser(form.getUsername(),
                form.getPassword(),
                form.getRoles()
        );
        ticketUserRepo.save(user);
        return new RedirectView("/user/list", true);
    }
    
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("register", "ticketUser", new Form());
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public View register(Form form) throws IOException {
        TicketUser user = new TicketUser(form.getUsername(),
                form.getPassword(),
                form.getRoles()
        );
        ticketUserRepo.save(user);
        return new RedirectView("/login", true);
    }
    
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index", "ticketUser", new Form());
    }
    
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login", "ticketUser", new Form());
    }

    @RequestMapping(value = "delete/{username}", method = RequestMethod.GET)
    public View deleteTicket(@PathVariable("username") String username) {
        ticketUserRepo.delete(ticketUserRepo.findOne(username));
        return new RedirectView("/user/list", true);
    }

}
