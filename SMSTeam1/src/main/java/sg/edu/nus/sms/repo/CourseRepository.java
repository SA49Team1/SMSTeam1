package sg.edu.nus.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.sms.model.Course;

public interface CourseRepository extends JpaRepository<Course,Integer> {

}
