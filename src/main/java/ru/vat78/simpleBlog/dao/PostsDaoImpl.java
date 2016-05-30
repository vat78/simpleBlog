package ru.vat78.simpleBlog.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vat78.simpleBlog.model.Post;

import java.util.List;

@Repository("postsDao")
@Transactional(readOnly = false)
public class PostsDaoImpl extends AbstractDao implements PostsDao{

    public Post findById(int id) {
        return getSession().get(Post.class, id);
    }

    public void savePost(Post post) {
        getSession().persist(post);
    }

    public void deletePostById(int id) {
        deletePost(findById(id));
    }

    public List<Post> getRecentPosts(int count) {

        Criteria criteria = getSession().createCriteria(Post.class);
        criteria.addOrder(Order.desc("created"));
        criteria.setMaxResults(count);
        return (List<Post>) criteria.list();
    }

    private void deletePost(Post post) {
        getSession().delete(post);
    }
}
