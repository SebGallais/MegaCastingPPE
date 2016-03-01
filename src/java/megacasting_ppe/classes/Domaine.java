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
public class Domaine {
    
    private Long identifiant;
    private String libelle;

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long Identifiant) {
        this.identifiant = Identifiant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String Libelle) {
        this.libelle = Libelle;
    }

    public Domaine(String Libelle) {
        this.libelle = Libelle;
    }
    
    
    
    
    
    
}
