package automate;

import java.util.ArrayList;

// cette classe nous permetra d'éffectuer les auperations sur les automates
public class AutomateAFN {
    private Etat EtatInitiale;
    private ArrayList<Etat> EtatFinales;
    private ArrayList<Etat> Etats;
    private ArrayList<TransitionAFN> TransitionsAFN;
  
    public AutomateAFN(){}
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
        return EtatFinales ;
    }

    public ArrayList<TransitionAFN> GetTransitions() {
        return  TransitionsAFN;
    }

 

    // public void SetEtats() {

    // for (Etat etat : Etats) {
    // etat.SetEtat(numero);
    // }

    // }

}
