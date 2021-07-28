
package PricingBurger;

public abstract class HamburgerBuilder {
    
    protected Hamburger hamburger;
    
    public Hamburger getHamburger(){
        return hamburger;
    }
    
    public void creatNewHamburgerProduct(){
        hamburger = new Hamburger();
    }
    
    public abstract void buildBread();
    public abstract void buildMeat();
    public abstract void buildDisplay();
    public abstract void buildPrice();
}
