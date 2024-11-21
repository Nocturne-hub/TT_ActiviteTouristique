package org.activite_touristique.src;

public enum JoursOuverture {
    LUNDI,
    MARDI,
    MERCREDI,
    JEUDI,
    VENDREDI,
    SAMEDI,
    DIMANCHE;

    /**
     * Vérifie si la chaîne de caractère correspond à un jour
     * @param jour Chaîne donnée par l'utilisateur
     * @return
     */
    public static boolean estValide(String jour) {
        for (JoursOuverture j : JoursOuverture.values()) {
            if (j.name().equals(jour)) {
                return true;
            }
        }
        return false;
    }
}


