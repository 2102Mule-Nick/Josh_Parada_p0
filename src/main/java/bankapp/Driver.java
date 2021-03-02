package bankapp;

import java.util.Scanner;

import bankapp.ui.LoginMenu;
import bankapp.ui.Menu;
import bankapp.ui.RegistrationMenu;
import bankapp.ui.WelcomeMenu;

import bankapp.dao.UserDao;
import bankapp.dao.UserDaoKryo;
import bankapp.service.AuthService;
import bankapp.service.AuthServiceImpl;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		UserDao userDao = new UserDaoKryo();
		
		AuthService authService = new AuthServiceImpl(userDao);
		
		Menu register = new RegistrationMenu();
		
		Menu login = new LoginMenu(authService);
		
		Menu welcomeMenu = new WelcomeMenu(login, register);
		
		((RegistrationMenu)register).setWelcomeMenu(welcomeMenu);
		
		((RegistrationMenu)register).setAuthService(authService);
		
		login.setScanner(scan);
		
		register.setScanner(scan);
		
		welcomeMenu.setScanner(scan);
		
		Menu nextMenu = welcomeMenu;
		
		do {
			nextMenu.displayOptions();
			
			nextMenu = nextMenu.advance();
			
		} while (nextMenu != null);
				
	}

}

