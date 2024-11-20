import org.activite_touristique.ActiviteVenteLibre;
import org.activite_touristique.JoursOuverture;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TU_ActiviteVenteLibre {
    // Création d'une activité en vente libre
    ArrayList<JoursOuverture> joursOuvertureLibre = new ArrayList<>(Arrays.asList(JoursOuverture.LUNDI, JoursOuverture.MARDI, JoursOuverture.MERCREDI, JoursOuverture.JEUDI, JoursOuverture.VENDREDI));
    ActiviteVenteLibre activiteLibre = new ActiviteVenteLibre("A001", "Activité Libre", joursOuvertureLibre, 20, 10);

    @Test
    public void testPrixReservationSimple() {
        // Test avec 2 adultes et 1 enfant le lundi (jour ouvert)
        double prix = activiteLibre.calculDuPrix(JoursOuverture.LUNDI, 2, 1);
        assertEquals(50, prix);
    }

    @Test
    public void testPrixAvecPlusDeTroisEnfants() {
        // Test avec 2 adultes et 5 enfants le mercredi (jour ouvert)
        double prix = activiteLibre.calculDuPrix(JoursOuverture.MERCREDI, 2, 5);
        assertEquals(80, prix);
    }

    @Test
    public void testPrixAvecZeroEnfant() {
        // Test avec 2 adultes et 0 enfant le jeudi (jour ouvert)
        double prix = activiteLibre.calculDuPrix(JoursOuverture.JEUDI, 2, 0);
        assertEquals(40, prix);
    }

    @Test
    public void testPrixAvecTroisiemeEnfant() {
        // Test avec 2 adultes et 3 enfants le vendredi (jour ouvert)
        double prix = activiteLibre.calculDuPrix(JoursOuverture.VENDREDI, 2, 3);
        assertEquals(65, prix);
    }

    @Test
    public void testJourIndisponible() {
        // Test avec 2 adultes et 2 enfants un dimanche (jour non ouvert)
        double prix = activiteLibre.calculDuPrix(JoursOuverture.DIMANCHE,2, 2);
        assertEquals(-1, prix);
    }
}
