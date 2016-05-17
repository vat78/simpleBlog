package ru.vat78.simpleBlog.controller;

import org.junit.Test;
import org.springframework.ui.ModelMap;
import ru.vat78.simpleBlog.database.DatabaseService;
import ru.vat78.simpleBlog.model.Post;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class HomeControllerTest {
    @Test
    public void showHomePage() throws Exception {

        List<Post> posts = Arrays.asList(mock(Post.class), mock(Post.class), mock(Post.class));
        DatabaseService db = mock(DatabaseService.class);

        //when(db.getLastPosts(5)).thenReturn(posts);

        HomeController controller = new HomeController();

        ModelMap model = new ModelMap();

        String viewName = controller.showHomePage(model);

        assertEquals("index", viewName);
        //assertTrue(model.containsAttribute("posts"));
        //verify(db).getLastPosts(5);
    }

}