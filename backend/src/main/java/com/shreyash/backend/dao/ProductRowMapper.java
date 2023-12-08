package com.shreyash.backend.dao;

import com.shreyash.backend.product.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        return new Product(resultSet.getString("name"),
                resultSet.getInt("price"),
                resultSet.getString("url"),
                resultSet.getString("imageurl"));
    }
}
