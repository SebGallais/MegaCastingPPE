/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting_ppe.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import megacasting_ppe.classes.Compte;
import static megacasting_ppe.dao.BDD.getINSTANCE;

/**
 *
 * @author Seb
 */
public class compteDAO {
    public static void Creer(Compte compte) {

        Statement stmt = null;
        try {
            stmt = getINSTANCE().createStatement();
            stmt.executeUpdate("INSERT INTO compte(Pseudonyme, MotDePasse)"
                    + "VALUES('" + compte.getPseudonyme()+ "'"
                    + ",'" + compte.getMotdepasse() + "')");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Identifiant) FROM compte ");
            if (rs.next() == true) {
                Long id = rs.getLong(1);
                compte.setIdentifiant(id);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
        }

    }
    
     public static void Modifier(Compte newcompte, Compte oldcompte) {

        PreparedStatement pstmt = null;
        Long l;

        try {
            pstmt = getINSTANCE().prepareStatement("UPDATE compte SET Pseudonyme = ?, MotDePasse = ?  WHERE Identifiant = ?");
            pstmt.setString(1, newcompte.getPseudonyme());
            pstmt.setString(2, newcompte.getMotdepasse());
            

            l = oldcompte.getIdentifiant();
            pstmt.setLong(3, l);
            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            }
        }

    }
    
     
       public static void Supprimer(Compte compte){
       PreparedStatement pstmt = null; 
       Long l;
  try {
        pstmt = getINSTANCE().prepareStatement("DELETE FROM compte WHERE Identifiant = ?");
        l = compte.getIdentifiant();
        pstmt.setInt(1, l.intValue());
        pstmt.executeUpdate();
        
       }catch (Exception ex){
                ex.printStackTrace();
        } 
         finally{
      
            if(pstmt != null){
                try{
                    pstmt.close();
                 }
                catch(SQLException ex){  }   
            }
                    
           } 
        
    }
    
      public static Compte trouverparid(long IdentifiantTemp) {
        Statement stmt = null;
        Compte compte = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Pseudonyme, MotDePasse  FROM compte  WHERE Identifiant = '" + IdentifiantTemp + "'");

            while (rs.next()) {

                long Identifiant = rs.getLong("Identifiant");
                String Pseudonyme = rs.getString("Pseudonyme");
                String MotDePasse = rs.getString("MotDePasse");
                

                compte = new Compte(Pseudonyme, MotDePasse);
                compte.setIdentifiant(Identifiant);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
        }
        return compte;
    }
       
        public static Compte authentification(String PseudonymeTemp, String MotDePasseTemp) {
        Statement stmt = null;
        Compte compte = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Pseudonyme, MotDePasse  FROM compte  WHERE Pseudonyme = '" + PseudonymeTemp + "' AND MotDePasse = '" + MotDePasseTemp + "'");

            while (rs.next()) {

                long Identifiant = rs.getLong("Identifiant");
                String Pseudonyme = rs.getString("Pseudonyme");
                String MotDePasse = rs.getString("MotDePasse");
                

                compte = new Compte(Pseudonyme, MotDePasse);
                compte.setIdentifiant(Identifiant);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
        }
        return compte;
    }   
       
       
     public static Compte trouverparPseudonyme(String PseudonymeTemp) {
        Statement stmt = null;
        Compte compte = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Pseudonyme, MotDePasse  FROM compte  WHERE Pseudonyme = '" + PseudonymeTemp + "'");

            while (rs.next()) {

                long Identifiant = rs.getLong("Identifiant");
                String Pseudonyme = rs.getString("Pseudonyme");
                String MotDePasse = rs.getString("MotDePasse");
                

                compte = new Compte(Pseudonyme, MotDePasse);
                compte.setIdentifiant(Identifiant);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
        }
        return compte;
    }
    
    
    
}
