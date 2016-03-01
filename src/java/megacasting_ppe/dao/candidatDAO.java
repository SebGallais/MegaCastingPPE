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
import megacasting_ppe.classes.Candidat;
import megacasting_ppe.classes.Compte;
import megacasting_ppe.classes.Contrat;
import static megacasting_ppe.dao.BDD.getINSTANCE;

/**
 *
 * @author Seb
 */
public class candidatDAO {
     public static void Creer(Candidat candidat) {

        Statement stmt = null;
        try {
            stmt = getINSTANCE().createStatement();
            stmt.executeUpdate("INSERT INTO candidat(Nom, Prenom, Email, Telephone, Portable, Rue, CP, Ville, DateNaissance, Permis, IdentifiantCompte)"
                    + "VALUES('" + candidat.getNom() + "'"
                    + ",'" + candidat.getPrenom()+ "'"
                    + ",'" + candidat.getEmail()+ "'"
                    + ",'" + candidat.getTelephone()+ "'"
                    + ",'" + candidat.getPortable() + "'"
                    + ",'" + candidat.getRue()+ "'"
                    + ",'" + candidat.getCodePostal()+ "'"
                    + ",'" + candidat.getVille()+ "'"
                    + ",'" + candidat.getDateNaissance() + "'"
                    + ",'" + candidat.getPermis() + "'"
                    + ",'" + candidat.getCompte().getIdentifiant() + "')");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Identifiant) FROM candidat ");
            if (rs.next() == true) {
                Long id = rs.getLong(1);
                candidat.setIdentifiant(id);
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
     
     
       public static void Modifier(Candidat newcandidat, Compte oldcandidat) {

        PreparedStatement pstmt = null;
        Long l;

        try {
            pstmt = getINSTANCE().prepareStatement("UPDATE candidat SET Nom = ? , Prenom = ?, Email = ? , Telephone = ? , Portable = ? , Rue = ?, CP = ? , Ville = ? , DateNaissance = ? , Permis = ? , IdentifiantCompte = ?   WHERE Identifiant = ?");
            pstmt.setString(1, newcandidat.getNom());
            pstmt.setString(2, newcandidat.getPrenom());
            pstmt.setString(3, newcandidat.getEmail());
            pstmt.setString(4, newcandidat.getTelephone());
            pstmt.setString(5, newcandidat.getPortable());
            pstmt.setString(6, newcandidat.getRue());
            pstmt.setInt(7, newcandidat.getCodePostal());
            pstmt.setString(8, newcandidat.getVille());
            pstmt.setDate(9, newcandidat.getDateNaissance());
            pstmt.setString(10, newcandidat.getPermis());
            pstmt.setLong(11, newcandidat.getCompte().getIdentifiant());
            
            l = oldcandidat.getIdentifiant();
            pstmt.setLong(12, l);
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
    
     
       public static void Supprimer(Candidat candidat){
       PreparedStatement pstmt = null; 
       Long l;
  try {
        pstmt = getINSTANCE().prepareStatement("DELETE FROM candidat WHERE Identifiant = ?");
        l = candidat.getIdentifiant();
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
       
    public static Candidat trouverparID(long IdentifiantTemp) {
        Statement stmt = null;
        Candidat candidat = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Nom, Prenom, Email, Telephone, Portable, Rue, CP, Ville, DateNaissance, Permis, IdentifiantCompte FROM candidat WHERE Identifiant = '" + IdentifiantTemp + "'");

            while (rs.next()) {

                long Identifiant = rs.getLong("Identifiant");
                String Nom = rs.getString("Nom");
                String Prenom = rs.getString("Prenom");
                String Email = rs.getString("Email");
                String Telephone = rs.getString("Telephone");
                String Portable = rs.getString("Portable");
                String Rue = rs.getString("Rue");
                int CP = rs.getInt("CP");
                String Ville = rs.getString("Ville");
                Date DateNaissance = rs.getDate("DateNaissance");
                String Permis = rs.getString("Permis");
                long IdentifiantCompte = rs.getLong("IdentifiantCompte");
                Compte compte = compteDAO.trouverparid(IdentifiantCompte);
                
                candidat = new Candidat( Nom, Prenom, Email, Telephone, Portable, Rue, CP, Ville, DateNaissance, Permis, compte);
                candidat.setIdentifiant(Identifiant);
                
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
        return candidat;
   
    }
}
