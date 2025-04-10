package org.example.data.livre;

import java.util.List;

public class Categorie {
    private final String nom;
    private final String description;
    private final List<Livre> livres;

    public Categorie(String nom, String description, List<Livre> livres) {
        this.nom = nom;
        this.description = description;
        this.livres = livres;
    }

    public void getLivres() {
        for (Livre livre : livres) {
            livre.getDetails();
        }
    }
}
