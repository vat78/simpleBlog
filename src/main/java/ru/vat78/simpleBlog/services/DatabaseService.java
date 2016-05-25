package ru.vat78.simpleBlog.services;

import ru.vat78.simpleBlog.model.Post;
import ru.vat78.simpleBlog.model.User;

import java.util.List;

/**
 * Interface for service working with services
 */
public interface DatabaseService {

    List<Post> getLastPosts(int count);

    void createNewUser(User user);

    void savePost(Post post);

    void checkAdmin();

    User getUserById(int userId);

    User getUserByName(String name);

    List<User> getAllUsers();

    boolean saveUser(User user);

    void deleteUserById(int userId);

    Post getPostById(int postId);

    void deletePostById(int postId);
}
