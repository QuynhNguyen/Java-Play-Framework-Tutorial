import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
	
	@Test
	public void createAndRetrieveUser(){
		//Create new user and save it
		new User("quynhnguyen003@gmail.com", "quynh", "Quynh").save();
		
		//Retrieve the user with the email quynhnguyen003@gmail.com
		User bob = User.find("byEmail", "quynhnguyen003@gmail.com").first();
		
		//Test
		assertNotNull(bob);
		assertEquals("Quynh", bob.fullname);
	}
	
	@Test
	public void tryConnectAsUser() {
	    // Create a new user and save it
	    new User("bob@gmail.com", "secret", "Bob").save();

	    // Test 
	    assertNotNull(User.connect("bob@gmail.com", "secret"));
	    assertNull(User.connect("bob@gmail.com", "badpassword"));
	    assertNull(User.connect("tom@gmail.com", "secret"));
	}
	
	@Test
	public void findUserByEmail(){
		new User("bob@gmail.com", "bob", "Bob").save();
		
		//Test
		assertNotNull(User.findByName("Bob"));
	}
}
