package Model;

import java.util.Date;

public class User {
	
	public String email;
    public String name;
    public String surname;
    public String password;
    public Date birhtDate;
    public Address address;
    public Boolean gender;
    
    public User(String email, String name, String surname, String password, Date birhtDate,
			Address address, Boolean male) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.birhtDate = birhtDate;
		this.address = address;
		this.gender = male;
	}
    
    public User(String email, String password, String firstName, String surname) {
    	this.email = email;
		this.name = firstName;
		this.surname = surname;
		this.password = password;
    }

}
