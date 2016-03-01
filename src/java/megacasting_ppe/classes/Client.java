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
public class Client {
    private Long identifiant;
    private String nomEntreprise;
    private String nomResponsable;
    private String prenomResponsable;
    private String civiliteResponsable;
    private String rueEntreprise;
    private int    cpEntreprise;
    private String villeEntreprise;
    private String mailEntreprise;
    private String faxEntreprise;
    private String telephoneEntreprise;

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long Identifiant) {
        this.identifiant = Identifiant;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public String getPrenomResponsable() {
        return prenomResponsable;
    }

    public void setPrenomResponsable(String prenomResponsable) {
        this.prenomResponsable = prenomResponsable;
    }

    public String getCiviliteResponsable() {
        return civiliteResponsable;
    }

    public void setCiviliteResponsable(String civiliteResponsable) {
        this.civiliteResponsable = civiliteResponsable;
    }

    public String getRueEntreprise() {
        return rueEntreprise;
    }

    public void setRueEntreprise(String rueEntreprise) {
        this.rueEntreprise = rueEntreprise;
    }

    public int getCpEntreprise() {
        return cpEntreprise;
    }

    public void setCpEntreprise(int cpEntreprise) {
        this.cpEntreprise = cpEntreprise;
    }

    public String getVilleEntreprise() {
        return villeEntreprise;
    }

    public void setVilleEntreprise(String villeEntreprise) {
        this.villeEntreprise = villeEntreprise;
    }

    public String getMailEntreprise() {
        return mailEntreprise;
    }

    public void setMailEntreprise(String mailEntreprise) {
        this.mailEntreprise = mailEntreprise;
    }

    public String getFaxEntreprise() {
        return faxEntreprise;
    }

    public void setFaxEntreprise(String faxEntreprise) {
        this.faxEntreprise = faxEntreprise;
    }

    public String getTelephoneEntreprise() {
        return telephoneEntreprise;
    }

    public void setTelephoneEntreprise(String telephoneEntreprise) {
        this.telephoneEntreprise = telephoneEntreprise;
    }

    public Client(String nomEntreprise, String nomResponsable, String prenomResponsable, String civiliteResponsable, String rueEntreprise, int cpEntreprise, String villeEntreprise, String mailEntreprise, String telephoneEntreprise) {
        this.nomEntreprise = nomEntreprise;
        this.nomResponsable = nomResponsable;
        this.prenomResponsable = prenomResponsable;
        this.civiliteResponsable = civiliteResponsable;
        this.rueEntreprise = rueEntreprise;
        this.cpEntreprise = cpEntreprise;
        this.villeEntreprise = villeEntreprise;
        this.mailEntreprise = mailEntreprise;
        this.telephoneEntreprise = telephoneEntreprise;
    }

    public Client(String nomEntreprise, String nomResponsable, String prenomResponsable, String civiliteResponsable, String rueEntreprise, int cpEntreprise, String villeEntreprise, String mailEntreprise, String faxEntreprise, String telephoneEntreprise) {
        this.nomEntreprise = nomEntreprise;
        this.nomResponsable = nomResponsable;
        this.prenomResponsable = prenomResponsable;
        this.civiliteResponsable = civiliteResponsable;
        this.rueEntreprise = rueEntreprise;
        this.cpEntreprise = cpEntreprise;
        this.villeEntreprise = villeEntreprise;
        this.mailEntreprise = mailEntreprise;
        this.faxEntreprise = faxEntreprise;
        this.telephoneEntreprise = telephoneEntreprise;
    }

   

 
    
    
    
    
    
    
    
}
