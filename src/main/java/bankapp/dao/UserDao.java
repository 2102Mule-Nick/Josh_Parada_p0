package bankapp.dao;

import java.util.List;

import bankapp.exception.UserNameTaken;
import bankapp.exception.UserNotFound;
import bankapp.pojo.User;

public interface UserDao {
	
public void createUser(User user) throws UserNameTaken;
	
	public User getUserByUsername(String username) throws UserNotFound;
	
	public List<User> getAllUsers();
	
	public void updateUser(User user);
	
	public void removeUser(User user);

}
