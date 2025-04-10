package org.example.persistance;

import com.google.gson.*;
import org.example.data.Emprunt;
import org.example.data.livre.Livre;
import org.example.data.utilisateur.Utilisateur;
import org.example.interfaces.BibliothequeRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BibliothequeJsonRepository implements BibliothequeRepository {

    private final String fileName;
    private final Gson gson;

    public BibliothequeJsonRepository(String fileName) {
        this.fileName = fileName;

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
    }

    @Override
    public void saveLivre(List<Livre> livres) {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(livres, writer);
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la sauvegarde JSON", e);
        }
    }

    @Override
    public List<Livre> loadLivre() {
        try (Reader reader = new FileReader(fileName)) {
            Livre[] livre = gson.fromJson(reader, Livre[].class);
            return new ArrayList<>(Arrays.asList(livre));
        } catch (FileNotFoundException e) {
            System.out.println("Fichier JSON non trouvé. Retour d'une liste vide.");
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du chargement JSON", e);
        }
    }

    //Persistance Utilisateur
    @Override
    public void saveUtilisateur(List<Utilisateur> utilisateurs) {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(utilisateurs, writer);
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la sauvegarde JSON", e);
        }
    }

    @Override
    public List<Utilisateur> loadUtilisateur() {
        try (Reader reader = new FileReader(fileName)) {
            Utilisateur[] utilisateurs = gson.fromJson(reader, Utilisateur[].class);
            return new ArrayList<>(Arrays.asList(utilisateurs));
        } catch (FileNotFoundException e) {
            System.out.println("Fichier JSON non trouvé. Retour d'une liste vide.");
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du chargement JSON", e);
        }
    }

    @Override
    public void saveEmprunt(List<Emprunt> emprunts) {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(emprunts, writer);
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la sauvegarde JSON", e);
        }
    }

    @Override
    public List<Emprunt> loadEmprunt() {
        try (Reader reader = new FileReader(fileName)) {
            Emprunt[] emprunts = gson.fromJson(reader, Emprunt[].class);
            return new ArrayList<>(Arrays.asList(emprunts));
        } catch (FileNotFoundException e) {
            System.out.println("Fichier JSON non trouvé. Retour d'une liste vide.");
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du chargement JSON", e);
        }
    }
}

