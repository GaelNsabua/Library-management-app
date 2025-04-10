package org.example.data;

import org.example.data.utilisateur.*;

import java.util.Scanner;

public class InterfaceUtlisateur {

    public static void acceuil() {
        Bibliotheque.initialiserBibliotheque();
        System.out.println("\nBienvenue dans library manager");
        System.out.println("==============================");
        System.out.println("1. Se connecter");
        System.out.println("2. S'inscrire");
        System.out.println("0. Quitter");

        System.out.println("\nChoisissez une option : ");
        Scanner read = new Scanner(System.in);

        int choix = read.nextInt();

        switch (choix) {
            case 1:
                new Utilisateur().SeConnecter();
                break;
            case 2:
                new Utilisateur().Sinscrire();
                break;
            case 0:
                acceuil();
            default:
                System.out.println("Choix indisponible !");
                acceuil();
        }
        acceuil();
    }

    public static void menuLecteur(Lecteur lecteur) {
        System.out.println("Bienvenu lecteur " + lecteur.getNom());
        System.out.println("================================");
        System.out.println("1. Consulter la liste des livres");
        System.out.println("2. Rechercher un livre");
        System.out.println("3. Emprunter un livre");
        System.out.println("4. Consulter historique emprunt");
        System.out.println("0. Quitter");

        System.out.println("\nChoisissez une option : ");
        Scanner read = new Scanner(System.in);

        int choix = read.nextInt();

        switch (choix) {
            case 1:
                Bibliotheque.afficherLivres();
                break;
            case 2:
                lecteur.rechercherLivre();
                break;
            case 3:
                lecteur.emprunterLivre();
                break;
            case 4:
                lecteur.consulterHistoriqueEmprunt();
            case 0:
                acceuil();
            default:
                System.out.println("Choix indisponible !");
                acceuil();
        }

        menuLecteur(lecteur);
    }

    public static void menuBibliothecaire(Bibliothecaire bibliothecaire) {
        System.out.println("\nBienvenue bibliothecaire " + bibliothecaire.getNom());
        System.out.println("=======================================");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Moifier un livre");
        System.out.println("3. Supprimer un livre");
        System.out.println("4. Verifier disponibilité d'un livre");
        System.out.println("5. Enregistrer retour livre");
        System.out.println("0. Quitter");

        System.out.println("\nChoisissez une option : ");
        Scanner read = new Scanner(System.in);

        int choix = read.nextInt();

        switch (choix) {
            case 1:
                bibliothecaire.ajouterLivre();
                break;
            case 2:
                bibliothecaire.modifierLivre();
                break;
            case 3:
                bibliothecaire.supprimerLivre();
                break;
            case 4:
                bibliothecaire.verifierDisponibilite();
                break;
            case 5:
                bibliothecaire.enregistrerRetourLivre();
                break;
            case 0:
                acceuil();
            default:
                System.out.println("Choix indisponible");
                acceuil();
        }

        menuBibliothecaire(bibliothecaire);
    }

    public static void menuAdmin(Administrateur administrateur) {
        System.out.println("\nBienvenue administrateur " + administrateur.getNom());
        System.out.println("=======================================");
        System.out.println("1. Ajouter un utilisateur");
        System.out.println("2. Moifier un utilisateur");
        System.out.println("3. Supprimer un utilisateur");
        System.out.println("4. Rechercher utilisateur");
        System.out.println("5. Ajouter un livre");
        System.out.println("6. Moifier un livre");
        System.out.println("7. Supprimer un livre");
        System.out.println("8. Verifier disponibilité d'un livre");
        System.out.println("9. Enregistrer retour livre");
        System.out.println("10. Afficher rapport");
        System.out.println("0. Quitter");

        System.out.println("\nChoisissez une option : ");
        Scanner read = new Scanner(System.in);

        int choix = read.nextInt();

        switch (choix) {
            case 1:
                administrateur.ajouterUtilisateur();
                break;
            case 2:
                administrateur.modifierUtilisateur();
                break;
            case 3:
                administrateur.supprimerUtilisateur();
            case 4:
                administrateur.rechercherLivre();
                break;
            case 5:
                administrateur.ajouterLivre();
                break;
            case 6:
                administrateur.modifierLivre();
                break;
            case 7:
                administrateur.supprimerLivre();
                break;
            case 8:
                administrateur.verifierDisponibilite();
                break;
            case 9:
                administrateur.enregistrerRetourLivre();
                break;
            case 10:
                administrateur.genererRapport();
                break;
            case 0:
                acceuil();
            default:
                System.out.println("Choix indisponible");
                acceuil();
                return;
        }
        menuAdmin(administrateur);
    }
}
