import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Livre> livres = new ArrayList<>();
        livres.add(new Livre("physique", "paul", "2013", "123-ABC",true));
        livres.add(new Livre("histoire", "silva", "2014","123-AER", true));
        livres.add(new Livre("Math", "ben", "2015", "123-AZE", false));

        Categorie categorie1 = new Categorie("Science-Fiction", "Une categorie excellente", livres);
        categorie1.getLivres();


    }

}