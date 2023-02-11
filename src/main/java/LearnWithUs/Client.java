package LearnWithUs;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	private String Email;
	private String Name;
	private String Password;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
