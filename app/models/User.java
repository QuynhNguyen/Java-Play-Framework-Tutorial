package models;

import javax.persistence.*;
import java.util.*;
import play.db.jpa.*;

@Entity
public class User extends Model {
	
	public String email; 
	public String password;
	public String fullname;
	public boolean isAdmin;
	
	public User(String email, String password, String fullname){
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}
	
	public static User connect(String email, String password){
		return find("byEmailAndPassword", email, password).first();
	}
	
	public static User findByName(String fullname){
		return find("byFullname", fullname).first();
	}
}