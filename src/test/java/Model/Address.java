package Model;

public class Address {
	
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String postCode;
	public String other;
	public String phone;
	public String phoneMobile;
	public String country;
	public String alias;
	public String company;
	
	public Address(String address1, String address2, String city, String state, String postCode, String other,
			String phone, String phoneMobile, String country, String alias, String company) {
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
		this.other = other;
		this.phone = phone;
		this.phoneMobile = phoneMobile;
		this.country = country;
		this.alias = alias;
		this.company = company;
	}

	
}