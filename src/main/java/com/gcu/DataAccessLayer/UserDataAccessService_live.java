package com.gcu.DataAccessLayer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.gcu.ReferenceArchitectureLayer.UserDatabaseModelInterface;
import com.gcu.ReferenceArchitectureLayer.UserMapper;
import com.gcu.ReferenceArchitectureLayer.UserModel;

@Repository
public class UserDataAccessService_live implements UserDatabaseModelInterface<UserModel>
{
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	
	@Override
	public void init() { }

	@Override
	public void destroy() { }
	
	public UserDataAccessService_live(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<UserModel> getAllusers() 
	{
		return jdbcTemplate.query("select * from users", new UserMapper());
	}

	@Override
	public int addUser(UserModel beingCreated)
	{
		return jdbcTemplate.update
			(
				"insert into users (firstname, lastname, email, phonenumber, username, password) value(?, ?, ?, ?, ?, ?)",
				beingCreated.getFirstName(),
				beingCreated.getLastName(),
				beingCreated.getEmail(),
				beingCreated.getPhoneNumber(),
				new BCryptPasswordEncoder().encode(beingCreated.getUsername()),
				beingCreated.getPassword()
			);
	}

	@Override
	public void updateUser(UserModel beingUpdated) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(UserModel beingDeleted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel searchUser_UserName(String beingSearched)
	{
		System.out.println("Searching for " + beingSearched);
		
		UserModel found = (UserModel) jdbcTemplate.queryForObject
				(
						"select * from users where username = '" + beingSearched + "' ",
						new UserMapper()
				);	
		System.out.println("Found = " + found.toString());
		return found;
	}
}
