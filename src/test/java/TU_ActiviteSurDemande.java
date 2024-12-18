import org.activite_touristique.impl.ActiviteSurDemande;
import org.activite_touristique.src.JoursOuverture;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TU_ActiviteSurDemande {
    // Création d'une activité sur demande
    ArrayList<JoursOuverture> joursOuvertureSurDemande = new ArrayList<>(Arrays.asList(JoursOuverture.VENDREDI, JoursOuverture.SAMEDI, JoursOuverture.DIMANCHE));
    ActiviteSurDemande sautEnParachute = new ActiviteSurDemande("A002", "Activité Sur Demande", joursOuvertureSurDemande, 10);

    @Test
    public void testPrixReservationValid() {
        // Test avec 2 adultes et 2 enfants le samedi (jour ouvert)
        double prix = sautEnParachute.calculDuPrix(JoursOuverture.SAMEDI, 4);
        assertEquals(40.0, prix, 0.0);
    }

    @Test
    public void testPrixAvecLimiteParticipants() {
        // Test avec 3 adultes et 2 enfants (plus de 4 participants) le dimanche (jour ouvert)
        double prix = sautEnParachute.calculDuPrix(JoursOuverture.DIMANCHE, 5);
        assertEquals(-1, prix, 0.0);
    }

    @Test
    public void testPrixAvecZeroParticipant() {
        // Test avec 0 adulte et 0 enfant le samedi (jour ouvert)
        double prix = sautEnParachute.calculDuPrix(JoursOuverture.SAMEDI,0);
        assertEquals(0.0, prix, 0.0);
    }

    @Test
    public void testJourIndisponible() {
        // Test avec 1 adulte et 1 enfant un lundi (jour non ouvert)
        double prix = sautEnParachute.calculDuPrix(JoursOuverture.LUNDI, 2);
        assertEquals(-1, prix, 0.0);
    }

    @Test
    public void testPrixAvecUnParticipant() {
        // Test avec 1 adulte et 0 enfant le dimanche (jour ouvert)
        double prix = sautEnParachute.calculDuPrix(JoursOuverture.DIMANCHE, 1);
        assertEquals(10.0, prix, 0.0);
    }
}
