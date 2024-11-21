package org.activite_touristique;

import org.activite_touristique.impl.Activite;
import org.activite_touristique.impl.ActiviteSurDemande;
import org.activite_touristique.impl.ActiviteVenteLibre;
import org.activite_touristique.src.JoursOuverture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean reservationEnCours = true;
        while (reservationEnCours) {
            // Création des activités
            ArrayList<JoursOuverture> joursOuvertureLibre = new ArrayList<>(Arrays.asList(JoursOuverture.LUNDI, JoursOuverture.MARDI, JoursOuverture.JEUDI, JoursOuverture.VENDREDI));
            ActiviteVenteLibre escaladeEnFamille = new ActiviteVenteLibre("A001", "Activité Libre", joursOuvertureLibre, 20, 10);

            ArrayList<JoursOuverture> joursOuvertureSurDemande = new ArrayList<>(Arrays.asList(JoursOuverture.VENDREDI, JoursOuverture.SAMEDI, JoursOuverture.DIMANCHE));
            ActiviteSurDemande sautEnParachute = new ActiviteSurDemande("A002", "Activité Sur Demande", joursOuvertureSurDemande, 10);

            // Liste des activités
            List<Activite> activites = new ArrayList<>();
            activites.add(escaladeEnFamille);
            activites.add(sautEnParachute);

            // Sélection de l'activité
            System.out.println("Choisissez une activité : ");
            System.out.println("1 - Activité Libre");
            System.out.println("2 - Activité Sur Demande");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            System.out.print("Entrez le jour de la semaine : ");

            String jour = scanner.nextLine().toUpperCase();

            // Demande du jour et des participants
            while (!JoursOuverture.estValide(jour)) {
                System.out.print("Le jour de la semaine n'existe pas, veuillez choisir entre les choix suivants : Lundi, Mardi, Mercredi, Jeudi, Vendredi, Samedi, Dimanche ");
                System.out.print("Entrez le jour de la semaine : ");
                jour = scanner.nextLine().toUpperCase();
            }

            double prix;

            switch (choix) {
                case 1:
                    System.out.print("Nombre d'adultes : ");
                    int adultes = scanner.nextInt();

                    System.out.print("Nombre d'enfants : ");
                    int enfants = scanner.nextInt();
                    scanner.nextLine(); // Consommer la nouvelle ligne

                    // Calcul et affichage du prix
                    prix = escaladeEnFamille.calculDuPrix(JoursOuverture.valueOf(jour), adultes, enfants);
                    if (prix != -1) {
                        System.out.println("Le prix total pour " + adultes + " adultes et " + enfants + " enfants le " + jour + " est de : " + prix + "€");
                    }
                    break;
                case 2:
                    System.out.print("Nombre de participants : ");
                    int participants = scanner.nextInt();
                    scanner.nextLine(); // Consommer la nouvelle ligne

                    // Calcul et affichage du prix
                    prix = sautEnParachute.calculDuPrix(JoursOuverture.valueOf(jour), participants);
                    if (prix != -1) {
                        System.out.println("Le prix total pour " + participants + " particpants le " + jour + " est de : " + prix + "€");
                    }
                    break;
            }

            String continuer;
            do{
                System.out.println("Voulez-vous effectuer une autre réservation ? Oui/Non");
                continuer = scanner.nextLine();
            }while(!continuer.equalsIgnoreCase("non") && !continuer.equalsIgnoreCase("oui"));

            if(!continuer.equalsIgnoreCase("oui")){
                reservationEnCours = false;
            }
        }
        scanner.close();
    }
}