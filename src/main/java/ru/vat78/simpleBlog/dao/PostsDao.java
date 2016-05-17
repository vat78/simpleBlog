package ru.vat78.simpleBlog.dao;

import ru.vat78.simpleBlog.model.Post;
import ru.vat78.simpleBlog.model.User;

import java.util.List;

public interface PostsDao {

    Post findById(int id);

    void savePost(Post post);

    void deletePostById(int id);

    List<Post> getRecentPosts(int conut);

    List<Post> getPostsByAuthor(User author);
}
