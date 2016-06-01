package ru.vat78.simpleBlog.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Base class for handle blog posts
 * Created by vat on 12.05.16.
 */

@Entity
@Table(name="posts")
public class Post implements DBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=2, max=250)
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @ManyToOne(cascade= {CascadeType.REFRESH})
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User author;

    @NotNull
    @Lob
    @Column()
    private String text;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "created_on", nullable = false)
    private Date created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Date getCreated() {
        return created;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
