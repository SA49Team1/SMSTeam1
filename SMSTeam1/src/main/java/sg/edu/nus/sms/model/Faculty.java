package sg.edu.nus.sms.model;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@DiscriminatorValue("FAC")
public class Faculty extends User {
	
	@NotNull
	private int facultyID;
	
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	
	@NotEmpty
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





	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "Faculty [firstName=" + firstName + ", lastName=" + lastName + "]";
	}




	
	

}
