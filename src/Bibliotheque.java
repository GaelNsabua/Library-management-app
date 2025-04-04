import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Bibliotheque {

    private static List<Utilisateur> utilisateurs;
    private static List<Livre> livres;
    private static List<Emprunt> emprunts;

    public static void initialiserBibliotheque() {
        utilisateurs.add(new Utilisateur("Paul", "paul@gmail.com", "1234", "administrateur"));
    }

    public static List<Livre> getLivres() {
        return livres;
    }

    public static List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public static List<Emprunt> getEmprunts() {
        return emprunts;
    }


    public static void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public static void ajouterUtilisateurs(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    public static void ajouterEmprunts(Emprunt emprunt) {
        emprunts.add(emprunt);
    }

    public static void supprimerLivre(Livre livre) {
        livres.remove(livre);
    }

    public static void supprimerUtilisateur(Utilisateur utilisateur) {
        utilisateurs.remove(utilisateur);
    }

    public static void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("Aucun livre disponible");
        } else {
            System.out.println("Liste des livres dans la bibliotheque");
            System.out.println("=====================================");

            for (Livre livre : livres) {
                livre.getDetails();
            }
        }
    }

    public static Utilisateur rechercherUtilisateur() {

        Scanner read = new Scanner(System.in);
        System.out.print("Saisissez l'email  : ");
        String email = read.nextLine();

        for (Utilisateur utilisateur : utilisateurs) {
            if (Objects.equals(utilisateur.getEmail(), email)) {
                utilisateur.getDetails();
                return utilisateur;
            } else {
                System.out.println("Utilisateur inconnu");
            }
        }
        return null;
    }

    public static void afficherUtilisateurs() {
        if (livres.isEmpty()) {
            System.out.println("Aucun utilisateur ajoute");
        } else {
            System.out.println("Liste des utilisateurs dans la bibliotheque");
            System.out.println("=====================================");

            for (Utilisateur utilisateur : utilisateurs) {
                utilisateur.getDetails();
            }
        }
    }

    public static void afficherEmprunts() {
        if (livres.isEmpty()) {
            System.out.println("Aucun emprunt effectue");
        } else {
            System.out.println("Liste d'emprunts dans la bibliotheque");
            System.out.println("=====================================");

            for (Emprunt emprunt : emprunts) {
                emprunt.getDetails();
            }
        }
    }

}
