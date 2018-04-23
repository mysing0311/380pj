package ouhk.comps380f.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Comment implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int ticketID;

//@OneToMany(mappedBy = "comment", fetch = FetchType.EAGER,
  //        cascade = CascadeType.ALL, orphanRemoval = true)
  //private List<String> comment = new ArrayList<>();
  
  
  //@ManyToOne
  //@JoinColumn(name = "ticket_id")
  private Ticket ticket;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getTicketID() {
    return ticketID;
  }

  public void setTicketID(int ticketID) {
    this.ticketID = ticketID;
  }

 /* public List<String> getComment() {
    return comment;
  }

  public void setComment(List<String> comment) {
    this.comment = comment;
  }
*/
  public Ticket getTicket() {
    return ticket;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  
}
