package com.gcu.DataAccessLayer;

import java.util.ArrayList;

import com.gcu.ReferenceArchitectureLayer.ProductDatabaseModelInterface;
import com.gcu.ReferenceArchitectureLayer.ProductModel;

public class ProductDataAccessService_production implements ProductDatabaseModelInterface
{
	//==================================================//
	//====================Variables=====================//
	//==================================================//
	private ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
	
	
	//=======================================================//
	//====================Init=&=Destroy=====================//
	//=======================================================//
	@Override
	public void init(){
		
		ProductModel p1 = new ProductModel(2, "test", "description", 8.50, 5);
		addProduct(p1);
	}
	
	@Override
	public void destroy(){}
	
	
	//====================================================//
	//====================Load=&=Save=====================//
	//====================================================//
	/*@Override
	public void loadData()
	{
		ProductModel loadedEntry1 = new ProductModel("Basil", "An essential oil that will acidicly melt the germs and skin right off your face. The skin that remains will look dazzling", 5.60, 30);
		addProduct(loadedEntry1);
		System.out.println(">>>>>>>" + productList.get(1).toString());
	}*/
	
	//=======================================================//
	//====================Get=Everything=====================//
	//=======================================================//
	@Override
	public ArrayList<ProductModel> getAllproducts() { return this.productList; }
	
	//===============================================================//
	//====================Create=Update=&=Delete=====================//
	//===============================================================//
	@Override
	public int addProduct(ProductModel beingCreated) { productList.add(beingCreated); return 1;}

	@Override
	public void updateProduct(ProductModel beingUpdated) {}

	@Override
	public void removeProduct(ProductModel beingDeleted) { productList.remove(beingDeleted); }

	
	//========================================================//
	//====================Search=Products=====================//
	//========================================================//
	@Override
	public void searchProduct_Name(String beingSearched)
	{}
}