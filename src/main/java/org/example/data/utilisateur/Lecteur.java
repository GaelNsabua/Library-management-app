package org.example.data.utilisateur;

import org.example.data.Bibliotheque;
import org.example.data.Emprunt;
import org.example.data.livre.Livre;

import java.util.List;
import java.util.Objects;

public class Lecteur extends Utilisateur {

    private static final long serialVersionUID = 2L;

    public Lecteur(Utilisateur utilisateur){
        this.nom = utilisateur.nom;
        this.email = utilisateur.email;
        this.password = utilisateur.password;
        this.role = utilisateur.role;
    }

    public void emprunterLivre() {

        System.out.println("Emprunter un livre");
        System.out.println("=================");
        System.out.println("Commencez par rechercher le livre à emprunter");
        Livre livre = rechercherLivre();

        if (livre != null && livre.isDisponible()) {
            if (Bibliothecaire.validerEmprunt(this, livre)) {
                System.out.println("Emprunt du livre " + livre.getTitre() + " de " + livre.getAuteur() + " autorisé");
            } else {
                System.out.println("Emprunt refusé !!");
            }
        } else {
            System.out.println("Le livre " + livre.getTitre() + " est indisponible");
        }
    }

    public void consulterHistoriqueEmprunt() {
        List<Emprunt> emprunts = Bibliotheque.getEmprunts();
        for (Emprunt emprunt : emprunts) {
            if (Objects.equals(emprunt.getLecteur(), this)) {
                emprunt.getDetails();
            } else {
                System.out.println("Aucun emprunt relatif a vous");
            }
        }
    }
}
