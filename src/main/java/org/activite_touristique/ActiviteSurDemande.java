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
        if(!joursOuverture.contains(jour)){
            System.out.println("Cette activité n'est pas disponible pour le jour demandé. L'activité est ouverte les jours suivant : " + joursOuverture);
            return -1;
        }

        if(nbPersonne[0] > 4){
            System.out.println("Cette activité n'est pas disponible pour plus de 4 personnes");
            return -1;
        }
        return nbPersonne[0] * prixParticipant;
    }
}
