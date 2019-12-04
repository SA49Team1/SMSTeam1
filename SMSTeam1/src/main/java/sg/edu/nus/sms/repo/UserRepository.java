package sg.edu.nus.sms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.nus.sms.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
