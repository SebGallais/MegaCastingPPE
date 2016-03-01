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
public class Diffuseur {
    private Long identifiant;
    private String nomEntreprise;
    private Compte compte;

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long Identifiant) {
        this.identifiant = Identifiant;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String NomEntreprise) {
        this.nomEntreprise = NomEntreprise;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Diffuseur(String nomEntreprise, Compte compte) {
        this.nomEntreprise = nomEntreprise;
        this.compte = compte;
    }
    
    
    
    
    
}
