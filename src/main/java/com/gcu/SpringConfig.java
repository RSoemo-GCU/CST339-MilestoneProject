package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.gcu.BusinessLayer.ProductBusinessService;
import com.gcu.BusinessLayer.ProductBusinessServiceInterface;
import com.gcu.BusinessLayer.UserBusinessService;
import com.gcu.BusinessLayer.UserBusinessServiceInterface;

@Configuration
public class SpringConfig
{
	/*@Bean(name="DatabaseAccessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserDatabaseModelInterface getDatabaseUserAccessService()
	{
		return new UserDataAccessService_production();
	}*/
	
	/*@Bean(name="DatabaseProductAccessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ProductDatabaseModelInterface getDatabaseProductAccessService()
	{
		return new ProductDataAccessService_live(null);
	}*/
	
	@Bean(name="productBS", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public ProductBusinessServiceInterface getProductBusinessService()
	{
		return new ProductBusinessService();
	}
	
	/*@Bean(name="userBS", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserBusinessServiceInterface getUserBusinessService()
	{
		return new UserBusinessService();
	}*/
	
	/*@Bean(name="DatabaseAccessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserDatabaseModelInterface getDatabaseAccess()
	{
		return new UserDataAccessService_production();
	}*/
	
	/*@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public OrdersBusinessServiceInterface getOrdersBusiness()
	{
		return new AnotherOrdersBusinessService();
	}*/
	
	/*@Bean(name="securityService")
	public SecurityServiceInterface getSecurityService()
	{
		return new FiveValidLogins();
	}*/
}