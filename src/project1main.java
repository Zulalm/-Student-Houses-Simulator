import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Scanner;
public class project1main {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File(args[0]));
		PrintStream out = new PrintStream(new File(args[1]));
		while (in.hasNext()) {
			String[] s = in.nextLine().strip().split(" ");
			if (s[0].equals("s")) {
				//runs if it is a student
				int id = Integer.parseInt(s[1]);
				String name = s[2];
				int duration = Integer.parseInt(s[3]);
				double rating = Double.parseDouble(s[4]);
				Student student = new Student(id,name,duration,rating);
				Student.getStudentList().add(student);

			}
			else if (s[0].equals("h")) {
				//runs if it is a house
				int id = Integer.parseInt(s[1]);
				int duration = Integer.parseInt(s[2]);
				double rating = Double.parseDouble(s[3]);
				House house = new House(id,duration,rating);
				House.getHouseList().add(house);
			}
		}
		// sort both houselist and studentlist by their ids with O(nlog(n)) time complexity
		Collections.sort(House.getHouseList()); 
		Collections.sort(Student.getStudentList());
		// try to locate students until all of them are graduated
		while (!Student.getStudentList().isEmpty()) { // O(n*(n^2))
			int i = 0;
			while (i < Student.getStudentList().size()) {
				Student s = Student.getStudentList().get(i);
				if(s.isGraduated()) {
					Student.getHomelessStudents().add(s);
					Student.getStudentList().remove(i);
					continue;
				}
				boolean findHouse = false;
				for (House h : House.getHouseList()) {
					if (h.getDuration() ==0 && h.getRating()>= s.getRating()) {
						h.setDuration(s.getDuration());
						Student.getStudentList().remove(i);
						findHouse = true;
						break;
					}
				}
				if(!findHouse) {
					i++;
				}

			}
			House.decrementDuration(); //O(n)
			Student.decrementDuration(); //O(n)
			
		}
		while (Student.getHomelessStudents().size()!=0) {
			Student student = Student.getHomelessStudents().poll();
			out.println(student.getName());
		}

	
	}

}
