/** Name: 
 * StudentID:
 * Section:
 *
 */

/* RegCourse is a class that collect information about registered course of each student.
 * This class extends from the class Course which contain basic course information
 * that are courseCode, courseName, courseCredit, Percentage of grading criteria
 * and Full score of each criteria.
 * 
 * The RegCourse need to collect more specific information about the scores of each student regarding
 * the grading criteria which are quiz, attendance, projects, midScore, finalScore. The detail of these information
 * are provided below.
 * */
public class RegCourse extends Course {
	
	private double quiz;
	private double attendance;
	private double projects;
	private double midScore;
	private double finalScore;
	
	private double accumScore=0;
	private boolean completedCourse;
	
	private double grade;
	
	
	//Constructor to setup an object of a registered course
	RegCourse(String code, String cname, boolean core, int cCredit){
		//CODE HERE
		super(code, cname, core, cCredit);
	}
	
	//Other relevant methods should be defined here
	
	public RegCourse clone(){
		RegCourse course = new RegCourse(this.getCourseCode(),this.getCourseName(), this.isCoreCourse(), this.getCourseCredit());
		
		course.setCourseGrading(this.getAttendancePercent(),this.getQuizPercent(),this.getProjPercent(),
								this.getMidtermPercent(),this.getFinalPercent());
		
		course.setFullScore(this.getFull_score_attendance(),this.getFull_score_quiz(),this.getFull_score_projects(),
							this.getFull_score_midScore(), this.getFull_score_finalScore());
		return course;
		
	}
	//Printing Course Information 
	public void printCourseInfo(){
		//CODE HERE
		System.out.println(super.getCourseCode()+": "+super.getCourseName());
	}
	public void setAllScore(double attendance, double quiz, double proj, double midtermScorce,double finalScorce){
		
		if(attendance==-1||quiz==-1||proj==-1||midtermScorce==-1||finalScorce==-1){
			this.completedCourse=false;
		}else {
			this.completedCourse=true;
		}
		this.attendance=attendance;
		this.quiz=quiz;
		this.projects=proj;
		this.midScore=midtermScorce;
		this.finalScore=finalScorce;
		
	}

	public double getQuiz() {
		return quiz;
	}

	public void setQuiz(double quiz) {
		this.quiz = quiz;
	}

	public double getAttendance() {
		return attendance;
	}

	public void setAttendance(double attendance) {
		this.attendance = attendance;
	}

	public double getProjects() {
		return projects;
	}

	public void setProjects(double projects) {
		this.projects = projects;
	}

	public double getMidScore() {
		return midScore;
	}

	public void setMidScore(double midScore) {
		this.midScore = midScore;
	}

	public double getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}

	public double getAccumScore() {
		return accumScore;
	}

	public void setAccumScore(double accumScore) {
		this.accumScore = accumScore;
	}

	public boolean isCompletedCourse() {
		return completedCourse;
	}

	public void setCompletedCourse(boolean completedCourse) {
		this.completedCourse = completedCourse;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
}
