package org.example.interfaces;

import org.example.data.Emprunt;
import org.example.data.livre.Livre;
import org.example.data.utilisateur.Utilisateur;

import java.util.List;

public interface BibliothequeRepository {

    public void saveLivre(List<Livre> livres );
    public List<Livre> loadLivre();

    public void saveUtilisateur(List<Utilisateur> utilisateurs );
    public List<Utilisateur> loadUtilisateur();

    public void saveEmprunt(List<Emprunt> emprunts );
    public List<Emprunt> loadEmprunt();


}
