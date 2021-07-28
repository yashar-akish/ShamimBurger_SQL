
package PricingBurger;

import java.sql.*;
import java.text.DecimalFormat;

public class My_SQLmethods {

    
    //  ====================================    create table if not exists......
    //  ====================================    insert into.....
    
    //insert into shamim burger     ==============================================
    public static void insertShamimBurger(String DB_URL,String type, double price){
        try{
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            
            statement.execute("create table if not exists shamimBurger" 
                     + "(sellingDate Date,type text, price double)");
            
            statement.execute("insert into shamimBurger (sellingDate,type,price) " +
                    "values(Date('now'),'"+type+"', " + price +")");
            
            statement.close();
            conn.close();
            System.out.println("<<successfully added to shamimBurger table>>");
                    
            }catch(SQLException e){
                 System.out.println("something is wrong : " + e.getMessage());
            }
    }
    
    //insert into base burger   ==============================================
    public static void insertBaseBurger(String DB_URL, int chs, int tmt, int ltc, int crt, double price){
        
        try{
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            
            statement.execute("create table if not exists baseBurger"
                     + "(sellingDate Date, cheese int, tomato int, lettuce int, carrot int, price double)");
            
            if(chs != 1)chs = 0; if(tmt != 1)tmt = 0; if(ltc != 1)ltc = 0; if(crt != 1)crt = 0;
            
            statement.execute("insert into baseBurger (sellingDate,cheese,tomato,lettuce,carrot,price) " +
                    "values(Date('now'), " + chs + ", " + tmt+", " + ltc + ", " + crt + ", " + price +")");
            
            statement.close();
            conn.close();
            System.out.println("<<successfully added to baseBurger table>>");
                    
            }catch(SQLException e){
                 System.out.println("something is wrong : " + e.getMessage());
            }
    }
       
    //insert into healthy burger    ==============================================
    public static void insertHealthyBurger(String DB_URL, int egg, int lnt, double price){
        
        try{
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            
            statement.execute("create table if not exists healthBurger"   
                      + "(sellingDate Date, egg int, lentils int, price double)");
            
            if(egg != 1)egg = 0; if(lnt != 1)lnt = 0;
                    
            statement.execute("insert into healthBurger (sellingDate,egg,lentils,price) " +
                    "values(Date('now'), " + egg + ", " + lnt +", " + price +")");
            
            statement.close();
            conn.close();
            System.out.println("<<successfully added to healthBurger table>>");
                    
            }catch(SQLException e){
                System.out.println("something is wrong : " + e.getMessage());
            }
    }
    
    //insert into deluxe burger     ==============================================
    public static void insertDeluxeBurger(String DB_URL, double price){
        
        try{
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            
            statement.execute("create table if not exists deluxeBurger"  
                     + "(sellingDate Date, chips int, drink int, price double)");
            
            statement.execute("insert into deluxeBurger (sellingDate,chips,drink,price) " +
                    "values(Date('now'), '1', '1', " + price +")");
            
            statement.close();
            conn.close();
            System.out.println("<<successfully added to deluxeBurger table>>");
                    
        }catch(SQLException e){
            System.out.println("something is wrong : " + e.getMessage());
        }                                       
    }
    
//=====================================================    SELECT * FROM...... 
//=====================================================    SELECT sum(price) AS Total FROM

    //  select from shamim table    ==============================================
    public static void selectSqlShamim(String DB_URL){
        try{
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            int count = 0;
            
            statement.execute("SELECT * FROM shamimBurger");
            ResultSet results = statement.getResultSet();
            System.out.println("------------ SHAMIM  BURGER -----------");
            System.out.println("  DATE     ||       TYPE      ||  PRICE");
            System.out.println("---------------------------------------");
            while(results.next()){
                System.out.printf(results.getString("sellingDate") + " || " +
                                   "%25s",results.getString("type") + " ||  " +
                                   df2.format(results.getDouble("price"))+"\n");
                count++;
            }//++++++++++++++++     SELECT sum(price) AND count of sold burger
            System.out.println("____________________________________________________");
            statement.execute("SELECT sum(price) AS Total FROM shamimBurger");
            ResultSet resultsT = statement.getResultSet();
            System.out.println("   total sell of Shamim burger is:\t$ "+df2.format(resultsT.getDouble( "Total")));
            System.out.println("    "+count+" burgers have been sold"); 
            System.out.println("____________________________________________________\n\n");
            
        }catch(SQLException e){
            System.out.println("something is wrong : " + e.getMessage());
        }
    }
    
    //  select from base table  ==============================================
    public static void selectSqlBase(String DB_URL){
        try{
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            int count = 0;
            
            statement.execute("SELECT * FROM baseBurger");
            ResultSet resultsB = statement.getResultSet();
            System.out.println("------------------- BASE  BURGER -----------------");
            System.out.println("  DATE      |cheese|tomato|lettuce|carrot|price");
            System.out.println("--------------------------------------------------");
            while(resultsB.next()){
                System.out.println(resultsB.getString("sellingDate") + "  | " +
                                   resultsB.getInt("cheese") + "   |   " +
                                   resultsB.getInt("tomato") + "   |   " +
                                   resultsB.getInt("lettuce") + "   |   " +
                                   resultsB.getInt("carrot") + "   |   " +
                                   df2.format(resultsB.getDouble("price")));
                count++;
            }//++++++++++++++++     SELECT sum(price) AND count of sold burger
            System.out.println("____________________________________________________");
            statement.execute("SELECT sum(price) AS Total FROM baseBurger");//      total sell
            ResultSet resultsTB = statement.getResultSet();
            System.out.println("   total sell of Base burger is:\t$ "+df2.format(resultsTB.getDouble( "Total")));
            System.out.println("    "+count+" base burgers have been sold");
            System.out.println("____________________________________________________\n\n");
        
        }catch(SQLException e){
            System.out.println("something is wrong : " + e.getMessage());
        }
    }
    
    //  select from healthy table   ==============================================
    public static void selectSqlHealthy(String DB_URL){
        try{
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            int count = 0;
            
            statement.execute("SELECT * FROM healthBurger");
            ResultSet resultsH = statement.getResultSet();
            System.out.println("------- HEALTHY  BURGER -------");
            System.out.println("  DATE     |egg|lentils|price");
            System.out.println("-------------------------------");
            while(resultsH.next()){
                System.out.println(resultsH.getString("sellingDate") + " | " +
                                   resultsH.getInt("egg") + "  |  " +
                                   resultsH.getInt("lentils") + "  |  " +
                                   df2.format(resultsH.getDouble("price")));
                count++;
            }//++++++++++++++++     SELECT sum(price) AND count of sold burger
            System.out.println("____________________________________________________");
            statement.execute("SELECT sum(price) AS Total FROM healthBurger");//    total seel
            ResultSet resultsTH = statement.getResultSet();
            System.out.println("   total sell of Healthy burger is:\t$ "+df2.format(resultsTH.getDouble( "Total")));
            System.out.println("    "+count+" healthy burgers have been sold");
            System.out.println("____________________________________________________\n\n");
            
            }catch(SQLException e){
            System.out.println("something is wrong : " + e.getMessage());
        }
    }
    
    //  select from deluxe table    ==============================================
    public static void selectSqlDeluxe(String DB_URL){
        
        try{
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement();
            int count = 0;
            statement.execute("SELECT * FROM deluxeBurger");
            ResultSet resultsD = statement.getResultSet();
            System.out.println("-------- DELUXE  BURGER -------");
            System.out.println("  DATE     |chips|drink|price");
            System.out.println("-------------------------------");
            while(resultsD.next()){
                System.out.println(resultsD.getString("sellingDate") + " |  " +
                                   resultsD.getInt("chips") + "  |  " +
                                   resultsD.getInt("drink") + "  |  " +
                                   df2.format(resultsD.getDouble("price")));
                count++;
            }//++++++++++++++++     SELECT sum(price) AND count of sold burger
            System.out.println("____________________________________________________");
            statement.execute("SELECT sum(price) AS Total FROM deluxeBurger");//        total sell
            ResultSet resultsTD = statement.getResultSet();
            System.out.println("   total sell of Deluxe burger is:\t$ "+df2.format(resultsTD.getDouble( "Total")));
            System.out.println("    "+count+" deluxe burgers have been sold");
            System.out.println("____________________________________________________");
            statement.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("something is wrong : " + e.getMessage());
        }
    }
    
    
    //========  Display double in 2 decimal places for price from sql
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    
}
