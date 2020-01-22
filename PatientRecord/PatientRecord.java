
public class PatientRecord {
	public String lastName[];
	public String firstName[];
	public char gender[];
	public String birthdate[];
	public int patientCounter;
	
	public PatientRecord() {//int i, String lastName, String firstName, char gender, String birthdate){
		this.lastName= new String[100];
		this.firstName= new String[100];
		this.gender= new char[100];
		this.birthdate= new String[100];
	}
	

	public void setLastName(int i, String lastName) {
		this.lastName[i]=lastName;
	}
	public String getLastName(int i) {
		return lastName[i];
	}
	public void setFirstName(int i, String firstName) {
		this.firstName[i]= firstName;
	}
	public String getFirstName(int i) {
		return firstName[i];
	}
	public void setGender(int i, char gender) {
		this.gender[i]=gender;
	}
	public char getGender(int i) {
		return gender[i];
	}
	public void setBirthdate(int i, String birthdate) {
		this.birthdate[i]=birthdate;
	}
	public String getbirthdate(int i) {
		return birthdate[i];
	}

}
