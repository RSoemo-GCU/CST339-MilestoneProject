package com.gcu.ReferenceArchitectureLayer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel 
{
	//========================================================//
	//====================Model=Variables=====================//
	//========================================================//
	//============First=Name============//
	/*@NotNull(message="First Name is a required field")
	@Size(min=1, max=32, message="First Name must be between 5 and 32 characters")*/
	private String firstName;

	//============Last=Name============//
	/*@NotNull(message="Last Name is a required field")
	@Size(min=1, max=32, message="Last Name must be between 5 and 32 characters")*/
	private String lastName;
	
	//============Email============//
	/*@NotNull(message="Email")
	@Size(min=5, max=32, message="Email must be between 5 and 32 characters")*/
	private String email;
	
	//============Phone=Number============//
	/*@NotNull(message="Phone Number is a required field")
	@Size(min=9, max=9, message="Password must be 9 digits")*/
	private String phoneNumber;
	
	//============Username============//
	@NotNull(message="Username is a required field")
	@Size(min=1, max=32, message="Password must be between 5 and 32 characters")
	private String username;
	
	//============Password============//
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 5 and 32 characters")
	private String password;
	
	//============IsAdmin============//
	private Boolean isAdmin;
	
	
	
	
	//========================================================//
	//======================Constructors======================//
	//========================================================//
	//============Default============//
	public UserModel() 
	{
		super();
	}	
	
	//============Definer============//
	public UserModel
		(
			@NotNull(message = "First Name is a required field") @Size(min = 1, max = 32, message = "First Name must be between 5 and 32 characters") String firstName,
			@NotNull(message = "Last Name is a required field") @Size(min = 1, max = 32, message = "Last Name must be between 5 and 32 characters") String lastName,
			@NotNull(message = "Email") @Size(min = 5, max = 32, message = "Email must be between 5 and 32 characters") String email,
			@NotNull(message = "Phone Number is a required field") @Size(min = 9, max = 9, message = "Password must be 9 digits") String phoneNumber,
			@NotNull(message = "Username is a required field") @Size(min = 5, max = 32, message = "Password must be between 5 and 32 characters") String username,
			@NotNull(message = "Username is a required field") @Size(min = 5, max = 32, message = "Password must be between 5 and 32 characters") String password
		)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.isAdmin = false;
	}
	
	//============Definer============//
		public UserModel (String firstName, String lastName, String email, String phoneNumber, String username, String password, boolean isadmin)
		{
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.username = username;
			this.password = password;
			this.isAdmin = isadmin;
		}
	
	
	
	
	//========================================================//
	//===================Getters=&=Setters====================//
	//========================================================//
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin){
		this.isAdmin = isAdmin;
	}
	
	//============To=String============//
	@Override
	public String toString()
	{
		return "UserModel Object: Name = '" + firstName + " " + lastName + "', Email = '" + email + "', Phone Number = '" + phoneNumber + "', Username = '" + username + "', Password = '" + password + "', Is Admin = " + isAdmin;
	}
}
