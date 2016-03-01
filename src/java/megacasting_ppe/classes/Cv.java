/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting_ppe.classes;

/**
 *
 * @author Seb
 */
public class Cv {
    private Long   identifiant;
    private String titre;
    private String divers;
    private Candidat candidat;

    public Long getIdentifant() {
        return identifiant;
    }

    public String getDivers() {
        return divers;
    }

    public void setDivers(String divers) {
        this.divers = divers;
    }

    
    public void setIdentifant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Cv(Long identifiant, String titre,String divers, Candidat candidat) {
        this.identifiant = identifiant;
        this.titre = titre;
        this.divers = divers;
        this.candidat = candidat;
    }
    


    
}

