
package PricingBurger;

public class HealthyBurgerBuilder extends HamburgerBuilder{
 
    private double basePrice = 5.67;
    private double eggPrice;
    private double lentilsPrice;
    private String type = "Healthy hamburger";
    
    
    //=============   constarcturs
    public HealthyBurgerBuilder(){}
    
    public HealthyBurgerBuilder( int egg, int lntl){
        if(egg == 1){
            this.eggPrice = 5.43;
        }
        if(lntl == 1){
            this.lentilsPrice = 3.41;
        }
    }

    //===============       get prices
    public double getEggPrice(){
        return eggPrice;
    }
    
    public double getLentilsPrice(){
        return lentilsPrice;
    }
    
    public double getPrice(){
        return basePrice;
    }
    
    public String getType(){
        return type;
    }
    
    //.......................... @Overrides
    
    @Override
    public void buildBread(){
        hamburger.setBread("Brown_rye_roll ");
    }
    @Override
    public void buildMeat(){
        hamburger.setMeat("Bacon");
    }
    @Override
    public void buildPrice(){
        double total = 0;
	total += getPrice();

	
        if( getEggPrice() > 0){
            total += getEggPrice();
        }
        if( getLentilsPrice() > 0){
            total += getLentilsPrice();
        }
        hamburger.setPrice(total);
    }
    @Override
    public void buildDisplay(){
	System.out.println("\n\n\t\tTHE ORDER IS READY\n\t==================================");	
        System.out.printf("\n%s on a %s with %s , price is $ %.2f\n"
                        ,getType(),hamburger.getBread(),hamburger.getMeat(),getPrice());
        if( getEggPrice() > 0){
            System.out.printf("\tAdded Egg for an extra $ %.2f\n", getEggPrice());
        }
        if( getLentilsPrice() > 0){
            System.out.printf("\tAdded Lentils for an extra $ %.2f\n", getLentilsPrice());
        }
    }
}
