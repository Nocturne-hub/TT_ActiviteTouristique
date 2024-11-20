package org.activite_touristique;

import java.util.ArrayList;

public class ActiviteSurDemande extends Activite {

    private double prixParticipant;

    public ActiviteSurDemande(String codeActivite, String titre, ArrayList<JoursOuverture> joursOuverture, double prixParticipant) {
        super(codeActivite, titre, joursOuverture);
        this.prixParticipant = prixParticipant;
    }

    @Override
    public double calculDuPrix(JoursOuverture jour, int... nbPersonne) {
        return -1;
    }
}
