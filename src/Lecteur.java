import java.util.List;
import java.util.Objects;

public class Lecteur extends Utilisateur {

    public Lecteur(Utilisateur utilisateur){
        new Utilisateur(utilisateur.nom, utilisateur.email, utilisateur.password, utilisateur.role);
    }

    public void emprunterLivre() {

        System.out.println("Emprunter un livre");
        System.out.println("=================");
        System.out.println("Commencez par rechercher le livre à emprunter");
        Livre livre = rechercherLivre();

        if (livre != null && livre.disponible) {
            if (Bibliothecaire.validerEmprunt(this, livre)) {
                System.out.println("Emprunt du livre " + livre.titre + " de " + livre.auteur + " autorisé");
            } else {
                System.out.println("Emprunt refusé !!");
            }
        } else {
            System.out.println("Le livre " + livre.titre + " est indisponible");
        }
    }

    public void consulterHistoriqueEmprunt() {
        List<Emprunt> emprunts = Bibliotheque.getEmprunts();
        for (Emprunt emprunt:emprunts){
            if (Objects.equals(emprunt.getLecteur(), this)){
                emprunt.getDetails();
            } else {
                System.out.println("Aucun emprunt relatif a vous");
            }
        }
    }
}
