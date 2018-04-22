package ouhk.comps380f.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

   @Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String ownerName;
    private String itemName;
    private String description;
    private String price;
    private String bidNum;
    @OneToMany(mappedBy = "ticket", fetch = FetchType.EAGER,
       cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> attachments = new ArrayList<>(); 
    private List<String> comments = new ArrayList<>();
    





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Photo> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Photo> attachments) {
        this.attachments = attachments;
    }

    public void deleteAttachment(Photo attachment) {
        //attachment.setTicket(null);
        this.attachments.remove(attachment);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBidNum() {
        return bidNum;
    }

    public void setBidNum(String bidNum) {
        this.bidNum = bidNum;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
    
}