package org.example.data.livre;

public class Roman extends Livre {

    private static final long serialVersionUID = 1L;
    private String styleLitteraire;
    private String epoque;

    public Roman(String titre, String auteur, String anneePublication, String ISBN, boolean disponible, String styleLitteraire, String epoque) {
        super(titre, auteur, anneePublication, ISBN, disponible);
        this.styleLitteraire = styleLitteraire;
        this.epoque = epoque;
    }

    public String getStyleLitteraire() {
        return styleLitteraire;
    }

    public void setStyleLitteraire(String styleLitteraire) {
        this.styleLitteraire = styleLitteraire;
    }

    public String getEpoque() {
        return epoque;
    }

    public void setEpoque(String epoque) {
        this.epoque = epoque;
    }
}
