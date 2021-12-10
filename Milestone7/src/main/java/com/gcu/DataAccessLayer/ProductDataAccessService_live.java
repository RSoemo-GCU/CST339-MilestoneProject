package com.gcu.DataAccessLayer;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.ReferenceArchitectureLayer.ProductDatabaseModelInterface;
import com.gcu.ReferenceArchitectureLayer.ProductMapper;
import com.gcu.ReferenceArchitectureLayer.ProductModel;

@Repository
public class ProductDataAccessService_live implements ProductDatabaseModelInterface
{
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	@Override
	public void init() {}

	@Override
	public void destroy() {}
	
	public ProductDataAccessService_live(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ProductModel> getAllproducts()
	{
		return jdbcTemplate.query("select * from products", new ProductMapper());
	}

	@Override
	public int addProduct(ProductModel beingCreated)
	{
		return jdbcTemplate.update
				(
						"insert into products (name, description, price, amountInStock) value(?, ?, ?, ?)",
						beingCreated.getName(),
						beingCreated.getDescription(),
						beingCreated.getPrice(),
						beingCreated.getAmountInStock()
				);
	}

	
	@Override
	public void updateProduct(ProductModel beingUpdated)
	{
		jdbcTemplate.update
		(
				"update products set id=?, name=?, description=?, price=?, amountInStock=? where id=?",
				beingUpdated.getId(),
				beingUpdated.getName(),
				beingUpdated.getDescription(),
				beingUpdated.getPrice(),
				beingUpdated.getAmountInStock(),
				beingUpdated.getId()
		);
	}

	@Override
	public void removeProduct(ProductModel beingDeleted)
	{
		jdbcTemplate.update
		(
				"delete from products where id=?",
				beingDeleted.getId()
		);
	}

	@Override
	public void searchProduct_Name(String beingSearched) {
		// TODO Auto-generated method stub
		
	}

}
