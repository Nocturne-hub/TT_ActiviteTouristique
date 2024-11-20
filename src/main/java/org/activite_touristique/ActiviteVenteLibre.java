package org.activite_touristique;

import java.util.ArrayList;

public class ActiviteVenteLibre extends Activite {

    private double prixAdulte;

    private double prixEnfant;

    public ActiviteVenteLibre(String codeActivite, String titre, ArrayList<JoursOuverture> joursOuverture, double prixAdulte, double prixEnfant) {
        super(codeActivite, titre, joursOuverture);
        this.prixAdulte = prixAdulte;
        this.prixEnfant = prixEnfant;
    }

    @Override
    public double calculDuPrix(JoursOuverture jour, int... nbPersonne) {
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
                prixTotal += prixEnfant / 2;
            }
        }

        return  prixTotal;
    }
}
