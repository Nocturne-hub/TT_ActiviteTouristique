package org.activite_touristique.src;

public interface IActivite {
    double calculDuPrix(JoursOuverture jourReserve, int... nbPersonne);
}
