package sg.edu.nus.sms.model;

import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;


@Entity
@Inheritance
@DiscriminatorColumn(name="USER_TYPE")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty
	private String userName;
	private String passWord;
	
	@OneToMany(mappedBy="user")
    private List<LeaveApp> leaves;
	
    
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String passWord, List<LeaveApp> leaves) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.leaves = leaves;
	}

	
	
	

}
