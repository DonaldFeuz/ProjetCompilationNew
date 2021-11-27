package automate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// cette classe nous permetra d'éffectuer les auperations sur les automates
public class AutomateAFN {
    private Etat EtatInitiale;
    private ArrayList<Etat> EtatFinales;
    private ArrayList<Etat> Etats;
    private ArrayList<TransitionAFN> TransitionsAFN;

    public AutomateAFN(Etat EtatInitiale, ArrayList<Etat> EtatFinales, ArrayList<Etat> Etats,
            ArrayList<TransitionAFN> TransitionsAFN) {
        this.EtatInitiale = EtatInitiale;
        this.EtatFinales = EtatFinales;
        this.Etats = Etats;
        this.TransitionsAFN = TransitionsAFN;

    }

    public ArrayList<Etat> GetEtats() {
        return Etats;
    }

    public Etat GetEtat() {
        return EtatInitiale;
    }

    public ArrayList<Etat> GetEtatFinales() {
        return EtatFinales;
    }

    public ArrayList<TransitionAFN> GetTransitions() {
        return TransitionsAFN;
    }

    public ArrayList<Etat> fermeture(Etat Etat,ArrayList<Etat> Etats ) {
            int taille= Etats.size();
        for (TransitionAFN transition :  this.TransitionsAFN) {
            for (Etat etat : transition.GetValeur().keySet()) {
                if (Etat.GetEtat()==etat.GetEtat()) {
                    HashMap<ArrayList<Etat>, String> Valeur=transition.GetValeur().get(etat);
                    for ( ArrayList<Etat> iterable : Valeur.keySet()) {
                        String val;
                        if (( val = Valeur.get(iterable))=="£") {
                           if (!Etats.contains(Etat)) {
                            Etats.add(Etat);
                           }
                           for ( Etat iterable_element : iterable) {
                               if (!Etats.contains(iterable_element)) {
                                Etats.add(iterable_element);
                               }
                           } 
                        }
                    } 
                }
            }
        }
        if ( taille!=Etats.size()) {
            for (Etat etat2 : Etats) {
              fermeture(etat2 , Etats ) ;
            }
        }  
        return Etats;
    }

    // public void SetEtats() {

    // for (Etat etat : Etats) {
    // etat.SetEtat(numero);
    // }

    // }

}
