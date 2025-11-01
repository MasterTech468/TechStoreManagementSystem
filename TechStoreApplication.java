
package techstoreapplication;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import techstoreapplication.DAO.Products.TechStoreManagement.Products;
import techstoreapplication.DAO.TechStoreManagement.TechStoreManagementSystem;

public class TechStoreApplication {
    private static Scanner kb = new Scanner(System.in);
    public static  int displayOptions(){
        System.out.println("============================TechStore Management System================================="
                + "\n!!!!PRESS 999 TO EXIT!!!!"
                + "\n1.Add Product"
                + "\n 2.Delete Product"
                + "\n 3.search Product"
                + "\n 4.UpdateProduct"
                + "\n 5.Display All Products"
                
                + "\n===================================================================================================");
              int UserOption = kb.nextInt();
              
              return UserOption;
    }
    public static Products createProduct(){
        System.out.println("Enter Name Of Product: ");
        String ProductName = kb.next();
        System.out.println("Enter ProductCode: ");
        String ProductCode = kb.next();
        System.out.println("Enter Product Quantity: ");
        Integer ProductQuantity =kb.nextInt();
        System.out.println("Enter Price for    "+ProductName+" : ");
        double ProductPrice = kb.nextDouble();
        
       
        Products product = new Products(ProductName,ProductCode,ProductQuantity,ProductPrice);
        return product;
    }
    public static void displayAll(List<Products> myList){
        String pname = "";
        String pcode = "";
        int pQuantity = 0;
        double Price = 0;
       String data = "";
       System.out.println("\n\n=========================Product Details==============================");
        for(Products a: myList){
            pname = a.getProductName();
            pcode = a.getProductCode();
            pQuantity = a.getProductAmnt();
            Price = a.getPrice();
            
            data ="Product Name: "+pname +"\nProduct Code: "+pcode+"\n Quantity: "+pQuantity+"\n Price R:"+Price;
           System.out.println(data);       
        }
        System.out.println("============================================================================\n\n");
        
    }
    public static void main(String[] args) throws SQLException {
        
       int Options = displayOptions();
       TechStoreManagementSystem tsm = new TechStoreManagementSystem("jdbc:derby://localhost:1527/TechStoreTbl", "app","app");
       Products s;
       while(Options!=999){
           switch(Options){
               case 1://add
                   s = createProduct();
                   if(tsm.add(s)){
                       System.out.println("Product Added Successfully");
                   }else{
                      System.err.println("Product Not Added");
                   }
                break;
               case 2://delete 
                     s = createProduct();
                     if(tsm.delete(s)){
                         System.out.println("Product Deleted Successfully");
                     }else{
                          System.err.println("Product Not Deleted");
                     }
                break;
               case 3: //search
                   s = createProduct();
                   if(tsm.get(s)==null){
                       System.err.println("Product Not Found Please Stock it");
                   }else{
                       System.out.println("Product Found !! ");
                   }
                break;
               case 4:// Update
                   s = createProduct();
                   if(tsm.update(s)){
                       System.out.println("Updated Sucessfully");
                   }else{
                       System.err.println("Not Updated");
                   }
                break;
               case 5://display all
                
                   List<Products> myProducts = tsm.getAll();
                   if(myProducts.isEmpty()){
                       System.err.println("No Products Available");
                   }else{
                      displayAll(myProducts); 
                   }
                 break;    
           }
          Options = displayOptions(); 
       }
    }
    
}
