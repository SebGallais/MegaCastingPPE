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
public class Offre {
    private Long    identifiant;
    private String  libelle;
    private String  reference;
    private Date    dateDebutPublication;
    private Date    dateFinPublication;
    private Date    dateDebutContrat;
    private Date    dateFinContrat;
    private String  descriptionPoste;
    private String  descriptionProfil;
    private int     nbPoste;
    private Client  client;
    private Metier  metier;
    private Contrat contrat;

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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateDebutPublication() {
        return dateDebutPublication;
    }

    public void setDateDebutPublication(Date dateDebutPublication) {
        this.dateDebutPublication = dateDebutPublication;
    }

    public Date getDateFinPublication() {
        return dateFinPublication;
    }

    public void setDateFinPublication(Date dateFinPublication) {
        this.dateFinPublication = dateFinPublication;
    }

    public Date getDateDebutContrat() {
        return dateDebutContrat;
    }

    public void setDateDebutContrat(Date dateDebutContrat) {
        this.dateDebutContrat = dateDebutContrat;
    }

    public Date getDateFinContrat() {
        return dateFinContrat;
    }

    public void setDateFinContrat(Date dateFinContrat) {
        this.dateFinContrat = dateFinContrat;
    }

    public String getDescriptionPoste() {
        return descriptionPoste;
    }

    public void setDescriptionPoste(String descriptionPoste) {
        this.descriptionPoste = descriptionPoste;
    }

    public String getDescriptionProfil() {
        return descriptionProfil;
    }

    public void setDescriptionProfil(String descriptionProfil) {
        this.descriptionProfil = descriptionProfil;
    }

    public int getNbPoste() {
        return nbPoste;
    }

    public void setNbPoste(int nbPoste) {
        this.nbPoste = nbPoste;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Metier getMetier() {
        return metier;
    }

    public void setMetier(Metier metier) {
        this.metier = metier;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public Offre(String libelle, String reference, Date dateDebutPublication, Date dateFinPublication, Date dateDebutContrat, Date dateFinContrat, Client client, Metier metier, Contrat contrat) {
        this.libelle = libelle;
        this.reference = reference;
        this.dateDebutPublication = dateDebutPublication;
        this.dateFinPublication = dateFinPublication;
        this.dateDebutContrat = dateDebutContrat;
        this.dateFinContrat = dateFinContrat;
        this.client = client;
        this.metier = metier;
        this.contrat = contrat;
    }
    
    
    
    
    
    
}



