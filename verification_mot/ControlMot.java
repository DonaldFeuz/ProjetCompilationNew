package verification_mot;

import java.util.List;
import automate.AutomateAFN;
import automate.Etat;
import automate.TransitionAFN;

// Cette classe  vas nous permettre d'effectuer des vérification sur le mot entrer par l'utilisateur
public class ControlMot {
    private String Valeur_mot;

    // cette methode permet de verifier si, pour un mot donné, chaque caractere
    // appartient à l'alphabet.
    public boolean MotAppartenirAlphabet(String Alphabet, String Mot) {
        int cpt = 0;
        for (int i = 0; i < Mot.length(); i++) {
            if (Alphabet.contains(String.valueOf(Mot.charAt(i))) == false) {
                cpt++;
            }

        }

        if (cpt == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean VerifierQueLeMotEstAccepterParAutaumateAFN(AutomateAFN automate, String Mot) 
    {
          List<Etat> listesEtats = automate.GetEtatTransitions(automate.GetTransitions(),automate.GetEtatinitiale().GetEtat(), Mot);
          


        return false;
    }

}
