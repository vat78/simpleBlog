package ru.vat78.simpleBlog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vat78.simpleBlog.dao.PostsDao;
import ru.vat78.simpleBlog.dao.UsersDao;
import ru.vat78.simpleBlog.model.Post;
import ru.vat78.simpleBlog.model.User;

import java.util.Iterator;
import java.util.List;

@Service
public class HibernateDataService implements DatabaseService {

    @Autowired
    UsersDao users;

    @Autowired
    PostsDao posts;

    public List<Post> getLastPosts(int count) {
        return posts.getRecentPosts(0, count);
    }

    public void createNewUser(User user) {
        users.add(user);
    }

    public void savePost(Post post) {
        posts.save(post);
    }

    public void checkAdmin() {
        if (users.findByUsername("admin") == null) {
            User admin = new User();
            admin.setName("admin");
            admin.setPassword("admin");
            admin.setAdmin(true);
            users.save(admin);
        }
    }

    public User getUserById(int userId){
        return users.findById(userId);
    }

    public User getUserByName(String name) {return users.findByUsername(name);}

    public List<User> getAllUsers() {
        return users.getAll();
    }

    public boolean saveUser(User user){
        try{
            users.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteUserById(int userId) {
        users.deleteById(userId);
    }

    public Post getPostById(int postId) {return posts.findById(postId);}

    public void deletePostById(int postId) {
        Post post = posts.findById(postId);
        posts.delete(post);
    }

    public List<Post> getPostsByAuthor(User author, int page, int pageSize){
        return posts.getPostsByUser(author.getId(), page, pageSize);
    }

    public int getPostsCount() {
        return posts.getCount();
    }

    public int getPostsCount(User author) {
        return posts.getPostsCountByUser(author.getId());
    }
}
