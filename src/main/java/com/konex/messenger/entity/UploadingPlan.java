package com.konex.messenger.entity;

import com.konex.messenger.entity.user.Message;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * created by user violence
 * created on 23.10.2018
 * class created for project messenger
 */

@Entity
@Table(name = "uploading_plan")
public class UploadingPlan {

    @Id
    @SequenceGenerator(name = "uploading_plan_seq", sequenceName = "uploading_plan_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uploading_plan_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "create_time")
    private Date timeCreate;

    @Column(name = "uploading_time")
    private Date timeUploading;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message")
    private Message message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Date getTimeUploading() {
        return timeUploading;
    }

    public void setTimeUploading(Date timeUploading) {
        this.timeUploading = timeUploading;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UploadingPlan{" +
                "id=" + id +
                ", timeCreate=" + timeCreate +
                ", timeUploading=" + timeUploading +
                ", message=" + message +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UploadingPlan that = (UploadingPlan) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(timeCreate, that.timeCreate) &&
                Objects.equals(timeUploading, that.timeUploading) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, timeCreate, timeUploading, message);
    }
}
