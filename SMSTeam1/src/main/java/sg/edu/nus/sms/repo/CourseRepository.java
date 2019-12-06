package sg.edu.nus.sms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.sms.model.Course;
import sg.edu.nus.sms.model.Students;

public interface CourseRepository extends JpaRepository<Course,Integer> {

	public Course findByCourseCode(String courseCode);

	

}
