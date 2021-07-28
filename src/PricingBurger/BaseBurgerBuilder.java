
package PricingBurger;


public class BaseBurgerBuilder extends HamburgerBuilder{
    
    private double basePrice = 3.56;
    private double cheesePrice;
    private double tomatoPrice;
    private double lettucePrice;
    private double carrotPrice;
    private String type = "Basic hamburger";

    
    //=============   constarcturs
    public BaseBurgerBuilder(){}
    
    public BaseBurgerBuilder( int chs, int tmt, int ltc, int crt){
        if(chs == 1){
            this.cheesePrice = 1.33;
        }
        if(tmt == 1){
            this.tomatoPrice = 0.27;
        }
        if(ltc == 1){
            this.lettucePrice = 0.75;
        }
        if(crt == 1){
            this.carrotPrice = 0.22;
        }
    }
    
    
    //===============       get prices
    public double getCheesePrice(){
        return cheesePrice;
    }
    
    public double getTomatoPrice(){
        return tomatoPrice;
    }
    
    public double getLettucePrice(){
        return lettucePrice;
    }
    
    public double getCarrotPrice(){
        return carrotPrice;
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
        hamburger.setBread("White_roll");
    }
    
    @Override
    public void buildMeat(){
        hamburger.setMeat("Sausage");
    }
    
    @Override
    public void buildPrice(){
        double total = 0;
	total += getPrice();
       if( getCheesePrice() > 0){
            total += getCheesePrice();
        }
        if( getTomatoPrice() > 0){
            total += getTomatoPrice();
        }
        if( getLettucePrice() > 0){
            total += getLettucePrice();
        }
        if( getCarrotPrice() > 0){
            total += getCarrotPrice();
        }
        hamburger.setPrice(total);
    }
    
    @Override
    public void buildDisplay(){
        System.out.println("\n\n\t\tTHE ORDER IS READY\n\t==================================");
        System.out.printf("\n%s on a %s with %s , price is $ %.2f\n"
                            ,getType(),hamburger.getBread(),hamburger.getMeat(),getPrice());
        if( getCheesePrice() > 0){
            System.out.printf("\tAdded Cheese for an extra $ %.2f\n", getCheesePrice());
        }
        if( getTomatoPrice() > 0){
            System.out.printf("\tAdded Tomato for an extra $ %.2f\n", getTomatoPrice());
        }
        if( getLettucePrice() > 0){
            System.out.printf("\tAdded Lettuce for an extra $ %.2f\n", getLettucePrice());
        }
        if( getCarrotPrice() > 0){
            System.out.printf("\tAdded Carrot for an extra $ %.2f\n", getCarrotPrice());
        }
    }

}
