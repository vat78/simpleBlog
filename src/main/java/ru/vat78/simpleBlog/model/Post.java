package ru.vat78.simpleBlog.model;


import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
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
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=50)
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User author;

    @NotNull
    @Column
    private String text;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "created_on", nullable = false)
    //@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Date created;



}
