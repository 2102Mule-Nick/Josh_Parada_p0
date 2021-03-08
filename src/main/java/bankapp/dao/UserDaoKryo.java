package bankapp.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import bankapp.exception.UserNameTaken;
import bankapp.exception.UserNotFound;
import bankapp.pojo.User;

public class UserDaoKryo implements UserDao {
	
	private Kryo kryo = new Kryo();

	private Logger log = Logger.getRootLogger();
	
	private static final String FOLDER_NAME = "userss\\";
	
	private static final String FILE_EXTENSION = ".dat";
	
	public UserDaoKryo() {
		super();
		kryo.register(User.class);
	}	

	@Override
	public void createUser(User user) throws UserNameTaken {
		// TODO Auto-generated method stub
		
		log.info("Starting to create user");
		
		try(FileOutputStream outputStream = new FileOutputStream(FOLDER_NAME + user.getUsername() + FILE_EXTENSION)) {
			Output output = new Output(outputStream);
			kryo.writeObject(output, user);
			output.close();
		} catch (FileNotFoundException e) {
			log.error("could not open file", e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUserByUsername(String username) throws UserNotFound {
		// TODO Auto-generated method stub
		
		try (FileInputStream inputStream = new FileInputStream(FOLDER_NAME + username + FILE_EXTENSION)) {
			Input input = new Input(inputStream);
			User user = kryo.readObject(input, User.class);
			input.close();
			System.out.println(user);
			return user;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
