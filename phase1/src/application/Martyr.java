package application;

import java.util.Date;
// this class to information about martyr
public class Martyr {
	private String name;
	private int age;
	private Date dateOfDeath=new Date();
    private char gender;
	public static int sum;

	public Martyr() {
		super();
		
	}

	public Martyr(String name) {
		super();
		
	}

	public Martyr(String name, int age,Date dateOfDeath, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.dateOfDeath = dateOfDeath;
		this.gender = gender;
		
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	@Override
	public String toString() {
		//(dateOfDeath.getMonth()+1)+"/"+(dateOfDeath.getDay())+"/" +(dateOfDeath.getYear()+1900)
		return (name+ ","+ age+"," + dateOfDeath+","+gender);
	}

	
	

}
