package com.company.daisyapp.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column
    public String title;
    @Column
    public String text;

    @Column
    @CreationTimestamp
    private LocalDateTime date;
    @Column
    public String imageUrl;

    public Entry(String title,String text, String imageUrl) {
        this.title = title;
        this.text = text;
        this.imageUrl = imageUrl;
    }

    public Entry() {
    }

    public LocalDateTime getCreateDate() {
        return date;
    }

    public void setCreateDate(LocalDateTime date) {
        this.date = date;
    }
}
