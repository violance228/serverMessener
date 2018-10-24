package com.konex.messenger.entity.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.konex.messenger.entity.DomainObject;
import com.konex.messenger.entity.UploadingPlan;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * created by user violence
 * created on 18.10.2018
 * class created for project messengerServer
 */

@Entity
@Table(name = "messages")
public class Message implements DomainObject {

    @Id
    @SequenceGenerator(name = "message_seq", sequenceName = "message_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_seq")
    @Column(name = "id")
    Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "was_read")
    private Date wasRead;

    @Column(name = "was_sent")
    private Date wasSent;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users")
    private User user;

    @NonNull
    @Column(name = "for_user")
    private Long forUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "message")
    private Set<UploadingPlan> uploadingPlans;

    public Message(String text, Date wasSent, Long forUser) {
        this.text = text;
        this.wasSent = wasSent;
        this.forUser = forUser;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getWasRead() {
        return wasRead;
    }

    public void setWasRead(Date wasRead) {
        this.wasRead = wasRead;
    }

    public Date getWasSent() {
        return wasSent;
    }

    public void setWasSent(Date wasSent) {
        this.wasSent = wasSent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getForUser() {
        return forUser;
    }

    public void setForUser(Long forUser) {
        this.forUser = forUser;
    }

    public Set<UploadingPlan> getUploadingPlans() {
        return uploadingPlans;
    }

    public void setUploadingPlans(Set<UploadingPlan> uploadingPlans) {
        this.uploadingPlans = uploadingPlans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(text, message.text) &&
                Objects.equals(wasRead, message.wasRead) &&
                Objects.equals(wasSent, message.wasSent) &&
                Objects.equals(user, message.user) &&
                Objects.equals(forUser, message.forUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, text, wasRead, wasSent, user, forUser);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", wasRead=" + wasRead +
                ", wasSent=" + wasSent +
                ", user=" + user +
                ", forUser=" + forUser +
                '}';
    }
}
