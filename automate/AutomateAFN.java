package automate;

import java.util.ArrayList;
import java.util.Collection;
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
    }

    public Etat GetEtatinitiale() {
        return EtatInitiale;
    }

    public ArrayList<TransitionAFN> GetTransitions() {
        return TransitionsAFN;
    }

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
    }

    // public void SetEtats() {

    // for (Etat etat : Etats) {
    // etat.SetEtat(numero);
    // }

    // }

}
