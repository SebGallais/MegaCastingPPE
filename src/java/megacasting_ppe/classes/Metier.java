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
public class Metier {
    
    private Long identifiant;
    private String libelle;
    private Domaine domaine;

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

  

    public Metier(String Libelle, Domaine domaine) {
        this.libelle = Libelle;
        this.domaine = domaine;
    }
    
    
    
    
    
    
}
