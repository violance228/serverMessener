package com.konex.messenger.entity;

import com.konex.messenger.entity.user.User;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * created by fromUser violence
 * created on 23.10.2018
 * class created for project messenger
 */

@Entity
@Table(name = "messages_cache")
public class MessageCache implements DomainObject {
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
    @JoinColumn(name = "from_user")
    private User fromUser;

    @NonNull
    @Column(name = "for_user")
    private Long forUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "message")
    private Set<UploadingPlan> uploadingPlans;

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

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
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
    public String toString() {
        return "MessageCash{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", wasRead=" + wasRead +
                ", wasSent=" + wasSent +
                ", fromUser=" + fromUser +
                ", forUser=" + forUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageCache that = (MessageCache) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(text, that.text) &&
                Objects.equals(wasRead, that.wasRead) &&
                Objects.equals(wasSent, that.wasSent) &&
                Objects.equals(fromUser, that.fromUser) &&
                Objects.equals(forUser, that.forUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, text, wasRead, wasSent, fromUser, forUser);
    }
}
