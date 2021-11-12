package automate;

import java.util.ArrayList;

public class AutomateAFD {

    private Etat EtatInitiale;
    private ArrayList<Etat> EtatFinales;
    private ArrayList<Etat> Etats;
    private ArrayList<TransitionAFN> TransitionsAFD;

    public AutomateAFD(Etat EtatInitiale, ArrayList<Etat> EtatFinales, ArrayList<Etat> Etats,
            ArrayList<TransitionAFN> TransitionsAFD) {
        this.EtatInitiale = EtatInitiale;
        this.EtatFinales = EtatFinales;
        this.Etats = Etats;
        this.TransitionsAFD = TransitionsAFD;

    }

}
