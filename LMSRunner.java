import java.util.ArrayList;
import java.util.Scanner;

/** LMSRunner.java - Start building ICT-LMS system 
 * Name: 
 * StudentID:
 * Section:
 */

/*
 *  LMSRunner is a main class for Administrators and Students to access the LMS based on their role.
 *  In LMSRunner, your task is to implement the system asking which roles a user is.
 *  
 *  If a user is an Administrator, he/she can do the following tasks
 *  - Add/Update/Delete Course
 *  - Add/Update/Delete Instructor
 *  - Add/Update/Delete Student
 *  - Able to set grading criteria (e.g., attendance, project, quiz, midterm, final) to the Course.
 *  - Able to add score of students in each criterion to the system.
 *  - Able to print information of all instructors and their teaching courses.
 *  - Able to print information of all students and their registered courses.
 *  
 *  For Students, They can do the following tasks
 *  - Able to register to the existing courses (add by administrator).
 *  - Able to see the accumulated GPA (only the subject that they have completed).
 *  - Able to evaluate the score that a student need to do to get  ‘A’ for a particular subject (only work with subject that they haven’t completed).
 *  - Able to illustrate subject that a student is likely have a problem with (only work with subject that they haven’t completed).
 *  - Able to search names of the instructors who teach in the registered courses.
 *
 * */

public class LMSRunner {

	//CODE HERE
	public static ArrayList<Student> students = new ArrayList<Student>();
	public static ArrayList<Instructor> instrictors = new ArrayList<Instructor>();
	public static ArrayList<RegCourse> courses = new ArrayList<RegCourse>();
	public static boolean student = false ;
	public static boolean administrator = false ;
	
	
	public static void main(String[] args) {
		showmenu();
		
		
	}
	public static void showmenu(){
		System.out.println(" __________________________________________________");
		System.out.println("|                                                  |");
		System.out.println("|                                                  |");
		System.out.println("|                                                  |");
		System.out.println("| Input A for accessing to : Administrator mode	   |");
		System.out.println("|                                                  |");
		System.out.println("|                                                  |");
		System.out.println("| Input S for accessing to : Student mode    	   |");
		System.out.println("|                                                  |");
		System.out.println("|                                                  |");
		System.out.println("|__________________________________________________|");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if(input.equals("A")){	
			showAdmin();
		}else if(input.equals("S")){
			showStudent();
		}else {
			System.out.println("Fail input ");
			showmenu();
		}
	}
	public static void showAdmin(){
		System.out.println(" __________________________________________________________");
		System.out.println("|                                                          |");
		System.out.println("| 				Administrator mode                         |");
		System.out.println("|                                                          |");
		System.out.println("|                                                          |");
		System.out.println("|  Course      :   input 1 to Add 			               |");
		System.out.println("|                  input 2 to update |");
		System.out.println("|                  input 3 to remove                       |");
		System.out.println("|                                                          |");
		System.out.println("|  Instructor  :   input 4 to Add 				           |");
		System.out.println("|                  input 5 to update                       |");
		System.out.println("|                  input 6 to remove                       |");
		System.out.println("|                                                          |");
		System.out.println("|  Student     :   input 7 to Add 				           |");
		System.out.println("|                  input 8 to update            |");
		System.out.println("|                  input 9 to remove                       |");
		System.out.println("|                                                          |");
		System.out.println("|  Set grading criteria  :   input 10                                                      |");
		System.out.println("|                                                          |");
		System.out.println("|  add score of students :   input 11                                                       |");
		System.out.println("|                                                          |");
		System.out.println("|  print information of all instructors :  input 12      ");
		System.out.println("|                                                          |");
		System.out.println("|  print information of all students    :  input 13            |");
		System.out.println("|                                                          |");
		System.out.println("|                                                          |");
		System.out.println("|__________________________________________________________|");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if(input.equals("1")){	
			
			System.out.println("Input Course Code, Course name , Coure cours");
			menu1(in.nextLine(),in.nextLine(),in.nextBoolean(),in.nextInt());
		}else if(input.equals("2")){
			showStudent();
		}else if(input.equals("3")){
			showStudent();
		}else if(input.equals("4")){
			showmenu();
		}else if(input.equals("5")){
			showmenu();
		}else if(input.equals("6")){
			showmenu();
		}else if(input.equals("7")){
			showmenu();
		}else if(input.equals("8")){
			showmenu();
		}else if(input.equals("9")){
			showmenu();
		}else if(input.equals("10")){
			showmenu();
		}else if(input.equals("11")){
			showmenu();
		}else if(input.equals("12")){
			showmenu();
		}else if(input.equals("13")){
			showmenu();
		}else{
			System.out.println("Fail input ");
			showmenu();
		}
		
	}
	public static void showStudent(){
		System.out.println(" ___________________________________________________");
		System.out.println("|                                                   |");
		System.out.println("|                                                   |");
		System.out.println("|                                                   |");
		System.out.println("| Input C for accessing to Course operation Menu    |");
		System.out.println("|                                                   |");
		System.out.println("|                                                   |");
		System.out.println("| Input S for accessing to Student operation Menu   |");
		System.out.println("|                                                   |");
		System.out.println("|                                                   |");
		System.out.println("| Input B for accessing to Main Menu                |");
		System.out.println("| 												    |");
		System.out.println("|                                                   |");
		System.out.println("|                                                   |");
		System.out.println("|___________________________________________________|");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if(input.equals("C")){	
			showAdmin();
		}else if(input.equals("S")){
			showStudent();
		}else if(input.equals("B")){
			showStudent();
		}else{
			System.out.println("Fail input ");
			showmenu();
		}
	}
	public static void menu1(String code, String cname, boolean core,int credit){
		RegCourse course = new RegCourse(code,cname,core,credit) ;
		courses.add(course);
	}
}
