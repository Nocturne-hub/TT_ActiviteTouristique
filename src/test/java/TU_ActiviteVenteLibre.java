import org.activite_touristique.impl.ActiviteVenteLibre;
import org.activite_touristique.src.JoursOuverture;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TU_ActiviteVenteLibre {
    // Création d'une activité en vente libre
    ArrayList<JoursOuverture> joursOuvertureLibre = new ArrayList<>(Arrays.asList(JoursOuverture.LUNDI, JoursOuverture.MARDI, JoursOuverture.MERCREDI, JoursOuverture.JEUDI, JoursOuverture.VENDREDI));
    ActiviteVenteLibre escaladeEnFamille = new ActiviteVenteLibre("A001", "Activité Libre", joursOuvertureLibre, 20, 10);

    @Test
    public void testPrixReservationSimple() {
        // Test avec 2 adultes et 1 enfant le lundi (jour ouvert)
        double prix = escaladeEnFamille.calculDuPrix(JoursOuverture.LUNDI, 2, 1);
        assertEquals(50.0, prix, 0.0);
    }

    @Test
    public void testPrixAvecPlusDeTroisEnfants() {
        // Test avec 2 adultes et 5 enfants le mercredi (jour ouvert)
        double prix = escaladeEnFamille.calculDuPrix(JoursOuverture.MERCREDI, 2, 5);
        assertEquals(75.0, prix, 0.0);
    }

    @Test
    public void testPrixAvecZeroEnfant() {
        // Test avec 2 adultes et 0 enfant le jeudi (jour ouvert)
        double prix = escaladeEnFamille.calculDuPrix(JoursOuverture.JEUDI, 2, 0);
        assertEquals(40.0, prix, 0.0);
    }

    @Test
    public void testPrixAvecTroisiemeEnfant() {
        // Test avec 2 adultes et 3 enfants le vendredi (jour ouvert)
        double prix = escaladeEnFamille.calculDuPrix(JoursOuverture.VENDREDI, 2, 3);
        assertEquals(65.0, prix, 0.0);
    }

    @Test
    public void testJourIndisponible() {
        // Test avec 2 adultes et 2 enfants un dimanche (jour non ouvert)
        double prix = escaladeEnFamille.calculDuPrix(JoursOuverture.DIMANCHE,2, 2);
        assertEquals(-1, prix, 0.0);
    }
}
