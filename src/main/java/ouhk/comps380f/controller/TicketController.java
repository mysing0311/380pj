package ouhk.comps380f.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import ouhk.comps380f.exception.AttachmentNotFound;
import ouhk.comps380f.exception.TicketNotFound;
import ouhk.comps380f.model.Attachment;
import ouhk.comps380f.model.Ticket;
import ouhk.comps380f.service.AttachmentService;
import ouhk.comps380f.service.TicketService;
import ouhk.comps380f.view.DownloadingView;

@Controller
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
    public String list(ModelMap model) {
        model.addAttribute("ticketDatabase", ticketService.getTickets());
        return "list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("add", "ticketForm", new Form());
    }
    
    @RequestMapping(value = "bid", method = RequestMethod.GET)
    public ModelAndView bid() {
        return new ModelAndView("bid", "ticketForm", new Form());
    }
    public static class Form {

        private String subject;
        private String body;
        private List<MultipartFile> attachments;
        private String price;
        private int bidNum;
        private String status;
        private String comment;
        //private List<String> comment;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public List<MultipartFile> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<MultipartFile> attachments) {
            this.attachments = attachments;
        }

        public String getPrice() {
          return price;
        }

        public void setPrice(String price) {
          this.price = price;
        }

        public int getBidNum() {
          return bidNum;
        }

        public void setBidNum(int bidNum) {
          this.bidNum = bidNum;
        }
        
        public String getStatus() {
          return status;
        }

        public void setStatus(String status) {
          this.status = status;
        }
        
        public String getComment() {
          return comment;
        }

        public void setComment(String comment) {
          this.comment = comment;
        }
        
        /*public List<String> getComments() {
          return comment;
        }

        public void setComments(List<String> comment) {
          this.comment = comment;
        }
         */
    
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Form form, Principal principal) throws IOException {
        long ticketId = ticketService.createTicket(principal.getName(),
                form.getSubject(), form.getBody(), form.getAttachments(),form.getPrice(),form.getBidNum(),form.getStatus(),form.getComment());
        
        return "redirect:/ticket/view/" + ticketId;
    }

    @RequestMapping(value = "view/{ticketId}", method = RequestMethod.GET)
    public String view(@PathVariable("ticketId") long ticketId,
            ModelMap model) {
        Ticket ticket = ticketService.getTicket(ticketId);
        if (ticket == null) {
            return "redirect:/ticket/list";
        }
        model.addAttribute("ticket", ticket);
        return "view";
    }

    @RequestMapping(
            value = "/{ticketId}/attachment/{attachment:.+}",
            method = RequestMethod.GET
    )
    public View download(@PathVariable("ticketId") long ticketId,
            @PathVariable("attachment") String name) {

        Attachment attachment = attachmentService.getAttachment(ticketId, name);
        if (attachment != null) {
            return new DownloadingView(attachment.getName(),
                    attachment.getMimeContentType(), attachment.getContents());
        }
        return new RedirectView("/ticket/list", true);
    }

    @RequestMapping(value = "delete/{ticketId}", method = RequestMethod.GET)
    public String deleteTicket(@PathVariable("ticketId") long ticketId)
            throws TicketNotFound {
        ticketService.delete(ticketId);
        return "redirect:/ticket/list";
    }

    @RequestMapping(value = "edit/{ticketId}", method = RequestMethod.GET)
    public ModelAndView showEdit(@PathVariable("ticketId") long ticketId,
            Principal principal, HttpServletRequest request) {
        Ticket ticket = ticketService.getTicket(ticketId);
        if (ticket == null
                || (!request.isUserInRole("ROLE_ADMIN")
                && !principal.getName().equals(ticket.getCustomerName()))) {
            return new ModelAndView(new RedirectView("/ticket/list", true));
        }

        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("ticket", ticket);

        Form ticketForm = new Form();
        ticketForm.setSubject(ticket.getSubject());
        ticketForm.setBody(ticket.getBody());
        modelAndView.addObject("ticketForm", ticketForm);

        return modelAndView;
    }

    @RequestMapping(value = "edit/{ticketId}", method = RequestMethod.POST)
    public View edit(@PathVariable("ticketId") long ticketId, Form form,
            Principal principal, HttpServletRequest request)
            throws IOException, TicketNotFound {
        Ticket ticket = ticketService.getTicket(ticketId);
        if (ticket == null
                || (!request.isUserInRole("ROLE_ADMIN")
                && !principal.getName().equals(ticket.getCustomerName()))) {
            return new RedirectView("/ticket/list", true);
        }

        ticketService.updateTicket(ticketId, form.getSubject(),
                form.getBody(), form.getAttachments(),form.getPrice(),form.getComment());
        return new RedirectView("/ticket/view/" + ticketId, true);
    }

    @RequestMapping(
            value = "/{ticketId}/delete/{attachment:.+}",
            method = RequestMethod.GET
    )
    public String deleteAttachment(@PathVariable("ticketId") long ticketId,
            @PathVariable("attachment") String name) throws AttachmentNotFound {
        ticketService.deleteAttachment(ticketId, name);
        return "redirect:/ticket/edit/" + ticketId;
    }
    
     @RequestMapping(value = "bid/{ticketId}", method = RequestMethod.GET)
    public ModelAndView bid(@PathVariable("ticketId") long ticketId) {
        Ticket ticket = ticketService.getTicket(ticketId);
        ModelAndView modelAndView = new ModelAndView("bid");
        modelAndView.addObject("ticket", ticket);

        Form ticketForm = new Form();
        ticketForm.setPrice(ticket.getPrice());
        ticketForm.setBidNum(ticket.getBidNum());
        modelAndView.addObject("ticketForm", ticketForm);
        return modelAndView;
    }

    @RequestMapping(value = "bid/{ticketId}", method = RequestMethod.POST)
    public View bid(@PathVariable("ticketId") long ticketId, Form form){
        Ticket ticket = ticketService.getTicket(ticketId);
        
        ticketService.updateBidNumAndPrice(ticketId,ticket.getBidNum(),form.getPrice());
        return new RedirectView("/ticket/view/" + ticketId, true);
    }
}
