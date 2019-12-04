package sg.edu.nus.sms.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("STU")
public class Students extends User{
	
	private int studentID;
	private int semister;
	private int cgpa;
	
	@OneToMany(mappedBy="student")
	private List<StudentCourse> GradeList;
	
	

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getSemister() {
		return semister;
	}

	public void setSemister(int semister) {
		this.semister = semister;
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





	public Students(int studentID, int semister, int cgpa, List<StudentCourse> gradeList) {
		super();
		this.studentID = studentID;
		this.semister = semister;
		this.cgpa = cgpa;
		GradeList = gradeList;
	}

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
