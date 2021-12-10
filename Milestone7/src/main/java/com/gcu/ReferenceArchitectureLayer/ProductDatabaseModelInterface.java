package com.gcu.ReferenceArchitectureLayer;

import java.util.List;

public interface ProductDatabaseModelInterface
{
	public void init();
	public void destroy();
	
	public List<ProductModel> getAllproducts();
	 
	public int addProduct(ProductModel beingCreated);
	public void updateProduct(ProductModel beingUpdated);
	public void removeProduct(ProductModel beingDeleted);
	public void searchProduct_Name(String beingSearched);
}
