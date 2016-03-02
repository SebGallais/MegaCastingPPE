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
import java.util.ArrayList;
import megacasting_ppe.classes.Client;
import megacasting_ppe.classes.Contrat;
import megacasting_ppe.classes.Domaine;
import megacasting_ppe.classes.Metier;
import megacasting_ppe.classes.Offre;
import static megacasting_ppe.dao.BDD.getINSTANCE;

/**
 *
 * @author Seb
 */
public class offreDAO {
       

    public static Offre trouverParReference(String ReferenceTemp) {
        Statement stmt = null;
        Offre offre = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Libelle, Reference, DateDebutPublication, DateFinPublication`, DateDebutContrat, DateFinContrat, DescriptionPoste, DescriptionProfil, NombresPoste, IdentifiantClient, IdentifiantMetier, IdentifiantContrat  FROM offre WHERE Reference = '" + ReferenceTemp + "'");

            while (rs.next()) {

                long Identifiant = rs.getLong("Identifiant");
                String Libelle = rs.getString("Libelle");
                String Reference = rs.getString("Reference");
                Date DateDebutPublication = rs.getDate("DateDebutPublication");
                Date DateFinPublication = rs.getDate("DateFinPublication");
                Date DateDebutContrat = rs.getDate("DateDebutContrat");
                Date DateFinContrat = rs.getDate("DateFinContrat");
                String DescriptionPoste = rs.getString("DescriptionPoste");
                String DescriptionProfil = rs.getString("DescriptionProfil");
                int NombresPoste = rs.getInt("NombresPoste");
                long IdentifiantClient = rs.getLong("IdentifiantClient");
                Client client = clientDAO.trouverparID(IdentifiantClient);
                long IdentifiantMetier = rs.getLong("IdentifiantMetier");
                Metier metier = metierDAO.trouverparID(IdentifiantMetier);
                long IdentifiantContrat = rs.getLong("IdentifiantContrat");
                Contrat contrat = contratDAO.trouverparID(IdentifiantContrat);
                
               
                offre = new Offre(Libelle, Reference, DateDebutPublication, DateFinPublication, DateDebutContrat, DateFinContrat, client, metier, contrat);
                offre.setIdentifiant(Identifiant);
                offre.setDescriptionPoste(DescriptionPoste);
                offre.setDescriptionProfil(DescriptionProfil);
                offre.setNbPoste(NombresPoste);
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
        return offre;
    }

    public static Offre trouverParId(long IdentifiantTemp) {
        Statement stmt = null;
        Offre offre = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Libelle, Reference, DateDebutPublication, DateFinPublication`, DateDebutContrat, DateFinContrat, DescriptionPoste, DescriptionProfil, NombresPoste, IdentifiantClient, IdentifiantMetier, IdentifiantContrat  FROM offre WHERE Identifiant = '" + IdentifiantTemp + "'");

            while (rs.next()) {

                long Identifiant = rs.getLong("Identifiant");
                String Libelle = rs.getString("Libelle");
                String Reference = rs.getString("Reference");
                Date DateDebutPublication = rs.getDate("DateDebutPublication");
                Date DateFinPublication = rs.getDate("DateFinPublication");
                Date DateDebutContrat = rs.getDate("DateDebutContrat");
                Date DateFinContrat = rs.getDate("DateFinContrat");
                String DescriptionPoste = rs.getString("DescriptionPoste");
                String DescriptionProfil = rs.getString("DescriptionProfil");
                int NombresPoste = rs.getInt("NombresPoste");
                long IdentifiantClient = rs.getLong("IdentifiantClient");
                Client client = clientDAO.trouverparID(IdentifiantClient);
                long IdentifiantMetier = rs.getLong("IdentifiantMetier");
                Metier metier = metierDAO.trouverparID(IdentifiantMetier);
                long IdentifiantContrat = rs.getLong("IdentifiantContrat");
                Contrat contrat = contratDAO.trouverparID(IdentifiantContrat);
                
               
                offre = new Offre(Libelle, Reference, DateDebutPublication, DateFinPublication, DateDebutContrat, DateFinContrat, client, metier, contrat);
                offre.setIdentifiant(Identifiant);
                offre.setDescriptionPoste(DescriptionPoste);
                offre.setDescriptionProfil(DescriptionProfil);
                offre.setNbPoste(NombresPoste);
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
        return offre;
    }

    public static ArrayList<Offre> Lister() {
        ArrayList<Offre> ListOffre = new ArrayList();
        Statement stmt = null;
        try {
            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Libelle, Reference, DateDebutPublication, DateFinPublication`, DateDebutContrat, DateFinContrat, DescriptionPoste, DescriptionProfil, NombresPoste, IdentifiantClient, IdentifiantMetier, IdentifiantContrat   FROM Offre ");
            while (rs.next()) {
                long Identifiant = rs.getLong("Identifiant");
                String Libelle = rs.getString("Libelle");
                String Reference = rs.getString("Reference");
                Date DateDebutPublication = rs.getDate("DateDebutPublication");
                Date DateFinPublication = rs.getDate("DateFinPublication");
                Date DateDebutContrat = rs.getDate("DateDebutContrat");
                Date DateFinContrat = rs.getDate("DateFinContrat");
                String DescriptionPoste = rs.getString("DescriptionPoste");
                String DescriptionProfil = rs.getString("DescriptionProfil");
                int NombresPoste = rs.getInt("NombresPoste");
                long IdentifiantClient = rs.getLong("IdentifiantClient");
                Client client = clientDAO.trouverparID(IdentifiantClient);
                long IdentifiantMetier = rs.getLong("IdentifiantMetier");
                Metier metier = metierDAO.trouverparID(IdentifiantMetier);
                long IdentifiantContrat = rs.getLong("IdentifiantContrat");
                Contrat contrat = contratDAO.trouverparID(IdentifiantContrat);

                Offre offre = new Offre(Libelle, Reference, DateDebutPublication, DateFinPublication, DateDebutContrat, DateFinContrat, client, metier, contrat);
                offre.setIdentifiant(Identifiant);
                offre.setDescriptionPoste(DescriptionPoste);
                offre.setDescriptionProfil(DescriptionProfil);
                offre.setNbPoste(NombresPoste);
                ListOffre.add(offre);
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

        return ListOffre;
    }

    public static ArrayList<Offre> ListerLibelle(String LibelleTemp) {
        ArrayList<Offre> ListOffre = new ArrayList();
        Statement stmt = null;
        try {
            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Libelle, Reference, DateDebutPublication, DateFinPublication`, DateDebutContrat, DateFinContrat, DescriptionPoste, DescriptionProfil, NombresPoste, IdentifiantClient, IdentifiantMetier, IdentifiantContrat   FROM Offre WHERE Libelle = '"+ LibelleTemp + "'");
            while (rs.next()) {
                long Identifiant = rs.getLong("Identifiant");
                String Libelle = rs.getString("Libelle");
                String Reference = rs.getString("Reference");
                Date DateDebutPublication = rs.getDate("DateDebutPublication");
                Date DateFinPublication = rs.getDate("DateFinPublication");
                Date DateDebutContrat = rs.getDate("DateDebutContrat");
                Date DateFinContrat = rs.getDate("DateFinContrat");
                String DescriptionPoste = rs.getString("DescriptionPoste");
                String DescriptionProfil = rs.getString("DescriptionProfil");
                int NombresPoste = rs.getInt("NombresPoste");
                long IdentifiantClient = rs.getLong("IdentifiantClient");
                Client client = clientDAO.trouverparID(IdentifiantClient);
                long IdentifiantMetier = rs.getLong("IdentifiantMetier");
                Metier metier = metierDAO.trouverparID(IdentifiantMetier);
                long IdentifiantContrat = rs.getLong("IdentifiantContrat");
                Contrat contrat = contratDAO.trouverparID(IdentifiantContrat);

                Offre offre = new Offre(Libelle, Reference, DateDebutPublication, DateFinPublication, DateDebutContrat, DateFinContrat, client, metier, contrat);
                offre.setIdentifiant(Identifiant);
                offre.setDescriptionPoste(DescriptionPoste);
                offre.setDescriptionProfil(DescriptionProfil);
                offre.setNbPoste(NombresPoste);
                ListOffre.add(offre);
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

        return ListOffre;
    }
    
    
}
