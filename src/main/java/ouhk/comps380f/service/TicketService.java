package ouhk.comps380f.service;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import ouhk.comps380f.exception.AttachmentNotFound;
import ouhk.comps380f.exception.TicketNotFound;
import ouhk.comps380f.model.Ticket;

public interface TicketService {

    public long createTicket(String customerName, String subject,
            String body, List<MultipartFile> attachments, String price, int bidNum, String status, String comment) throws IOException;

    public List<Ticket> getTickets();

    public Ticket getTicket(long id);

    public void updateTicket(long id, String subject,
            String body, List<MultipartFile> attachments, String price, String comment)
            throws IOException, TicketNotFound;

    public void delete(long id) throws TicketNotFound;

    public void deleteAttachment(long ticketId, String name)
            throws AttachmentNotFound;
    
    public void updateBidNumAndPrice(long id , int bidNum, String price);
    public void updateWinner(long id, String customerName);
    public void changeStatus(long id);
    public void addComment(long id, String message);
}
