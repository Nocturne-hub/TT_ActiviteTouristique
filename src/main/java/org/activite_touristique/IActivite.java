package org.activite_touristique;

public interface IActivite {
    double calculDuPrix(JoursOuverture jourReserve, int... nbPersonne);
}
