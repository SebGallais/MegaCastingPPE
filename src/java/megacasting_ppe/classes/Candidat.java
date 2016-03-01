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
public class Candidat {
    private Long   identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String portable;
    private String rue;
    private int    codePostal;
    private String ville;
    private Date   dateNaissance;
    private String permis;
    private Compte compte;

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String Permis) {
        this.permis = Permis;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Candidat(String nom, String prenom, String email, String telephone, String portable, String rue, int codePostal, String ville, Date dateNaissance, String Permis, Compte compte) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.portable = portable;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.dateNaissance = dateNaissance;
        this.permis = Permis;
        this.compte = compte;
    }
    
    
    
}
