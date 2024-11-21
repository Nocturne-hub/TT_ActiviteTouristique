package org.activite_touristique.impl;

import org.activite_touristique.src.JoursOuverture;

import java.util.ArrayList;

public class ActiviteVenteLibre extends Activite {

    /** Prix par adulte */
    private double prixAdulte;

    /** Prix par enfant */
    private double prixEnfant;

    public ActiviteVenteLibre(String codeActivite, String titre, ArrayList<JoursOuverture> joursOuverture, double prixAdulte, double prixEnfant) {
        super(codeActivite, titre, joursOuverture);
        this.prixAdulte = prixAdulte;
        this.prixEnfant = prixEnfant;
    }

    /**
     * Méthode pour calculer le prix de la réservation en fonction du jour ainsi que du nombre d'adultes et d'enfants'
     * @param jour - Jour réservé
     * @param nbPersonne - Nombre de participants, nbPersonne[0] représente le nombre d'adultes et nbPersonne[1] représente le nombre d'enfants
     * @return Le prix total de l'activité, -1 s'il y a une erreur dans les paramètres
     */
    @Override
    public double calculDuPrix(JoursOuverture jour, int... nbPersonne) {
        // Vérifie si le jour demandé est dans les jours d'ouverture de l'activité
        if(!joursOuverture.contains(jour)){
            System.out.println("Cette activité n'est pas disponible pour le jour demandé. L'activité est ouverte les jours suivant : " + joursOuverture);
            return -1;
        }

        int nbAdulte = nbPersonne[0];
        int nbEnfant = nbPersonne[1];

        double prixTotal = nbAdulte * prixAdulte;

        for(int i = 0; i < nbEnfant; i++){
            if(i < 2){
                prixTotal += prixEnfant;
            } else {
                // Application du tarif réduit au-delà de 2 enfants
                prixTotal += prixEnfant / 2;
            }
        }

        return  prixTotal;
    }
}
