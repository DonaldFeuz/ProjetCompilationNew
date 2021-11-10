package automate;


import java.util.HashMap;
import java.util.ArrayList;

//cette classe noous permetras d'effectuer les opération liées aux transition de l'AFN
public class TransitionAFN {
    private HashMap<Etat, HashMap<ArrayList<Etat>, String>> Valeur = new HashMap<Etat, HashMap<ArrayList<Etat>, String>>();

    public void ConstruireTransitionAFNSinple(String Caractere) // permet de construire les transitions pour un regex a
                                                                // un seul caractère
    {
        Etat EtatInitiale = new Etat(0, Status.INITIALE);
        Etat EtatFinal = new Etat(1, Status.FINAL);
        ArrayList<Etat> EtatFinaux = new ArrayList<>();
        EtatFinaux.add(EtatFinal);

        Valeur = new HashMap<Etat, HashMap<ArrayList<Etat>, String>>() {
            {
                put(EtatInitiale, new HashMap<ArrayList<Etat>, String>() {
                    {
                        put(EtatFinaux, Caractere);
                    }
                });
            }
        };
        SetValeur(Valeur);
    };

    public void SetValeur(HashMap<Etat, HashMap<ArrayList<Etat>, String>> Valeur) {
        this.Valeur = Valeur;
    };

    public HashMap<Etat, HashMap<ArrayList<Etat>, String>> GetValeur() {

        return this.Valeur;
    };

    public static void main(String[] args) {

        System.out.println("ca deja commencer !!");
        TransitionAFN t1 = new TransitionAFN();
        t1.ConstruireTransitionAFNSinple("a");
        System.out.println(t1.Valeur);
    }

}
