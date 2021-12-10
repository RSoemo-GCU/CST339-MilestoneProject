package com.gcu.BusinessLayer;

import java.util.ArrayList;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.DataAccessLayer.UserDataAccessService_live;
import com.gcu.ReferenceArchitectureLayer.UserDatabaseModelInterface;
import com.gcu.ReferenceArchitectureLayer.UserModel;

@Service
public class UserBusinessService implements UserBusinessServiceInterface, UserDetailsService
{
	@Autowired
	UserDatabaseModelInterface userDAO;
	
	@Autowired
	private UserDataAccessService_live service;
	
	public UserBusinessService(UserDataAccessService_live service)
	{
		this.service = service;
	}

	@Override
	public void init() { userDAO.init(); }

	@Override
	public void destroy() { userDAO.destroy(); }

	@Override
	public List<UserModel> getAllusers() { return userDAO.getAllusers(); }

	@Override
	public void addUser(UserModel beingCreated) { userDAO.addUser(beingCreated); }

	@Override
	public void updateUser(UserModel beingUpdated) { userDAO.updateUser(beingUpdated); }

	@Override
	public void removeUser(UserModel beingDeleted) { userDAO.removeUser(beingDeleted); }

	@Override
	public UserModel searchUser_UserName(String beingSearched) { return (UserModel) userDAO.searchUser_UserName(beingSearched); }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("User business service is searching for '" + username + "'");
		UserModel user = service.searchUser_UserName(username);
		System.out.println(user);
		
		//System.out.println(password);
		
		if(user != null)
		{
			
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			if (user.getIsAdmin() == true)
			{
				authorities.add( new SimpleGrantedAuthority("ADMIN"));
				System.out.println("Is an admin");
			}
			else
			{
				System.out.println("Is not an admin");
			}
			
			 User n = new User(user.getUsername(), user.getPassword(), authorities);
			 System.out.println(n.toString());
			return n;
		}
		else
		{
			System.out.println("User not found");
			throw new UsernameNotFoundException("username not found");
		}
	}
}
