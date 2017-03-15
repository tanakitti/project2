/** Name: 
 * StudentID:
 * Section:
 */


import java.util.*;

public class Instructor extends Person {

	private ArrayList<Integer> skill;
	private ArrayList<String> researchInterest;
	private ArrayList<RegCourse> teaching;
	
	public Instructor(String firstName, String lastName, int age, char gender) {
	//CODE HERE
		super(firstName, lastName, age, gender);
		skill = new ArrayList<Integer>();
		researchInterest = new ArrayList<String>();
		teaching = new ArrayList<RegCourse>();
	}
	
	//Other relevant methods should be defined here
	
	//add a teaching course
	public void setTeaching(RegCourse course) {
	//CODE HERE	
		teaching.add(course.clone());
	}
	
    //Printing Instructor information @Overridding
    public void printInfo(){
    //CODE HERE
    	System.out.println(super.getFirstName()+" "+super.getLastName());
    }
    public boolean checkTeaching(String cCode){
    	for(RegCourse course:teaching){
    		if(course.getCourseCode().equals(cCode)){
    			return true;	
    		}
    	}
    	return false;
    }
}
