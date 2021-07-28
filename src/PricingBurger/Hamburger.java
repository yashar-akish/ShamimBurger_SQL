
package PricingBurger;

public class Hamburger {
    
    private String bread = "";
    private String meat = "";
    private double price = 0;
    
    //=============   sets
    public void setBread(String bread){
        this.bread = bread;
    }
    
    public void setMeat(String meat){
        this.meat = meat;
    }
    
    public void setPrice(double price){
        this.price = price;
    }


    //=============   gets
    public String getBread(){
        return bread;
    }
    
    public String getMeat(){
        return meat;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void display(){}

}
