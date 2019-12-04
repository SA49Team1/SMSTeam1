package sg.edu.nus.sms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentCourse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Students student;
	
	@ManyToOne
	private Course course;
	
	private String grade;
	private int semester;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}



	public StudentCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentCourse(Students student, Course course, String grade, int semester, String status,
			Faculty facultyInCharge) {
		super();
		this.student = student;
		this.course = course;
		this.grade = grade;
		this.semester = semester;
		this.status = status;
		
	}


	
	
	
}
