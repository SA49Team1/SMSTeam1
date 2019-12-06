package sg.edu.nus.sms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	private String courseName;
	@NotNull
	private int courseUnit;
	@NotEmpty
	private String courseCode;
	@NotEmpty
	private String department;
	
	@ManyToOne
	private Faculty currentFaculty;
	
	
	
	@OneToMany(mappedBy="course")
	private List<StudentCourse> stugrades;
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Faculty getCurrentFaculty() {
		return currentFaculty;
	}

	public void setCurrentFaculty(Faculty currentFaculty) {
		this.currentFaculty = currentFaculty;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseUnit() {
		return courseUnit;
	}

	public void setCourseUnit(int courseUnit) {
		this.courseUnit = courseUnit;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}





	public List<StudentCourse> getStugrades() {
		return stugrades;
	}

	public void setStugrades(List<StudentCourse> stugrades) {
		this.stugrades = stugrades;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}





	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseCode == null) ? 0 : courseCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseCode == null) {
			if (other.courseCode != null)
				return false;
		} else if (!courseCode.equals(other.courseCode))
			return false;
		return true;
	}



	

}
