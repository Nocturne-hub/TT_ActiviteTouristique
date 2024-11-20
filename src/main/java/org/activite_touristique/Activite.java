package org.activite_touristique;

import java.util.ArrayList;

public abstract class Activite implements IActivite {

    protected String codeActivite;

    protected String titre;

    protected ArrayList<JoursOuverture> joursOuverture;

    public Activite(String codeActivite, String titre, ArrayList<JoursOuverture> joursOuverture) {
        this.codeActivite = codeActivite;
        this.titre = titre;
        this.joursOuverture = joursOuverture;
    }
}
