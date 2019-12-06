package sg.edu.nus.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.sms.model.Students;

public interface StudentsRepository extends JpaRepository<Students,Integer> {

	Students findByStudentID(int studentID);

}
