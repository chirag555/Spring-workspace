package spring.model;

public class User {
	private String lName,fName,gender,country,hobbies[],address;

	public User(String lName, String fName, String gender, String country, String[] hobbies, String address) {
		super();
		this.lName = lName;
		this.fName = fName;
		this.gender = gender;
		this.country = country;
		this.hobbies = hobbies;
		this.address = address;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "User Details lName=" + lName + ", fName=" + fName + ", gender=" + gender + " ";
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}