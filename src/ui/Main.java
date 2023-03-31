package ui;

import java.util.Scanner;
import model.Controller;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main{

	private Scanner reader;
	private Controller controller;

	public Main() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Main exe = new Main();
		exe.menu();
		exe.reader.close();
	}

	// Incomplete
	public void menu() {
		System.out.println("Register a user (1)");
		
		System.out.print("Option: ");
		int option = reader.nextInt();
		switch (option){
			case 1:
				RegisterProject();
				break;
		}
	}

	//Incomplete
	public void RegisterProject() {
		String name;
		String clientName;
		Calendar initialDate;
		Calendar finalDate;
		double budget;
		int months;
		Calendar calendar = Calendar.getInstance();
		String show;
		
		System.out.print("Name of project: ");
		name = reader.next();
		System.out.print("Name of client: ");
		clientName = reader.next();
		
		show = new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
		System.out.println("Based in today date ("+show+"), How many months will be start the project?");
		months = reader.nextInt();
		calendar.add(Calendar.MONTH, months);
		initialDate = calendar;
		
		/*
		initialDate = reader.next();
		cal1 = Calendar.getInstance();
		sdf = new SimpleDateFormat("dd/MM/yy");
		cal1.setTime(sdf.parse(initialDate));// all done
		*/
		show = new SimpleDateFormat("dd-MM-yyyy").format(initialDate.getTime());
		System.out.println("Based in initial date of project ("+show+"), How many months will be end the project?");
		months = reader.nextInt();
		calendar.add(Calendar.MONTH, months);
		finalDate = calendar;
		
		System.out.print("Budget: ");
		budget = reader.nextDouble();
		
		boolean status = controller.RegisterProject(name, clientName, initialDate, finalDate, budget);
		if (status==true){
			System.out.println("The project has been created");
		}else {
			System.out.println("The project has not been created");
		}
		
	}

	//Incomplete
	public void searchProjectsAfterDate() {
		
		Calendar calendar = Calendar.getInstance();
		Calendar date;
		String show;
		int months;
		
		show = new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
		System.out.println("Based in today date of project ("+show+"), Enter a number in months to select the date to search");
		months = reader.nextInt();
		calendar.add(Calendar.MONTH, months);
		date = calendar;
		
	}
	
	//Incomplete
	public void searchProjectsBeforeDate() {
		String date;
		Calendar cal;
		SimpleDateFormat sdf;
	}
}
