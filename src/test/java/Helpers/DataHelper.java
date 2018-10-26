package Helpers;

import Model.*;

import java.util.Date;

import org.testng.annotations.DataProvider;

public class DataHelper {

    public DataHelper(){
    }

    public User getRandomUser(){
    	String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        
        return new User(
        		email,
        		"FirstName",
        		"SurName",
        		"Qwerty",
        		new Date(1988,01,01),
        		getAddress(),
        		true);
    }
    
    public User getExistingUser(){
        
        return new User(
        		"hf_challenge_123456@hf12345.com",
        		"Joe",
        		"Black",
        		"12345678",
        		new Date(1988,01,01),
        		getAddress(),
        		true);
    }
    
    public Address getAddress() {
    	return new Address(
    			"Qwerty, 123",
    			"zxcvb",
    			"Qwerty",
    			"Colorado",
    			"12345",
    			"Qwerty",
    			"12345123123",
    			"12345123123",
    			"United States",
    			"hf",
    			"Company");
    }
    
    @DataProvider(name="AuthenticationUsers")
    public static Object[][] credentials1() throws Exception {

        return CsvHelper.getCSVArray("Users.csv");

    }
}
