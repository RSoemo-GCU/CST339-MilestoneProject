package com.gcu.BusinessLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.ReferenceArchitectureLayer.ProductDatabaseModelInterface;
import com.gcu.ReferenceArchitectureLayer.ProductModel;

public class ProductBusinessService implements ProductBusinessServiceInterface 
{
	@Autowired
	ProductDatabaseModelInterface productDAO;
	
	@Override
	public void init() { productDAO.init(); }

	@Override
	public void destroy() { productDAO.destroy(); }

	@Override
	public List<ProductModel> getAllproducts() { return productDAO.getAllproducts(); }

	@Override
	public void addProduct(ProductModel beingCreated) { productDAO.addProduct(beingCreated); }

	@Override
	public void updateProduct(ProductModel beingUpdated) { productDAO.updateProduct(beingUpdated);}

	@Override
	public void removeProduct(ProductModel beingDeleted) { productDAO.removeProduct(beingDeleted); }

	@Override
	public void searchProduct_Name(String beingSearched) {  }
	
	// middle layer of nlayer
	
	// controller and tymeleaf
	
	// business service - this class
	
	// data service
	
	 
	

}
