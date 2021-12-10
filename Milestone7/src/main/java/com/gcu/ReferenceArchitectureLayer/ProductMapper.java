package com.gcu.ReferenceArchitectureLayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ProductMapper implements RowMapper<ProductModel>
{

	@Override
	public ProductModel mapRow(ResultSet resultSet, int rowNum) throws SQLException
	{
		ProductModel product = new ProductModel
			(
					resultSet.getInt("id"),
					resultSet.getString("name"),
					resultSet.getString("description"),
					resultSet.getFloat("price"),
					resultSet.getInt("amountInStock")
			);
		return product;
	}

}
