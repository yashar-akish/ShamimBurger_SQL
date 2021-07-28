
package PricingBurger;

import java.util.Scanner;

import static PricingBurger.My_SQLmethods.*;       //=======  import STATIC SQL METHODS from My_SQLmethods.java  class


public class Receipt {
    
    public static void main(String[] args){
        
        
        OrderMaker order = new OrderMaker();                                 //=========     director
        int chs = 0, tmt = 0, ltc = 0, crt = 0, egg = 0, lnt = 0;            //=========     additions
        int choose = 0, repeat = 0;                                          //=========     making the decisions
        final String DB_URL = "jdbc:sqlite:C:\\DARA\\database\\shamimDB.db"; //=========     database URL 

        
        System.out.println("\n\n\t\tSHAMIM BURGER\n\t==============================");
        
        do{
            do{         //=========     select type of burger
                System.out.println("\n# for Base type hamburger type    >>> 1\n# for Healthy type hamburger type >>> 2"
                                                                + "\n# for Deluxe type hamburger type  >>> 3"
                                                                + "\n# to cancel the order type        >>> 4");
                
                choose = ValidateInteger("\n  Please choose your desired Hamburger : ", choose);
            }while(choose != 1 && choose != 2 && choose != 3 && choose != 4);
            
            
            switch(choose){//=========     selects
            case 1:             //=========     base type
                chs = ValidateInteger("+ for adding cheese press  1   otherwise press any number :: ", chs);
                tmt = ValidateInteger("+ for adding tomato press  1   otherwise press any number :: ", tmt);
                ltc = ValidateInteger("+ for adding lettuce press 1   otherwise press any number :: ", ltc);
                crt = ValidateInteger("+ for adding carrot press  1   otherwise press any number :: ", crt);

                         //=========     making the order and dispaly
                HamburgerBuilder baseBurger = new BaseBurgerBuilder(chs,tmt,ltc,crt);
                order.setHaburgerBuilder(baseBurger);
                order.makeHamberger();
                Hamburger hamburgerBase = order.getHamburger();
                System.out.printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                        + "   Total Burger price is         $ %.2f\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                , hamburgerBase.getPrice());
                         //===============================  SAVING ON DATABASE  
                insertBaseBurger(DB_URL, chs,  tmt,  ltc,  crt, hamburgerBase.getPrice());
                insertShamimBurger(DB_URL,"Base Burger", hamburgerBase.getPrice());
                
                break;
            case 2:             //=========     helthy type
                egg = ValidateInteger("+ for adding egg   press    1   otherwise press any number :: ", egg);
                lnt = ValidateInteger("+ for adding Lentils   press    1   otherwise press any number :: ", lnt);
                         //=========     making the order and dispaly
                HamburgerBuilder healthBurger = new HealthyBurgerBuilder(egg,lnt);
                order.setHaburgerBuilder(healthBurger);
                order.makeHamberger();
                Hamburger hamburgerHealth = order.getHamburger();
                System.out.printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                        + "   Total Burger price is        $ %.2f\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                , hamburgerHealth.getPrice());
                          //===============================  SAVING ON DATABASE 
                insertHealthyBurger(DB_URL, egg, lnt, hamburgerHealth.getPrice());
                insertShamimBurger(DB_URL,"Healthy Burger", hamburgerHealth.getPrice());
                
                break;
            case 3:             //=========     deluxe type
                         //=========     making the order and dispaly
                HamburgerBuilder deluxeBurger = new DeluxeBurgerBuilder();
                order.setHaburgerBuilder(deluxeBurger);
                order.makeHamberger();
                Hamburger hamburgerDeluxe = order.getHamburger();
                System.out.printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                        + "   Total Burger price is        $ %.2f\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                , hamburgerDeluxe.getPrice());
                         //===============================  SAVING ON DATABASE
                insertDeluxeBurger(DB_URL, hamburgerDeluxe.getPrice());
                insertShamimBurger(DB_URL,"Deluxe Burger", hamburgerDeluxe.getPrice());

                break;
            default:
                System.out.println("    The order was canceled. ");
                break;
                    
            }         //=========     end of switch case  ************************
            
                //=========     asking for another order
            repeat = ValidateInteger("\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
                                  + "   Do you have another order ( yes : press 1 |  no : press any number ) :   ", repeat);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }while(repeat == 1);         //=========     ending the menue
        System.out.println("\n\n\t\t  THANK YOU FOR THE SHOPPING");
        System.out.println("\n\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n\n");
        //==============================================================================================================
        //                                 showing 4 tbles  +  total sell + count of sell                              =
        //=================================================  (( SQL ))  ================================================
        
        selectSqlShamim(DB_URL);
        selectSqlBase(DB_URL);
        selectSqlHealthy(DB_URL);
        selectSqlDeluxe(DB_URL);
        
        
        System.out.println("\n\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t this application is created by YASHAR AKISH :|: JUNE 2020");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

    }
     //     =====       =====       =====   *    END of THE PROGRAM    *   =====       =====       ======      ======
    
    
    //===============================================================================================================                                   
    //                                                    METHODS                                                   =
    //===============================================================================================================

    //======== validation the integer inputs:
    public static int ValidateInteger(String msg , int var){
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(msg);
            if (input.hasNextShort()) {
                var = input.nextShort();
                isValid = true;
            }
            else {
                System.out.println("  ⚠  Sorry! Invalid input. Try again.");
            }
            input.nextLine();
        } 
        return var;
    }
}
