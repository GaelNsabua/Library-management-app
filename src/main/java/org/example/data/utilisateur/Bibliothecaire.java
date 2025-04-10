package org.example.data.utilisateur;

import org.example.data.*;
import org.example.data.livre.Livre;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Bibliothecaire extends Utilisateur {

    public Bibliothecaire(){}

    private static final long serialVersionUID = 2L;

    public Bibliothecaire(Utilisateur utilisateur){
        this.nom = utilisateur.nom;
        this.email = utilisateur.email;
        this.password = utilisateur.password;
        this.role = utilisateur.role;
    }

    public static boolean validerEmprunt(Lecteur lecteur, Livre livre) {
        System.out.println("Valider Emprunt");
        System.out.println("===============");
        System.out.println("Valider l'emprunt du livre " + livre.getTitre() + " de " + livre.getAuteur() + " pour le lecteur " + lecteur.nom);
        System.out.println("1. Oui");
        System.out.println("2. Non");

        System.out.println("\nChoisissez une option : ");
        Scanner read = new Scanner(System.in);
        int choix = read.nextInt();

        switch (choix) {
            case 1:
                livre.setDisponible(false);
                Emprunt.enregistrerEmprunt(livre, lecteur);
                return true;
            case 2:
                return false;
            default:
                System.out.println("Choix indisponible");
        }
        return false;
    }

    public void ajouterLivre() {

        Scanner read = new Scanner(System.in);

        System.out.println("Ajouter un nouveau livre");
        System.out.println("========================");
        System.out.print("Titre : ");
        String titre = read.nextLine();
        System.out.print("Auteur : ");
        String auteur = read.nextLine();
        System.out.print("Annee Publication : ");
        String anneePublication = read.nextLine();
        System.out.print("ISBN : ");
        String ISBN = read.nextLine();

        Bibliotheque.ajouterLivre(new Livre(titre, auteur, anneePublication, ISBN, true));

        System.out.println("\nLivre ajoute avec succes");
    }

    public void modifierLivre() {

        boolean success = true;

        System.out.println("\nModifier un livre");
        System.out.println("=================");
        System.out.println("Commencez par rechercher le livre à modifier");

        Livre livre = rechercherLivre();

        //Verifie si le livre a été trouvé
        if (livre != null) {
            System.out.println("Choix diponible pour le livre " + livre.getTitre());
            System.out.println("=============================================");
            System.out.println("1. Modifier le titre");
            System.out.println("2. Modifier l'auteur");
            System.out.println("3. Modifier l'annee de publication");
            System.out.println("4. Modifier l'ISBN");

            System.out.println("\nChoisissez une option : ");
            Scanner read = new Scanner(System.in);
            int choix = read.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Titre : ");
                    String input = read.nextLine();
                    livre.setTitre(input);
                    break;
                case 2:
                    System.out.print("Auteur : ");
                    livre.setAuteur(read.nextLine());
                    break;
                case 3:
                    System.out.print("Annee publication : ");
                    livre.setAnneePublication(read.nextLine());
                    break;
                case 4:
                    System.out.print("ISBN : ");
                    String in = read.nextLine();
                    livre.setISBN(in);
                    break;
                default:
                    System.out.println("Option indisponible !!");
                    success = false;
            }

            if (success) {
                System.out.println("\nLivre modifié avec success");
            }
        }
    }

    public void supprimerLivre() {
        System.out.println("\nSupprimer un livre");
        System.out.println("=================");
        System.out.println("Commencez par rechercher le livre à supprimer");
        Livre livre = rechercherLivre();
        Bibliotheque.supprimerLivre(livre);

        System.out.println("\nLivre supprime avec succes !");
    }

    public void verifierDisponibilite() {
        System.out.println("\nVerifier disponibilité un livre");
        System.out.println("===============================");
        Livre livre = rechercherLivre();

        if (livre != null && livre.isDisponible()) {
            System.out.println("Le livre " + livre.getTitre() + " est disponible");
        } else {
            System.out.println("Le livre " + livre.getTitre() + " est indisponible");
        }
    }

    public void enregistrerRetourLivre() {

        System.out.println("\nEnregistrer retour d'un livre");
        System.out.println("=============================");
        System.out.println("Commencez par rechercher le livre concerne");

        Livre livre = rechercherLivre();

        System.out.println("Valider le retour du livre " + livre.getTitre() + " de " + livre.getAuteur());
        System.out.println("1. Oui");
        System.out.println("2. Non");

        System.out.println("\nChoisissez une option : ");
        Scanner read = new Scanner(System.in);
        int choix = read.nextInt();

        List<Emprunt> emprunts = Bibliotheque.getEmprunts();

        switch (choix) {
            case 1:
                if (livre != null && livre.isDisponible()) {
                    for (Emprunt emprunt : emprunts) {
                        if (Objects.equals(emprunt.getLivre(), livre) && Objects.equals(emprunt.isRetourne(), false)) {
                            emprunt.setRetourne(true);
                            livre.setDisponible(true);
                            System.out.println("\nRetour enregistre avec succes !");
                        } else {
                            System.out.println("\nAucun emprunt relatif a ce livre");
                        }
                    }
                }
            case 2:
                InterfaceUtlisateur.menuBibliothecaire(this);
            default:
                System.out.println("\nChoix indisponible");
        }

    }
}
