package com.gcu.ReferenceArchitectureLayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserModel>
{
	@Override
	public UserModel mapRow(ResultSet resultSet, int rowNum) throws SQLException
	{
		UserModel user = new UserModel
				( 
						resultSet.getString("firstname"),
						resultSet.getString("lastname"),
						resultSet.getString("email"),
						resultSet.getString("phonenumber"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						resultSet.getBoolean("isadmin")
				);
		return user;
	}

}
