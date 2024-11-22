package org.activite_touristique.impl;

import org.activite_touristique.src.IActivite;
import org.activite_touristique.src.JoursOuverture;

import java.util.ArrayList;

public abstract class Activite implements IActivite {

    /** Code de l'activité, format choisi AXXX */
    protected String codeActivite;

    /** Titre de l'activité */
    protected String titre;

    /** Liste des jours d'ouverture de l'activité */
    protected ArrayList<JoursOuverture> joursOuverture;

    public Activite(String codeActivite, String titre, ArrayList<JoursOuverture> joursOuverture) {
        this.codeActivite = codeActivite;
        this.titre = titre;
        this.joursOuverture = joursOuverture;
    }

    public String getCodeActivite() {
        return codeActivite;
    }

    public String getTitre() {
        return titre;
    }
}
