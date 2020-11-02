package BankingApp;

import java.util.HashMap;
import java.util.Map;


// Will need to be refactored so that these methods can be shared amongst the Customer class
public class UserDataStore { // Singleton Pattern
	
	// Can't instantiate an abstract class but can instantiate this in another class
	
	// I don't believe I can instantiate a Map here either
	
	private static UserDataStore instance = new UserDataStore();

	// Initializing Map to store usernames and passwords
	private static Map<String, Integer> users = new HashMap<String, Integer>();
	
	
	// getInstance Method 
	public static UserDataStore getInstance() {
		return instance;
	}
	
	
	// Private Constructor -- Cannot be accessed outside of this class
	private UserDataStore() {}
	
	
	
	public boolean isUsernameTaken(String username) {
		return users.containsKey(username);
	}
	
	
	public void registerUser(String username, String password) {
		int hashPassword = password.hashCode();
		users.put(username, hashPassword);
	}
	
	
	public boolean isLoginCorrect(String username, String password) {
		
		if(!users.containsKey(username)) { // if the map does not contain said username - refuse access
			return false;
		} else { // if map does contain username get the hashed password, match it to the username in the map and see they are equivalent
			int hashPassword = password.hashCode();
			int storedHashPassword = users.get(username);
			return hashPassword == storedHashPassword;
		}
	}
	
	// Should be able to call the getInstance() method within main along with logic in order to access this class
	
	
	
	
//	public boolean isUsernameTaken();
//	public void registerUser();
//	public boolean isLoginCorrect();

}
