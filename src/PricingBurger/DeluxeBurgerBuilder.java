
package PricingBurger;

public class DeluxeBurgerBuilder extends HamburgerBuilder{
    
    private double basePrice = 14.54;
    private double chipsPrice;
    private double drinkPrice;
    private String type = "Deluxe hamburger";
    
    
    //=============   constarcturs

    public DeluxeBurgerBuilder(){
            this.chipsPrice = 2.75;
            this.drinkPrice = 1.81;
    }
    //===============       get prices
    public double getChipsPrice(){
        return chipsPrice;
    }
    public double getDrinkPrice(){
        return drinkPrice;
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
        hamburger.setBread("White_roll ");
    }
    @Override
    public void buildMeat(){
        hamburger.setMeat("Sausage & Bacon");
    }
    @Override
    public void buildPrice(){
        double total;
        total = getPrice() + getChipsPrice() + getDrinkPrice();
        hamburger.setPrice(total);
    }
    @Override
    public void buildDisplay(){
	System.out.println("\n\n\t\tTHE ORDER IS READY\n\t==================================");	
        System.out.printf("\n%s on a %s with %s , price is $ %.2f\n",getType(),hamburger.getBread(),hamburger.getMeat(),getPrice());
	System.out.println(" ⚠ Can not add additional items to a deluxe burger <<");
        System.out.printf("\tAdded chips for an extra $ %.2f\n", getChipsPrice());
        System.out.printf("\tAdded Drink for an extra $ %.2f\n", getDrinkPrice());
    }
    
}
