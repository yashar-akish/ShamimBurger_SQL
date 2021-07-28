
package PricingBurger;

public class OrderMaker {
    private HamburgerBuilder hamburgerBuilder;
    
    public void setHaburgerBuilder(HamburgerBuilder HB){
        hamburgerBuilder = HB;
    }
    
    public Hamburger getHamburger(){
        return hamburgerBuilder.getHamburger();
    }
    
    public void makeHamberger(){
        hamburgerBuilder.creatNewHamburgerProduct();
        hamburgerBuilder.buildBread();
        hamburgerBuilder.buildMeat();
        hamburgerBuilder.buildDisplay();
        hamburgerBuilder.buildPrice();
    }
}
