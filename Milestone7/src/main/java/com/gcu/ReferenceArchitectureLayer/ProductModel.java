package com.gcu.ReferenceArchitectureLayer;

public class ProductModel
{
	//========================================================//
	//====================Model=Variables=====================//
	//========================================================//
	private int id;
	private String name;
	private String description;
	private double price;
	private int amountInStock;
	
	
	
	//========================================================//
	//======================Constructors======================//
	//========================================================//
	//============Default============//
	public ProductModel() 
	{
		super();
	}

	//============Definer============//
	public ProductModel(int id, String name, String description, double price, int amountInStock)
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.amountInStock = amountInStock;
	}
	
	
	
	//========================================================//
	//===================Getters=&=Setters====================//
	//========================================================//
	//============ID============//
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	//public int getID() { return id; }
	//public void setID(int id) { this.id = id; }
	//============Name============//
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	//============Description============//
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	//============Price============//
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }
	//============AmountInStock============//
	public int getAmountInStock() { return amountInStock; }
	public void setAmountInStock(int amountInStock) { this.amountInStock = amountInStock; }
	
	
	
	//========================================================//
	//===================toString=Override====================//
	//========================================================//
	@Override
	public String toString()
	{
		return "ProductModel Object: "
				+ "'ID=" + getId() + "', "
				+ "'Name=" + getName() + "', "
				+ "'Description=" + getDescription() + "', "
				+ "'Price=" + getPrice() + "', "
				+ "'AmmountInStock=" + getAmountInStock() + "' ";
	}
}