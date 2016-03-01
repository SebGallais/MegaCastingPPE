package megacasting_ppe.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public abstract class BDD
{
    private static Connection CNX;

    public static Connection getINSTANCE()
    {
        if (CNX == null){
            createConnection();
        }
        return CNX;
    }
    private static void createConnection()
    {
        String server = "127.0.0.1";
        
        String bdd = "megacastingv2";
        String url = "jdbc:mysql://"+server+"/"+bdd;
        String driver ="com.mysql.jdbc.Driver";
        try 
        {
            Class.forName(driver);
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        
        try 
        {
            CNX = DriverManager.getConnection(url, "root", "");
            
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    
    public static Connection Close()
    {
        if (CNX != null) 
        {
            try 
            {
                CNX.close();
                CNX = null;
                
            } 
            catch (SQLException ex) 
            {
                ex.printStackTrace();
            }
        }
        return CNX;
    }
    
}
