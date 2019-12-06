package sg.edu.nus.sms.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@DiscriminatorValue("STU")
public class Students extends User{
	
	@NotNull
	private int studentID;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String semester;
	private int cgpa;
	
	@OneToMany(mappedBy="student")
	private List<StudentCourse> GradeList;
	
	

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}



	public int getCgpa() {
		return cgpa;
	}

	public void setCgpa(int cgpa) {
		this.cgpa = cgpa;
	}

	public List<StudentCourse> getGradeList() {
		return GradeList;
	}

	public void setGradeList(List<StudentCourse> gradeList) {
		GradeList = gradeList;
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

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(int studentID, String firstName, String lastName, String semester) {
		super();
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.semester = semester;
		
		
	}
	
	

}
