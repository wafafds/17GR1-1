package entity;

import java.io.Serializable;
import java.util.List;

public class question implements Serializable{
	 private static final long serialVersionUID = -2734313491451856178L; 
	 private String username;
	    private String city;
	    private List<String> languages;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public List<String> getLanguages() {
			return languages;
		}
		public void setLanguages(List<String> languages) {
			this.languages = languages;
		}

}
