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
        return -1;
    }
}
