package org.example.data.livre;

public class Magazine extends Livre {

    private static final long serialVersionUID = 1L;
    private String domaine;
    private String periodicite;

    public Magazine(String titre, String auteur, String anneePublication, String ISBN, boolean disponible, String domaine, String periodicite) {
        super(titre, auteur, anneePublication, ISBN, disponible);
        this.domaine = domaine;
        this.periodicite = periodicite;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }
}
