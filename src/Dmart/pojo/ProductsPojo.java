/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dmart.pojo;

/**
 *
 * @author INDIA TECHNOLOGY
 */
public class ProductsPojo {

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public ProductsPojo()
    {
        
    }

    public ProductsPojo(String ProductId, String ProductName, String ProductCompany, Double ProductPrice, Double OurPrice, int Tax, int Quantity,double total) {
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.ProductCompany = ProductCompany;
        this.ProductPrice = ProductPrice;
        this.OurPrice = OurPrice;
        this.Tax = Tax;
        this.Quantity = Quantity;
        this.total=total;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductCompany() {
        return ProductCompany;
    }

    public void setProductCompany(String ProductCompany) {
        this.ProductCompany = ProductCompany;
    }

    public Double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(Double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public Double getOurPrice() {
        return OurPrice;
    }

    public void setOurPrice(Double OurPrice) {
        this.OurPrice = OurPrice;
    }

    public int getTax() {
        return Tax;
    }

    public void setTax(int Tax) {
        this.Tax = Tax;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    private String ProductId;
    private String ProductName;
    private String ProductCompany;
    private Double ProductPrice;
    private Double OurPrice;
    private int Tax;
    private int Quantity;
    private double total;
            
    
}
