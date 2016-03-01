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
public class ExperiencesProfessionnelles {
    private Long   identifiant;
    private String nomEntreprise;
    private String type;
    private String description;
    private Date   dateDebut;
    private Date   dateFin;
    private Cv     cv;

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public ExperiencesProfessionnelles(String nomEntreprise, String type, String description, Date dateDebut, Cv cv) {
        this.nomEntreprise = nomEntreprise;
        this.type = type;
        this.description = description;
        this.dateDebut = dateDebut;
        this.cv = cv;
    }
    
    
}

    
