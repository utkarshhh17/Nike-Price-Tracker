package com.shreyash.backend.dao;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.jdbc.core.JdbcTemplate;
import com.shreyash.backend.product.Product;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;

@Service
public class ProductDAOImpl implements ProductDAO{
    private Dotenv dotenv = Dotenv.configure().load();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

    @Override
    public void insert(Product product) {
        String insertQuery = "INSERT INTO PRODUCT VALUES (?,?,?,?)";
        Object[] args = {product.getURL(), product.getName(), product.getPrice(), product.getImageURL()};
        int row = jdbcTemplate.update(insertQuery, args);
        System.out.println("Inserted " + row + " Product with name "+ product.getName());
    }


    public DataSource getDataSource(){
        return new DriverManagerDataSource(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASS"));
    }
}
