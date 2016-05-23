package ru.vat78.simpleBlog.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Base class for handle users
 */

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=50)
    @Column(name = "name", nullable = false, unique = true)
    public String name;

    @Size(min=3, max=50)
    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "full_name")
    public String fullName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="author")
    private List<Post> userPosts;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
