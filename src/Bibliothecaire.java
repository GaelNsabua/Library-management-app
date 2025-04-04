import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Bibliothecaire extends Utilisateur{

    public void ajouterLivre(){

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

    }

    public void modifierLivre(){

        boolean success = true;

        System.out.println("Modifier un livre");
        System.out.println("=================");
        System.out.println("Commencez par rechercher le livre à modifier");

        Livre livre = rechercherLivre();

        //Verifie si le livre a été trouvé
        if (livre != null){
            System.out.println("Choix diponible pour le livre " + livre.titre);
            System.out.println("=============================================");
            System.out.println("1. Modifier le titre");
            System.out.println("2. Modifier l'auteur");
            System.out.println("3. Modifier l\'annee de publication");
            System.out.println("4. Modifier l'ISBN");

            System.out.println("\nChoisissez une option : ");
            Scanner read = new Scanner(System.in);
            int choix = read.nextInt();

            switch (choix){
                case 1 :
                    System.out.print("Titre : ");
                    livre.titre = read.nextLine();
                    break;
                case 2 :
                    System.out.print("Auteur : ");
                    livre.auteur = read.nextLine();
                    break;
                case 3:
                    System.out.print("Annee publication : ");
                    livre.anneePublication = read.nextLine();
                    break;
                case 4 :
                    System.out.print("ISBN : ");
                    livre.ISBN = read.nextLine();
                    break;
                default:
                    System.out.println("Option indisponible !!");
                    success = false;
            }

            if (success){
                System.out.println("Livre modifié avec success");
            }
        }
    }

    public void supprimerLivre(){
        System.out.println("Supprimer un livre");
        System.out.println("=================");
        System.out.println("Commencez par rechercher le livre à supprimer");
        Livre livre = rechercherLivre();
        Bibliotheque.supprimerLivre(livre);
    }

    public void verifierDisponibilite(){
        System.out.println("Verifier disponibilité un livre");
        System.out.println("===============================");
        Livre livre = rechercherLivre();

        if (livre != null && livre.disponible){
            System.out.println("Le livre " + livre.titre + " est disponible");
        } else {
            System.out.println("Le livre " + livre.titre + " est indisponible");
        }
    }

    public static boolean validerEmprunt(Lecteur lecteur, Livre livre){
        System.out.println("Valider Emprunt");
        System.out.println("===============");
        System.out.println("Valider l'emprunt du livre " + livre.titre + " de " + livre.auteur + " pour le lecteur " + lecteur.nom);
        System.out.println("1. Oui");
        System.out.println("2. Non");

        System.out.println("\nChoisissez une option : ");
        Scanner read = new Scanner(System.in);
        int choix = read.nextInt();

        switch (choix){
            case 1 :
                livre.disponible = false;
                Emprunt.enregistrerEmprunt(livre, lecteur);
                return true;
            case 2 :
                return false;
            default:
                System.out.println("Choix indisponible");
        }
        return false;
    }

    public void enregistrerRetourLivre(){

        System.out.println("Enregistrer retour d'un livre");
        System.out.println("=============================");
        System.out.println("Commencez par rechercher le livre concerne");

        Livre livre = rechercherLivre();

        System.out.println("Valider le retour du livre " + livre.titre + " de " + livre.auteur);
        System.out.println("1. Oui");
        System.out.println("2. Non");

        System.out.println("\nChoisissez une option : ");
        Scanner read = new Scanner(System.in);
        int choix = read.nextInt();

        List<Emprunt> emprunts = Bibliotheque.getEmprunts();

        switch (choix){
            case 1 :
                if (livre != null && livre.isDisponible()){
                    for (Emprunt emprunt:emprunts){
                        if (Objects.equals(emprunt.getLivre(), livre) && Objects.equals(emprunt.isRetourne(), false)){
                            emprunt.setRetourne(true);
                            livre.disponible = true;
                            System.out.println("Retour enregistre avec succes !");
                        } else {
                            System.out.println("Aucun emprunt relatif a ce livre");
                        }
                    }
                }
            case 2 :
                InterfaceUtlisateur.menuBibliothecaire(this);
            default:
                System.out.println("Choix indisponible");
        }

    }
}
