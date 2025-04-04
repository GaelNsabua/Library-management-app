import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Utilisateur {

    protected String nom;
    protected String email;
    protected String password;
    protected String role;

    public Utilisateur() {

    }

    public Utilisateur(String nom, String email, String password, String role) {
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void Sinscrire() {
        Scanner read = new Scanner(System.in);

        System.out.print("Saisissez votre nom : ");
        this.nom = read.nextLine();
        System.out.print("Saisissez votre email : ");
        this.email = read.nextLine();
        System.out.print("Saisissez votre mot de passe : ");
        this.password = read.nextLine();
        this.role = "Lecteur";

        //Implementer logique de verification pour se rassurer que l'utilisateur n'existe pas déjà
        Bibliotheque.ajouterUtilisateurs(this);
        System.out.println("Inscription reussie");
    }

    public void SeConnecter() {

        //verification nous aide à arreter la boucle si l'utilisateur est trouvé
        boolean verification = true;

        //Liste qui va contenir la liste de tous les utilisateurs
        List<Utilisateur> utilisateurs = Bibliotheque.getUtilisateurs();

        Scanner read = new Scanner(System.in);
        do {
            System.out.print("Saisissez votre email : ");
            String email = read.nextLine();
            System.out.print("Saisissez votre mot de passe : ");
            String password = read.nextLine();

            for (Utilisateur utilisateur : utilisateurs) {
                if (Objects.equals(utilisateur.getEmail(), email) && Objects.equals(utilisateur.getPassword(), password)) {
                    System.out.println(utilisateur.getNom() + " est connecté");
                    if (Objects.equals(utilisateur.role, "lecteur")) {
                        InterfaceUtlisateur.menuLecteur((Lecteur) utilisateur);
                    } else if (Objects.equals(utilisateur.role, "bibliothecaire")) {
                        InterfaceUtlisateur.menuBibliothecaire((Bibliothecaire) utilisateur);
                    } else if (Objects.equals(utilisateur.role, "administrateur")) {
                        InterfaceUtlisateur.menuAdmin((Administrateur) utilisateur);
                    }
                    verification = false;
                    break;
                } else if (Objects.equals(utilisateur.getEmail(), email) && !Objects.equals(utilisateur.getPassword(), password)) {
                    System.out.println("Mot de passe incorrecte");
                    break;
                } else {
                    System.out.println("Utilisateur inconnu");
                }
            }
        } while (verification);
    }

    public Livre rechercherLivre() {

        List<Livre> livres = Bibliotheque.getLivres();
        Scanner read = new Scanner(System.in);

        System.out.println("Rechercher Livre");
        System.out.println("================");
        System.out.print("Rechercher ....  ");
        String critere = read.nextLine();

        for (Livre livre : livres) {
            if (Objects.equals(livre.titre, critere) || Objects.equals(livre.auteur, critere) || Objects.equals(livre.anneePublication, critere) || Objects.equals(livre.ISBN, critere)) {
                livre.getDetails();
                System.out.println("=========================");
                return livre;
            } else {
                System.out.println("Livre introuvable");
            }
        }
        return null;
    }

    public void getDetails() {
        System.out.println("Nom : " + this.nom + "\nEmail : " + this.email + "\nRole : " + this.role);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
