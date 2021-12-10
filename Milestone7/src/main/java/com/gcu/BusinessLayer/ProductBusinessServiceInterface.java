package com.gcu.BusinessLayer;

import java.util.List;

import com.gcu.ReferenceArchitectureLayer.ProductModel;

public interface ProductBusinessServiceInterface
{

	public void init();
	public void destroy();
	
	public List<ProductModel> getAllproducts();
	 
	public void addProduct(ProductModel beingCreated);
	public void updateProduct(ProductModel beingUpdated);
	public void removeProduct(ProductModel beingDeleted);
	public void searchProduct_Name(String beingSearched);
	
	
	
}
