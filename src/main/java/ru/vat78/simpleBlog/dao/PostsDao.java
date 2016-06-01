package ru.vat78.simpleBlog.dao;

import ru.vat78.simpleBlog.model.Post;
import ru.vat78.simpleBlog.model.User;

import java.util.List;

public interface PostsDao {

    Post findById(int id);

    void save(Post post);

    void add(Post post);

    void delete(Post post);

    List<Post> getRecentPosts(int page, int pageSize);

    List<Post> getPostsByUser(int userId, int page, int pageSize);

    int getCount();

    int getPostsCountByUser(int userId);
}
