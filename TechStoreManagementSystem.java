package techstoreapplication.DAO.TechStoreManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import techstoreapplication.DAO.DAO;
import techstoreapplication.DAO.Products.TechStoreManagement.Products;

public class TechStoreManagementSystem implements DAO<Products>{
    private Connection connection;

    private  Connection getConnection(String dbUrl,String username, String password) throws SQLException {
        connection = DriverManager.getConnection(dbUrl,username,password);
        return connection;
    }

    public  TechStoreManagementSystem(String dbUrl,String username,String password) throws SQLException {
        connection = getConnection(dbUrl,username,password);
    }
    
    @Override
    public boolean add(Products t) {
       String sql = "INSERT INTO TECHSTORETBL(PRODUCTNAME, PRODUCTCODE, QUANTITY,PRICE)"
               + " VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1,t.getProductName());
            ps.setString(2,t.getProductCode());
            ps.setInt(3,t.getProductAmnt());
            ps.setDouble(4, t.getPrice());
            ps.executeUpdate();
           return true;
            
        } catch (SQLException ex) {
           System.err.println(""+ex.getMessage());
            return false;
        }
       
    }

    @Override
    public boolean update(Products t) {
      String sql = "UPDATE TECHSTORETBL SET QUANTITY = ?,PRICE = ? WHERE PRODUCTCODE =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,t.getProductAmnt());
            ps.setDouble(2,t.getPrice());
            ps.setString(3,t.getProductCode());
            ps.executeUpdate();
           return true;
        } catch (SQLException ex) {
            System.err.println(""+ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Products t) {
        String sql = "DELETE FROM TECHSTORETBL WHERE PRODUCTNAME = ?";
         
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,t.getProductName());
            ps.executeUpdate();
           return true;
        } catch (SQLException ex) {
            System.err.println(""+ex.getMessage());
            return false;
        }    
    }

    @Override
    public Products get(Products t) {
        String sql = "SELECT  PRODUCTNAME,PRODUCTCODE,QUANTITY,PRICE FROM TECHSTORETBL WHERE PRODUCTNAME = ?";
        
      try{
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, t.getProductName());
        ResultSet rs = ps.executeQuery();
          
       if(rs.next()){
            String Productname = rs.getString("PRODUCTNAME");
            String ProductCode = rs.getString("PRODUCTCODE");
            Integer ProductQuantity = rs.getInt("QUANTITY");
            double Price = rs.getDouble("PRICE");
            
            Products products = new Products(Productname,ProductCode,ProductQuantity,Price);
            rs.close();
            return products;
       }else{
         rs.close();
         return null; 
       }
      }catch(SQLException ex){
          System.err.println(ex.getMessage());
          return null;
      }
    }

    @Override
    public List<Products> getAll() {
        String sql = "SELECT * FROM TECHSTORETBL ";
        List<Products> productsList = new ArrayList<>();
        
        try {
            
          PreparedStatement  ps = connection.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();

          while(rs.next()){
             String Productname = rs.getString("PRODUCTNAME");
             String ProductCode = rs.getString("PRODUCTCODE");
             Integer ProductQuantity = rs.getInt("QUANTITY");
             double Price = rs.getDouble("PRICE");
             Products products = new Products(Productname,ProductCode,ProductQuantity,Price);
             productsList.add(products);
              
            }
            return productsList;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
          return null;
        }   
    }
    
}
