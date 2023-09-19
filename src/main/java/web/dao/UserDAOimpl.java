package web.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@ComponentScan(value = "web")
public class UserDAOimpl implements UserDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public List<User> indexUsers() {
        return manager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void edit(User user) {

    }

    @Override
    public User getById(int id) {
        return null;
    }

}
