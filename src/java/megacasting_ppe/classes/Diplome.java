/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting_ppe.classes;

import java.sql.Date;

/**
 *
 * @author Seb
 */
public class Diplome {
    private Long identifiant;
    private String intitule;
    private Date annee;
    private Cv cv;

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public Diplome(String intitule, Date annee, Cv cv) {
        this.intitule = intitule;
        this.annee = annee;
        this.cv = cv;
    }
    
    
    
    
    
    
}
