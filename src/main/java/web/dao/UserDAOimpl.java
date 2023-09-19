package web.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.List;

@Repository
@ComponentScan(value = "web")
public class UserDAOimpl implements UserDAO{

    @Override
    public List<User> indexUsers() {
        return null;
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
