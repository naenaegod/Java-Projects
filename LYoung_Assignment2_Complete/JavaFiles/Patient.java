
public class Patient {
	private String fName, mName, lName;
	private String streetAddy, city, state;
	private String zip;
	private String phone;
	private String eName, ePhone;
	public Patient() {
		fName = "";
		mName = "";
		lName = "";
		streetAddy = "";
		city = "";
		state = "";
		zip = "";
		phone = "";
		eName = "";
		ePhone = "";
	}
	public Patient(String first, String middle, String last) {
		fName = first;
		mName = middle;
		lName = last;
	}
	public Patient(String first, String middle, String last, String street, String city1, String state1, String zip1, String phone1, String emergName, String emergPhone) {
		fName = first;
		mName = middle;
		lName = last;
		streetAddy = street;
		city = city1;
		state = state1;
		zip = zip1;
		phone = phone1;
		eName = emergName;
		ePhone = emergPhone;
		
		
	}
	public String getFirst() {
		return fName;
	}
	public String getMiddle() {
		return mName;
	}
	public String getLast() {
		return lName;
	}
	public String getStreet() {
		return streetAddy;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmergName() {
		return eName;
	}
	public String getEmergPhone() {
		return ePhone;
	}
	public void setFirst(String word) {
		fName = word;
	}
	public void setMiddle(String word) {
		mName = word;
	}
	public void setLast(String word) {
		lName = word;
	}
	public void setStreet(String word) {
		streetAddy = word;
	}
	public void setCity(String word) {
		city = word;
	}
	public void setState(String word) {
		state = word;
	}
	public void setZip(String word) {
		zip = word;
	}
	public void setPhone(String word) {
		phone = word;
	}
	public void setEmergName(String word) {
		eName = word;
	}
	public void setEmergPhone(String word) {
		ePhone = word;
	}
	public String buildFullName() {
		String full = fName + " " + mName + " " + lName;
		return full;
	}
	public String buildAddress() {
		String full = streetAddy + " " + city + " " + state + " " + zip;
		return full;
	}
	public String buildEmergencyContact() { 
		String full = eName + " " + ePhone;
		return full;
	}
	public void tostring() {
		System.out.printf("     %s%n", "Name: " + buildFullName());
		
		System.out.printf("     %s%n", "Address: " + buildAddress());
		
		System.out.printf("     %s%n", "EmergencyContact: " + buildEmergencyContact());
		
	}

}
