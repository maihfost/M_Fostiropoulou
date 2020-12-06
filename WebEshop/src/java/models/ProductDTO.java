package models;


public class ProductDTO {
    private int productId;
    private int quantity;
    private double price;

    public ProductDTO(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

   

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductIdQuantity{" + "productId=" + productId + ", quantity=" + quantity + ", price=" + price + '}';
    }

    
}
