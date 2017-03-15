/* Name: 
 * StudentID:
 * Section:
 */

/* Student is a class that collect registered courses information and subject of interest.
 * The objective of this class is to allow a students to be able to do the following tasks 
 * 
 *  - Register on the course.
 *  - Set scores for a course based on course code
 *  - Calculate the accummulate GPA
 *  - Show the subject that students may fail after the midterm exam
 *  - Method to calculate how much score students need to do to get an A 
 * */

import java.util.ArrayList;

public class Student extends Person {
	
	private ArrayList<String> subjectInterest;
	private ArrayList<RegCourse> registeredCourses;
	
	// Constructor
	public Student(String firstName, String lastName, int age, char gender) {
		//CODE HERE
		super(firstName, lastName, age, gender);
		subjectInterest = new ArrayList<String>();
		registeredCourses = new ArrayList<RegCourse>();
	}

	//Printing Students basic information @Overriding
	public void printInfo(){
		System.out.println("Name: "+super.getFirstName()+" "+super.getLastName());
		System.out.println("Age:"+super.getAge()+", Gender "+super.getGender()+"\n");
		for(RegCourse course:registeredCourses){
			System.out.println(course.getCourseCode()+" - "+course.getCourseName());
		}
		//CODE HERE
	}
	
	//Method for students to register course
	public void RegisterCourse(RegCourse a){
		//CODE HERE
		RegCourse clone = a.clone();
		registeredCourses.add(clone);
		
		//System.out.println(registeredCourses.get(0).isCompletedCourse());
	
	}
	
	//Method for student to add RAW scores on particular course code 
	public void setAllScore(String cCode, int attScore, int quiScore, int proScore,int miScore, int fiScore) {
		//CODE HERE
		for (RegCourse course:registeredCourses){
			//System.out.println(course.getCourseCode().equals(cCode));
			if(course.getCourseCode().equals(cCode)){
				
				/*coure.setAllScore((attScore/coure.getFull_score_attendance())*coure.getAttendancePercent()/100,
								  (quiScore/coure.getFull_score_quiz())*coure.getQuizPercent()/100,
								  (proScore/coure.getFull_score_projects())*coure.getProjPercent()/100,
								  (miScore/coure.getFull_score_midScore())*coure.getFull_score_midScore()/100,
								  (fiScore/coure.getFull_score_finalScore())*coure.getFull_score_finalScore()/100);*/
				
				course.setAllScore(attScore, quiScore, proScore, miScore, fiScore);
				course.setAccumScore(this.findAccum(course));
				
				
			}
		}
	}
	
	//Method for converting accumulate score to an alphabet GRADE (e.g., A, B, C, D, F)
	// A=4.0, B=3.0, C=2.0, D=1.0, F=0.0
	public char Grading(RegCourse a){
		//CODE HERE
					if(a.getAccumScore()>=0.8&&a.getAccumScore()<=1){
						
						a.setGrade(4.00);
						return 'A';
					}else if(a.getAccumScore()>=0.7&&a.getAccumScore()<0.8){
						
						a.setGrade(3.00);
						return 'B';
					}else if(a.getAccumScore()>=0.6&&a.getAccumScore()<0.7){
						
						a.setGrade(2.00);
						return 'C';
					}else if(a.getAccumScore()>=0.5&&a.getAccumScore()<0.6){
						
						a.setGrade(1.00);
						return 'D';
					}else {
						
						a.setGrade(0.00);
						return 'F';
					}
					
		
		
	}
	
	// Method for calculating accumulate GPA (only applied for completed courses)
	// The Accumulate GPA is calculated by (1) multiply each numeric grade value 
	// by the number of credits the course was defined. (2) add these number together  
	// (3) Divided this number by total number of credit a student took (only the completed course)
	public double accumGPA(){	
		double finalgpa = 0.0;
		double allCredit = 0.0;
		//CODE HERE
		for (RegCourse course:registeredCourses){
			if(course.isCompletedCourse()){
				this.Grading(course);
				finalgpa += course.getGrade()*course.getCourseCredit();
				allCredit += course.getCourseCredit();
			}
		}
		
		return finalgpa/allCredit;
	}
	
	// Method for checking and printing course that students may have problems
	// The severe subject is calculated by accumulate score < half of a current full score
	// E.g., Assume that  the Object-Oriented programming has grading criteria as attendance=10%, quiz=10%, project=20%, midterm=30%, final=30% 
	// Currently your score is attendance=50/100, quiz=4/10, project=45/100, midterm 48/100, finalexam = 0/100 (haven't done final exam) .
	// The accumulate score = (50*10)/100 + (4*10)/10 + (45*20)/100 + (48*30)/100 + 0 
	//	                    =  5 + 4 + 9 + 14.4 + 0  = 32.4
	// Therefore, the accumulate score (32.4) less than half of a current grading criteria score which is (35)
	// Student may have a problem with this subject at the end of the course (after final exam).
	public void severeSubject(){
		boolean check = true;
		for (RegCourse course:registeredCourses){
			if(!course.isCompletedCourse()){
				if((this.findAccum(course)/this.findFullAccum(course))<0.5){
					if(check){
						System.out.println("[Severe subject]");
						check=false;
					}
					course.printCourseInfo();
				}
			}
		}
		//CODE HERE
	}

	// Method to calculate on how much score a student need to work on to get an A on a given course
	// To get an 'A', students must have score more than 80%
	public void howToGetASubject(String cCode){
		//CODE HERE
		
		for (RegCourse course:registeredCourses){
			if(course.getCourseCode().equals(cCode)){
				
				if(this.findAccum(course)+(1-this.findFullAccum(course))<0.8){
					System.out.println("You can't get A for this subject");
				}else {
					
					System.out.printf("You need %.2f score more to get an A for this subject\n",(0.8-this.findAccum(course))*100);
					System.out.println();
				}
			}
		}
		
	}
	
	//Method to lists all instructors that teach the registered subjects
	public void relevantInstructor(ArrayList<Instructor> listINS){
		//CODE HERE
		boolean check = true;
		for(Instructor instructor:listINS){
			for (RegCourse course:registeredCourses){
				if(instructor.checkTeaching(course.getCourseCode())){
					if(check){
						System.out.println("[Relevant Instructor]");
						check=false;
					}
					instructor.printInfo();
					break;
				}
			}
		}
	}
	
	public double findAccum(RegCourse course){
		
		double accum = 0;
		if(course.getAttendance()!=-1&&course.getFull_score_attendance()!=0){
			accum+=(course.getAttendance()/course.getFull_score_attendance())*course.getAttendancePercent()/100.0;
		}
		
		if(course.getQuiz()!=-1&&course.getFull_score_quiz()!=0){
			accum+=(course.getQuiz()/course.getFull_score_quiz())*course.getQuizPercent()/100.0;
		}
	
		if(course.getProjects()!=-1&&course.getFull_score_projects()!=0){
			accum+=(course.getProjects()/course.getFull_score_projects())*course.getProjPercent()/100.0;
		}
		
		if(course.getMidScore()!=-1&&course.getFull_score_midScore()!=0){
			accum+=(course.getMidScore()/course.getFull_score_midScore())*course.getMidtermPercent()/100.0;
		}
		
		if(course.getFinalScore()!=-1&&course.getFull_score_finalScore()!=0){
			accum+=(course.getFinalScore()/course.getFull_score_finalScore())*course.getFinalPercent()/100.0;
		}
		
		return accum;
	}
	
	public double findFullAccum(RegCourse course){
		double fullAccum=0;
		if(course.getAttendance()!=-1){
			fullAccum+=course.getAttendancePercent()/100.0;
		}
		
		if(course.getQuiz()!=-1){
			fullAccum+=course.getQuizPercent()/100.0;
		}
		
		if(course.getProjects()!=-1){
			fullAccum+=course.getProjPercent()/100.0;
		}
		
		if(course.getMidScore()!=-1){
			fullAccum+=course.getMidtermPercent()/100.0;
		}
		
		if(course.getFinalScore()!=-1){
			fullAccum+=course.getFinalPercent()/100.0;
		}
		
		return fullAccum;
	}
}
