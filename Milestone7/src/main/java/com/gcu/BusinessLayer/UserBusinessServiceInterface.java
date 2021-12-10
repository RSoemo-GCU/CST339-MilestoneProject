package com.gcu.BusinessLayer;

import java.util.List;

import com.gcu.ReferenceArchitectureLayer.UserModel;

public interface UserBusinessServiceInterface 
{
	public void init();
	public void destroy();
	
	public List<UserModel> getAllusers();
	 
	public void addUser(UserModel beingCreated);
	public void updateUser(UserModel beingUpdated);
	public void removeUser(UserModel beingDeleted);
	public UserModel searchUser_UserName(String beingSearched);
}
