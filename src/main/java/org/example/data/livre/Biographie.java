package org.example.data.livre;

public class Biographie extends Livre {

    private static final long serialVersionUID = 1L;
    private String personaliteConcernee;
    private String periode;

    public Biographie(String titre, String auteur, String anneePublication, String ISBN, boolean disponible, String personaliteConcernee, String periode) {
        super(titre, auteur, anneePublication, ISBN, disponible);
        this.personaliteConcernee = personaliteConcernee;
        this.periode = periode;
    }

    public String getPersonaliteConcernee() {
        return personaliteConcernee;
    }

    public void setPersonaliteConcernee(String personaliteConcernee) {
        this.personaliteConcernee = personaliteConcernee;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }
}
