package org.activite_touristique.impl;

import org.activite_touristique.src.JoursOuverture;

import java.util.ArrayList;

public class ActiviteSurDemande extends Activite {

    /** Prix par participant */
    private double prixParticipant;

    public ActiviteSurDemande(String codeActivite, String titre, ArrayList<JoursOuverture> joursOuverture, double prixParticipant) {
        super(codeActivite, titre, joursOuverture);
        this.prixParticipant = prixParticipant;
    }

    /**
     * Méthode pour calculer le prix de la réservation en fonction du jour et du nombre de participants
     * @param jour - Jour réservé
     * @param nbPersonne - Nombre de participants à l'activité
     * @return Le prix total de l'activité, -1 s'il y a une erreur dans les paramètres
     */
    @Override
    public double calculDuPrix(JoursOuverture jour, int... nbPersonne) {
        // Vérifie si le jour demandé est dans les jours d'ouverture de l'activité
        if (!joursOuverture.contains(jour)) {
            System.out.println("Cette activité n'est pas disponible pour le jour demandé. L'activité est ouverte les jours suivant : " + joursOuverture);
            return -1;
        }

        // Vérification si le nombre de participants dépasse la limite de 4
        if (nbPersonne[0] > 4) {
            System.out.println("Cette activité n'est pas disponible pour plus de 4 personnes");
            return -1;
        }

        return nbPersonne[0] * prixParticipant;
    }
}
