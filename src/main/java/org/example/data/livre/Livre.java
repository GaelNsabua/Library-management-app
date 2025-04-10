package org.example.data.livre;

import java.io.Serializable;

public class Livre implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String titre;
    protected String auteur;
    protected String anneePublication;
    protected String ISBN;
    protected boolean disponible;

    public Livre() {

    }

    public Livre(String titre, String auteur, String anneePublication, String ISBN, boolean disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.ISBN = ISBN;
        this.disponible = disponible;
    }

    public void getDetails() {
        String disponibilite = this.disponible ? "Oui" : "Non";
        System.out.println("Titre : " + this.titre + "\nAuteur : " + this.auteur + "\nAnnee Publication : " + this.anneePublication + "\nISBN : " + this.ISBN + "\nDisponible : " + disponibilite);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(String anneePublication) {
        this.anneePublication = anneePublication;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
