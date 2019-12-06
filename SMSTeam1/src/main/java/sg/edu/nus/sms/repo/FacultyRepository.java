package sg.edu.nus.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.sms.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

	public Faculty findByFacultyID(int facultyID);

}
