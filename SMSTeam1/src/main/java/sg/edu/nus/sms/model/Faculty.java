package sg.edu.nus.sms.model;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("FAC")
public class Faculty extends User {
	
	private int facultyID;
	
	
	private String department;
	
	@OneToMany(mappedBy="currentFaculty")
	private List<Course> coursesInCharge;
	


	public int getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}



	public List<Course> getCoursesInCharge() {
		return coursesInCharge;
	}

	public void setCoursesInCharge(List<Course> coursesInCharge) {
		this.coursesInCharge = coursesInCharge;
	}





	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faculty(int facultyID, String department, List<Course> coursesInCharge) {
		super();
		this.facultyID = facultyID;
		this.department = department;
		this.coursesInCharge = coursesInCharge;
	}




	
	

}
