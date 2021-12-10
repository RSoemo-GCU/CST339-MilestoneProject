package com.gcu.BusinessLayer;

import com.gcu.ReferenceArchitectureLayer.UserModel;

public interface SessionInterface
{
	UserModel currentUser();
	
	public UserModel getCurrentUser();
	public void setCurrentUser();
}