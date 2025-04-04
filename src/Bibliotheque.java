import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {

    private static List<Utilisateur> utilisateurs;
    private static List<Livre> livres;
    private static  List<Emprunt> emprunts;


    public static List<Livre> getLivres() {
        return livres;
    }

    public static List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public static List<Emprunt> getEmprunts() {
        return emprunts;
    }


    public static void ajouterLivre(Livre livre){
        livres.add(livre);
    }

    public static void ajouterUtilisateurs(Utilisateur utilisateur){
        utilisateurs.add(utilisateur);
    }

    public static void ajouterEmprunts(Emprunt emprunt){
        emprunts.add(emprunt);
    }

    public static void supprimerLivre(Livre livre){
        livres.remove(livre);
    }

    public static void afficherLivres(){
        if (livres.isEmpty()){
            System.out.println("Aucun livre disponible");
        } else {
            System.out.println("Liste des livres dans la bibliotheque");
            System.out.println("=====================================");

            for (Livre livre : livres){
                livre.getDetails();
            }
        }
    }

    public static void afficherUtilisateurs(){
        if (livres.isEmpty()){
            System.out.println("Aucun utilisateur ajoute");
        } else {
            System.out.println("Liste des utilisateurs dans la bibliotheque");
            System.out.println("=====================================");

            for (Utilisateur utilisateur : utilisateurs){
                utilisateur.getDetails();
            }
        }
    }

}
