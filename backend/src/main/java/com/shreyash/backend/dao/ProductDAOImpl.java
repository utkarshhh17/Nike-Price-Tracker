package com.shreyash.backend.dao;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.jdbc.core.JdbcTemplate;
import com.shreyash.backend.product.Product;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{
    private Dotenv dotenv = Dotenv.configure().load();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

    @Override
    public boolean insertProduct(Product product) {
        try{
            String insertQuery = "INSERT INTO PRODUCT VALUES (?,?,?,?)";
            Object[] args = {product.getURL(), product.getName(), product.getPrice(), product.getImageURL()};
            jdbcTemplate.update(insertQuery, args);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Product getProduct(String URL) {
        String fetchQuery = "SELECT * FROM PRODUCT WHERE URL = ?";
        Object[] args = {URL};
        Product product =  jdbcTemplate.queryForObject(fetchQuery, args, new ProductRowMapper());
        return product;
    }

    @Override
    public List<Product> getProducts() {
        String fetchQuery = "SELECT * FROM PRODUCT";
        List<Product> products = jdbcTemplate.query(fetchQuery, new ProductRowMapper());
        return products;
    }

    @Override
    public boolean removeProduct(String productURL) {
        try{
            String query = "DELETE FROM PRODUCT WHERE URL=?";
            Object[] args = {productURL};
            jdbcTemplate.update(query, args);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public DataSource getDataSource(){
        return new DriverManagerDataSource(dotenv.get("DB_URL"), dotenv.get("DB_USER"), dotenv.get("DB_PASS"));
    }
}
