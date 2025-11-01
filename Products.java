package techstoreapplication.DAO.Products.TechStoreManagement;
public class Products {
    private String ProductName;
    private String ProductCode;
    private Integer ProductAmnt;
    private double Price;

    public Products() {
    }

    public Products(String ProductName, String ProductCode, Integer ProductAmnt, double Price) {
        this.ProductName = ProductName;
        this.ProductCode = ProductCode;
        this.ProductAmnt = ProductAmnt;
        this.Price = Price;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String ProductCode) {
        this.ProductCode = ProductCode;
    }

    public Integer getProductAmnt() {
        return ProductAmnt;
    }

    public void setProductAmnt(Integer ProductAmnt) {
        this.ProductAmnt = ProductAmnt;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    
}
