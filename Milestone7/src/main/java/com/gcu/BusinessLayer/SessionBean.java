package com.gcu.BusinessLayer;

import org.springframework.web.context.annotation.SessionScope;

import com.gcu.ReferenceArchitectureLayer.UserModel;

@SessionScope
public class SessionBean
{
	UserModel currentUser;

	public UserModel getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(UserModel currentUser) {
		this.currentUser = currentUser;
	}
}