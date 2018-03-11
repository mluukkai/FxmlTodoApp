package todoapp;

import java.util.ArrayList;
import java.util.List;
import todoapp.dao.UserDao;
import todoapp.domain.User;

public class FakeUserDao implements UserDao {
    List<User> users = new ArrayList<>();

    public FakeUserDao() {
        users.add(new User("testertester", "Teppo Testaaja"));
        users.add(new User("mluukkai", "Matti Luukkainen"));
    }
    
    @Override
    public User findByUsername(String username) {
        return users.stream().filter(u->u.getUsername().equals(username)).findFirst().orElse(null);
    }
    
    @Override
    public User create(User user) throws Exception{
        users.add(user);
        return user;
    } 
    
    @Override
    public List<User> getAll() {
        return users;
    }


}
