package ru.vat78.simpleBlog.model;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.criteria.Predicate;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Base class for handle users
 */

@Entity
@Table(name="users", uniqueConstraints=
    @UniqueConstraint(columnNames={"name","password"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=50,
        message = "User name must be at least 3 characters long")
    @Pattern(regexp="^[a-zA-Z0-9]+$",
            message="Username must be alphanumeric with no spaces")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Size(min=3, max=50,
            message="The password must be at least 3 characters long.")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name="is_admin")
    private boolean admin = false;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="author")
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

    public boolean isAdmin() {return admin;}

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
