package org.example.data;

import org.example.data.livre.Livre;
import org.example.data.utilisateur.Lecteur;

import java.io.Serializable;
import java.time.LocalDate;

public class Emprunt implements Serializable {

    private static final long serialVersionUID = 3L;
    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevu;
    private boolean retourne;
    private final Livre livre;
    private final Lecteur lecteur;

    public Emprunt(Livre livre, Lecteur lecteur) {
        this.livre = livre;
        this.lecteur = lecteur;
        this.dateEmprunt = LocalDate.now();
        this.dateRetourPrevu = dateEmprunt.plusDays(14);
        this.retourne = false;
    }

    public static void enregistrerEmprunt(Livre livre, Lecteur lecteur) {
        Bibliotheque.ajouterEmprunts(new Emprunt(livre, lecteur));
    }

    public void getDetails() {
        String status = retourne ? "Retourne" : "En cours";
        System.out.println("Livre : " + this.livre.getTitre() + "\nDate emprunt : " + this.dateEmprunt + "\nDate retour : " + this.dateRetourPrevu + "\nStatus : " + status);
    }

    public Livre getLivre() {
        return livre;
    }

    public LocalDate getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public boolean isRetourne() {
        return retourne;
    }

    public void setRetourne(boolean retourne) {
        this.retourne = retourne;
    }
}
