package bankapp.ui;

import java.util.Scanner;

public class WelcomeMenu implements Menu{
	
	private Scanner scan;
	
	private Menu loginMenu;
	
	private Menu registractionMenu;
	
	private Menu nextMenu;
	
	public WelcomeMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WelcomeMenu(Menu loginMenu, Menu registractionMenu) {
		super();
		this.loginMenu = loginMenu;
		this.registractionMenu = registractionMenu;
	}

	@Override
	public Menu advance() {
		// TODO Auto-generated method stub
		
		return nextMenu;
	}

	@Override
	public void displayOptions() {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to our application");
		System.out.println("Would you like to login or register?");
		String answer = scan.nextLine();
		
		if ("login".equals(answer)) {
			nextMenu = loginMenu;
		} else if ("register".equals(answer)) {
			nextMenu = registractionMenu;
		} else {
			System.out.println("invalid input");
			//redirect user to same welcome menu
			nextMenu = this;
		}
		
	}

	@Override
	public Menu previousMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scanner getScanner() {
		// TODO Auto-generated method stub
		
		return this.scan;
	}

	@Override
	public void setScanner(Scanner scan) {
		// TODO Auto-generated method stub
		
		this.scan = scan;
		
	}

}
