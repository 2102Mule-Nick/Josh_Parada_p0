package bankapp.service;

import bankapp.exception.InvalidPassword;
import bankapp.exception.UserNameTaken;
import bankapp.exception.UserNotFound;
import bankapp.pojo.User;

public interface AuthService {
	
public boolean existingUser(User user);
	
	public User authenticateUser(User user) throws InvalidPassword, UserNotFound;
	
	public User registerUser(User user) throws UserNameTaken;

}
