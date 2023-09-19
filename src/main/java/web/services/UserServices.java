package web.services;

import org.springframework.stereotype.Service;
import web.models.User;

import java.util.List;

@Service
public interface UserServices {
    List<User> indexUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getById(int id);

}
