package org.example.data.utilisateur;

import org.example.data.Bibliotheque;

import java.util.Scanner;

public class Administrateur extends Bibliothecaire {

    private static final long serialVersionUID = 2L;

    public Administrateur(Utilisateur utilisateur){
        super.nom = utilisateur.nom;
        super.email = utilisateur.email;
        super.password = utilisateur.password;
        super.role = utilisateur.role;
    }

    public void ajouterUtilisateur() {
        Scanner read = new Scanner(System.in);

        System.out.println("\nAjouter un nouvel utilisateur");
        System.out.println("=============================");
        System.out.print("Nom : ");
        String nom = read.nextLine();
        System.out.print("Email : ");
        String email = read.nextLine();
        System.out.print("Mot de passe : ");
        String password = read.nextLine();
        System.out.print("Role : ");
        String role = read.nextLine();

        Bibliotheque.ajouterUtilisateurs(new Utilisateur(nom, email, password, role));

        System.out.println("\nUtilisateur ajoute avec succes !");
    }

    public void modifierUtilisateur() {

        boolean success = true;

        System.out.println("\nModifier un utilisateur");
        System.out.println("=======================");
        System.out.println("Commencez par rechercher l'utilisateur à modifier");

        Utilisateur utilisateur = Bibliotheque.rechercherUtilisateur();

        //Verifie si le livre a été trouvé
        if (utilisateur != null) {
            System.out.println("Choix diponible pour l'utilisateur " + utilisateur.nom);
            System.out.println("=============================================");
            System.out.println("1. Modifier le nom");
            System.out.println("2. Modifier l'email");
            System.out.println("3. Modifier le mot de passe");
            System.out.println("4. Modifier le role");

            System.out.println("\nChoisissez une option : ");
            Scanner read = new Scanner(System.in);
            int choix = read.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Nom : ");
                    utilisateur.nom = read.nextLine();
                    break;
                case 2:
                    System.out.print("Email : ");
                    utilisateur.email = read.nextLine();
                    break;
                case 3:
                    System.out.print("Mot de passe : ");
                    utilisateur.password = read.nextLine();
                    break;
                case 4:
                    System.out.print("Role : ");
                    utilisateur.role = read.nextLine();
                    break;
                default:
                    System.out.println("Option indisponible !!");
                    success = false;
            }

            if (success) {
                System.out.println("Utilisateur modifié avec success");
            }
        }
    }

    public void supprimerUtilisateur() {

        System.out.println("\nSupprimer un utilisateur");
        System.out.println("========================");
        System.out.println("Commencez par rechercher l'utilisateur à supprimer");
        Utilisateur utilisateur = Bibliotheque.rechercherUtilisateur();
        Bibliotheque.supprimerUtilisateur(utilisateur);

        System.out.println("\nUtilisateur supprime avec succes");
    }

    public void verifierUtilisateur() {
        System.out.println("Saisissez l'email de l'utilisateur pour afficher ses informations");
        Bibliotheque.rechercherUtilisateur();
    }

    public void genererRapport() {

        Bibliotheque.afficherLivres();
        System.out.println("======================================");
        Bibliotheque.afficherUtilisateurs();
        System.out.println("=======================================");
        Bibliotheque.afficherEmprunts();
        System.out.println("========================================");
    }
}
