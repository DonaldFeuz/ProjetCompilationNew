package automate;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Collection;
>>>>>>> 1d4d2ee68db25259ca9bd613de2f51178062b3e5
import java.util.HashMap;
import java.util.List;

// cette classe nous permetra d'éffectuer les auperations sur les automates
public class AutomateAFN {
    private Etat EtatInitiale;
    private ArrayList<Etat> EtatFinales;
    private ArrayList<Etat> Etats;
    private ArrayList<TransitionAFN> TransitionsAFN;

    public AutomateAFN() {
    }

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
<<<<<<< HEAD
=======
    }

    public Etat GetEtatinitiale() {
        return EtatInitiale;
>>>>>>> 1d4d2ee68db25259ca9bd613de2f51178062b3e5
    }

    public ArrayList<TransitionAFN> GetTransitions() {
        return TransitionsAFN;
    }

<<<<<<< HEAD
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
=======
    public List<Etat> GetEtatTransitions(List<TransitionAFN> listetransition, int etat, String etiquete) {

        List<Etat> listeDesetats = null;
        // List<Etat> listeDesetatsRESULTAT = null;
        for (TransitionAFN item : listetransition) {

            for (Etat etat1 : item.GetValeur().keySet()) {
                if (etat1.GetEtat() == etat) { // a revoir en cas de probleme
                    Collection<HashMap<ArrayList<Etat>, String>> item1 = item.GetValeur().values();
                    // HashMap<ArrayList<Etat>,String> val = item1.iterator();
                    for (HashMap<ArrayList<Etat>, String> item2 : item1) {
                        for (String caract : item2.values()) {
                            if (caract == etiquete) {

                                for (List<Etat> item3 : item2.keySet()) {
                                    listeDesetats = item3;
                                }
                            }
                        }

                    }

                }

            }

        }
        // for (Etat etat2 : listeDesetats) {
        // if(etat)

        // }
        return listeDesetats;
>>>>>>> 1d4d2ee68db25259ca9bd613de2f51178062b3e5
    }

    // public void SetEtats() {

    // for (Etat etat : Etats) {
    // etat.SetEtat(numero);
    // }

    // }

}
