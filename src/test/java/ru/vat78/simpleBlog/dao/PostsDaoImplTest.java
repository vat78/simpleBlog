package ru.vat78.simpleBlog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.vat78.simpleBlog.model.Post;
import ru.vat78.simpleBlog.model.User;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class PostsDaoImplTest extends EntityDaoImplTest {

    @Autowired
    PostsDao postsDao;

    @Autowired
    UsersDao usersDao;


    @Test
    public void findById() throws Exception {

        Post post = postsDao.findById(1);
    }
/*
    @Test
    public void savePost() throws Exception {

        Post post = getTestPost();
        usersDao.saveUser(post.getAuthor());
        postsDao.savePost(getTestPost());

    }

    @Test
    public void getRecentPosts() throws Exception {

        List<Post> posts = postsDao.getRecentPosts(1);
        Assert.assertEquals(posts.size(), 1);
    }
*/
    private Post getTestPost() {

        Post post = new Post();

        post.setTitle("Test post");
        post.setText("some text");
        post.setCreated(new Date(System.currentTimeMillis()));
        post.setAuthor(getTestUser());

        return post;
    }

    private User getTestUser(){

        User user = new User();
        user.setName("test");
        user.setPassword("password");
        user.setFullName("test user");
        return user;
    }

}