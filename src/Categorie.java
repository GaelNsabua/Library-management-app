import java.util.List;

public class Categorie {
    private String nom;
    private String description;
    private List<Livre> livres;

    public Categorie(String nom, String description, List<Livre> livres) {
        this.nom = nom;
        this.description = description;
        this.livres = livres;
    }

    public void getLivres(){
        for (Livre livre: livres){
            livre.getDetails();
        }
    }
}
