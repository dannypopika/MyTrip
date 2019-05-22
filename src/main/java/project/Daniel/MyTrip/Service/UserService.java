package project.Daniel.MyTrip.Service;

import project.Daniel.MyTrip.Model.User;
import project.Daniel.MyTrip.Model.User;

public interface UserService {
    public User findUserByUserName(String userName);
    public void saveUser(User user);
}
