package com.gcu.ReferenceArchitectureLayer;

import java.util.List;

public interface UserDatabaseModelInterface <T>
{
	public void init();
	public void destroy();
	
	public List<UserModel> getAllusers();
	
	public int addUser(UserModel beingCreated);
	public void updateUser(UserModel beingUpdated);
	public void removeUser(UserModel beingDeleted);
	public T searchUser_UserName(String beingSearched);
}
