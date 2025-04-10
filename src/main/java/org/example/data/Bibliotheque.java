package org.example.data;

import org.example.data.livre.Livre;
import org.example.data.utilisateur.Utilisateur;
import org.example.persistance.BibliothequeJsonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Bibliotheque {

    private static List<Utilisateur> utilisateurs = getUtilisateurs();
    private static List<Livre> livres = getLivres();
    private static List<Emprunt> emprunts = getEmprunts();

    public static void initialiserBibliotheque() {
        utilisateurs.add(new Utilisateur("Paul", "paul@gmail.com", "1234", "administrateur"));
    }

    public static List<Livre> getLivres() {
        BibliothequeJsonRepository repository = new BibliothequeJsonRepository("livres.json");
        livres = repository.loadLivre();
        return livres;
    }

    public static List<Utilisateur> getUtilisateurs() {
        BibliothequeJsonRepository repository = new BibliothequeJsonRepository("utilisateurs.json");
        utilisateurs = repository.loadUtilisateur();
        return utilisateurs;
    }

    public static List<Emprunt> getEmprunts() {
        BibliothequeJsonRepository repository = new BibliothequeJsonRepository("emprunts.json");
        emprunts = repository.loadEmprunt();
        return emprunts;
    }


    public static void ajouterLivre(Livre livre) {

        BibliothequeJsonRepository repository = new BibliothequeJsonRepository("livres.json");
        livres.add(livre);
        repository.saveLivre(livres);
    }

    public static void ajouterUtilisateurs(Utilisateur utilisateur) {

        BibliothequeJsonRepository repository = new BibliothequeJsonRepository("utilisateurs.json");
        utilisateurs.add(utilisateur);
        repository.saveUtilisateur(utilisateurs);
    }

    public static void ajouterEmprunts(Emprunt emprunt) {
        BibliothequeJsonRepository repository = new BibliothequeJsonRepository("emprunts.json");
        emprunts.add(emprunt);
        repository.saveEmprunt(emprunts);
    }

    public static void supprimerLivre(Livre livre) {
        livres.remove(livre);
    }

    public static void supprimerUtilisateur(Utilisateur utilisateur) {
        utilisateurs.remove(utilisateur);
    }


    public static Utilisateur rechercherUtilisateur() {

        Scanner read = new Scanner(System.in);
        System.out.print("\nSaisissez l'email  : ");
        String email = read.nextLine();

        for (Utilisateur utilisateur : utilisateurs) {
            if (Objects.equals(utilisateur.getEmail(), email)) {
                utilisateur.getDetails();
                return utilisateur;
            } else {
                System.out.println("\nUtilisateur inconnu");
            }
        }
        return null;
    }

    public static boolean isUtilisateurExist(String email){
        for (Utilisateur utilisateur : utilisateurs) {
            if (Objects.equals(utilisateur.getEmail(), email)) {
                return true;
            }
        }
        return false;
    }

    public static void afficherUtilisateurs() {
        if (utilisateurs.isEmpty()) {
            System.out.println("\nAucun utilisateur ajoute");
        } else {
            System.out.println("\nListe des utilisateurs dans la bibliotheque");
            System.out.println("=====================================");

            for (Utilisateur utilisateur : utilisateurs) {
                utilisateur.getDetails();
                System.out.println("-------------------------------------");
            }
        }
    }

    public static void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("\nAucun livre disponible");
        } else {
            System.out.println("\nListe des livres dans la bibliotheque");
            System.out.println("=====================================");

            for (Livre livre : livres) {
                livre.getDetails();
                System.out.println("-------------------------------------");
            }
        }
    }

    public static void afficherEmprunts() {
        if (emprunts.isEmpty()) {
            System.out.println("\nAucun emprunt effectue");
        } else {
            System.out.println("\nListe d'emprunts dans la bibliotheque");
            System.out.println("=====================================");

            for (Emprunt emprunt : emprunts) {
                emprunt.getDetails();
                System.out.println("-------------------------------------");
            }
        }
    }

}
