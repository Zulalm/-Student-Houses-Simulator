import java.util.ArrayList;
import java.util.PriorityQueue;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	private int duration;
	private double rating;
	private static PriorityQueue<Student> homelessStudents = new PriorityQueue<Student>();
	private static ArrayList<Student> studentList = new ArrayList<Student>();

	public Student(int id, String name, int duration, double rating) {
		this.setId(id);
		this.setName(name);
		this.setDuration(duration);
		this.setRating(rating);

	}
	// return true if the student is graduated
	public boolean isGraduated() {
		if (this.duration == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void decrementDuration() {
		for(Student s: Student.getStudentList()) {
			if (s.getDuration() >0) {
				s.setDuration(s.getDuration()-1);
			}
		}
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public int compareTo(Student o) {

		if (this.id < o.getId()) {
			return -1;
		}
		else if  (this.id >o.getId()) {
			return 1;
		}


		return 0;
	}
	
	
	/**
	 * @return the homelessStudents
	 */
	public static PriorityQueue<Student> getHomelessStudents() {
		return homelessStudents;
	}
	/**
	 * @param homelessStudents the homelessStudents to set
	 */
	public static void setHomelessStudents(PriorityQueue<Student> homelessStudents) {
		Student.homelessStudents = homelessStudents;
	}
	/**
	 * @return the studentList
	 */
	public static ArrayList<Student> getStudentList() {
		return studentList;
	}
	/**
	 * @param studentList the studentList to set
	 */
	public static void setStudentList(ArrayList<Student> studentList) {
		Student.studentList = studentList;
	}


}
