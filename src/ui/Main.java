package ui;
import model.Controller;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

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
		boolean exit = false;
		int option;
		
		do{
			System.out.println("Register a project (1)");
			System.out.println("Search project after date (2)");
			System.out.println("Search project before date (3)");
			System.out.println("List All (4)");
			
			System.out.print("Option: ");
			option = reader.nextInt();
			switch (option){
				case 1:
					TryCatchRegisterProject();
					break;
				case 2:
					TryCatchSearchAfterDate();
					break;
				case 3:
					TryCatchSearchBeforeDate();
					break;
				case 4:
					System.out.println(controller.listAll());
					System.out.println("-------------------------------------------------------------------------------------------");
					break;
				default:
					System.out.println("The option is not in the menu");
			}
			
			System.out.println("Would you like to exit now?");
			System.out.printf("Yes (true)\nNo (false)\n");
			exit = reader.nextBoolean();
			System.out.println("-------------------------------------------------------------------------------------------");
		}while(exit==false);
	}
	
	private Calendar dateToCalendar(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	public void TryCatchRegisterProject(){
		try{
			RegisterProject();
		}catch(ParseException ex){
			System.out.println("There is a ParseException error");
			System.out.println("-------------------------------------------------------------------------------------------");
		}
	}

	//Incomplete
	private void RegisterProject() throws ParseException{
		String name;
		String clientName;
		final Calendar initialDate;
		String getInitialDate;
		final Calendar finalDate;
		String getFinalDate;
		double budget;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		
		System.out.printf("\nName of project: ");
		name = reader.next();
		System.out.print("Name of client: ");
		clientName = reader.next();
		
		System.out.println("Type the initial date in format <dd/MM/yyyy>:");
		getInitialDate = reader.next();
		date = sdf.parse(getInitialDate);
		initialDate = dateToCalendar(date);
		
		System.out.println("Type the final date in format <dd/MM/yyyy>:");
		getFinalDate = reader.next();
		date = sdf.parse(getFinalDate);
		finalDate = dateToCalendar(date);
		
		System.out.print("Budget: ");
		budget = reader.nextDouble();
		
		boolean status = controller.RegisterProject(name, clientName, initialDate, finalDate, budget);
		if (status==true){
			System.out.println("The project has been created");
		}else {
			System.out.println("The project has not been created");
		}
		System.out.println("-------------------------------------------------------------------------------------------");
		
	}

	//Incomplete
	
	public void TryCatchSearchAfterDate(){
		try{
			searchProjectsAfterDate();
		}catch(ParseException exe){
			System.out.println("There is a ParseException error");
			System.out.println("-------------------------------------------------------------------------------------------");
		}
	}
	
	private void searchProjectsAfterDate() throws ParseException{
		
		String getDate;
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar newDate;
		
		System.out.println("Type the after date in format <dd/MM/yyyy>:");
		getDate = reader.next();
		date = sdf.parse(getDate);
		newDate = dateToCalendar(date);
		
		System.out.println(controller.searchProjectsAfterDate(newDate));
		System.out.println("-------------------------------------------------------------------------------------------");
		
	}
	
	//Incomplete
	
	public void TryCatchSearchBeforeDate(){
		try{
			searchProjectsBeforeDate();
		}catch(ParseException exe){
			System.out.println("There is a ParseException error");
			System.out.println("-------------------------------------------------------------------------------------------");
		}
	}
	
	private void searchProjectsBeforeDate() throws ParseException{
		String getDate;
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar newDate;
		
		System.out.println("Type the before date in format <dd/MM/yyyy>:");
		getDate = reader.next();
		date = sdf.parse(getDate);
		newDate = dateToCalendar(date);
		
		System.out.println(controller.searchProjectsBeforeDate(newDate));
		System.out.println("-------------------------------------------------------------------------------------------");
		
	}
}
