package ru.vat78.simpleBlog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vat78.simpleBlog.dao.PostsDao;
import ru.vat78.simpleBlog.dao.UsersDao;
import ru.vat78.simpleBlog.model.Post;
import ru.vat78.simpleBlog.model.User;

import java.util.List;

@Service
public class HibernateDataService implements DatabaseService {

    @Autowired
    UsersDao users;

    @Autowired
    PostsDao posts;

    public List<Post> getLastPosts(int count) {
        return posts.getRecentPosts(count);
    }

    public void createNewUser(User user) {
        users.saveUser(user);
    }

    public void savePost(Post post) {
        posts.savePost(post);
    }

    public void checkAdmin() {
        if (users.findByUsername("admin") == null) {
            User admin = new User();
            admin.setName("admin");
            admin.setPassword("admin");
            admin.setAdmin(true);
            users.saveUser(admin);
        }
    }
}
