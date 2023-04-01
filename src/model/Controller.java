package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;

public class Controller {

	private Project[] projects;

	public Controller() {

		projects = new Project[10];
	
	}
	
	//Incomplete
	public boolean RegisterProject(String name, String clientName,Calendar initialDate, Calendar finalDate, double budget) {
		int position = getFirstValidPosition();
		if (position == -1){
			return false;
		}else{
			Project project = new Project(name, clientName, initialDate, finalDate, budget);
			projects[position] = project;
			return true;
		}
	}
	
	private int getFirstValidPosition(){
		int position = -1;
		boolean exit = false;
		
		for (int i = 0; i<10 && exit == false; i++){
			if (projects[i]==null){
				position = i;
				exit = true;
			}
		}
		
		return position;
	}

	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsAfterDate(Calendar date) throws ParseException{
		
		String msg = "";
		
		for (int i = 0; i<10; i++){
			if (projects[i]!=null){
				if (projects[i].getInitialDate().after(date)){
					msg += projects[i].getProjectInfo() + " ";
				}
			}
		}
		return msg;

	}
	
	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsBeforeDate(Calendar date) throws ParseException{

		String msg = "";
		
		for (int i = 0; i<10; i++){
			if (projects[i]!=null){
				if (projects[i].getInitialDate().before(date)){
					msg += projects[i].getProjectInfo() + " ";
				}
			}
		}
		return msg;

	}
	
	public String listAll(){
		String msg = "";
		for (int i = 0;i<10;i++){
			if (projects[i]!=null){
				msg += projects[i].getProjectInfo();
			}
		}
		return msg;
	}
}
