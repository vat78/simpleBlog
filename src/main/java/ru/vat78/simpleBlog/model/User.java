package ru.vat78.simpleBlog.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Base class for handle users
 */

@Entity
@Table(name="users", uniqueConstraints=
    @UniqueConstraint(columnNames={"name"}))
public class User implements DBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=50,
        message = "User name must be at least 3 characters long")
    @Pattern(regexp="^[a-zA-Z0-9]+$",
            message="Username must be alphanumeric with no spaces")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Size(min=3, max=250,
            message="The password must be at least 3 characters long.")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name="is_admin")
    private boolean admin = false;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Post> posts;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isAdmin() {return admin;}

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean equals(Object o){
        if (o instanceof User) {
            if (this.getName() == ((User) o).getName())
                return true;
        }
        return false;
    }

    public int hashCode() {
        return this.getName().hashCode();
    }
}
