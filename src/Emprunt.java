import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Emprunt {

    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevu;
    private boolean retourne;
    private Livre livre;
    private Lecteur lecteur;

    public Emprunt(Livre livre, Lecteur lecteur) {
        this.livre = livre;
        this.lecteur = lecteur;
        this.dateEmprunt = LocalDate.now();
        this.dateRetourPrevu = dateEmprunt.plusDays(14);
        this.retourne = false;
    }

    public static void enregistrerEmprunt(Livre livre, Lecteur lecteur){
        Bibliotheque.ajouterEmprunts(new Emprunt(livre, lecteur));
    }

    public void getDetails(){
        String status = retourne ? "Retourne" : "En cours";
        System.out.println("Livre : " + this.livre.titre + "\nDate emprunt : " + this.dateEmprunt + "\nDate retour : " + this.dateRetourPrevu + "\nStatus : " + status);
    }

    public Livre getLivre() {
        return livre;
    }

    public LocalDate getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public boolean isRetourne() {
        return retourne;
    }

    public void setRetourne(boolean retourne) {
        this.retourne = retourne;
    }
}
