package ru.vat78.simpleBlog.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.vat78.simpleBlog.model.Post;
import ru.vat78.simpleBlog.model.User;

import java.util.List;

@Repository("postsDao")
@Transactional(readOnly = true)
public class PostsDaoImpl extends AbstractDao<Post> implements PostsDao{

    protected Class<Post> getEntityClass() {
        return Post.class;
    }

    public List<Post> getRecentPosts(int page, int pageSize) {

        Criteria criteria = getCriteria();
        criteria.addOrder(Order.desc("created"))
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize);
        return (List<Post>) criteria.list();
    }

    public List<Post> getPostsByUser(int userId, int page, int pageSize) {

        User user = new User();
        user.setId(userId);
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("author", user))
                .addOrder(Order.desc("created"))
                .setFirstResult(page * pageSize)
                .setMaxResults(pageSize);
        return (List<Post>) criteria.list();
    }

    public int getPostsCountByUser(int userId){

        User user = new User();
        user.setId(userId);
        Criteria criteria = getCriteria()
                .add(Restrictions.eq("author", user))
                .setProjection(Projections.rowCount());
        long result = (Long) criteria.uniqueResult();

        return (int) result;
    }
}
