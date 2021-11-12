package automate;

import java.util.HashMap;
import java.util.ArrayList;

//cette classe noous permetras d'effectuer les opération liées aux transition de l'AFN
public class TransitionAFN {
    private HashMap<Etat, HashMap<ArrayList<Etat>, String>> Valeur = new HashMap<Etat, HashMap<ArrayList<Etat>, String>>();

    public AutomateAFN construireTransitionAFNSinple(String Caractere) // permet de construire les transitions pour un
                                                                       // regex a
    // un seul caractère
    {
        Etat EtatInitiale = new Etat(0, Status.INITIALE);
        Etat EtatFinal = new Etat(1, Status.FINAL);
        ArrayList<Etat> EtatFinaux = new ArrayList<>();
        EtatFinaux.add(EtatFinal);

        ArrayList<Etat> Etats = new ArrayList<>();
        EtatFinaux.add(EtatInitiale);
        EtatFinaux.add(EtatFinal);

        HashMap<Etat, HashMap<ArrayList<Etat>, String>> Valeur = new HashMap<Etat, HashMap<ArrayList<Etat>, String>>() {
            {
                put(EtatInitiale, new HashMap<ArrayList<Etat>, String>() {
                    {
                        put(EtatFinaux, Caractere);
                    }
                });
            }
        };
        TransitionAFN TransitionAFN = new TransitionAFN();
        TransitionAFN.SetValeur(Valeur);

        ArrayList<TransitionAFN> ListTansitionAFN = new ArrayList<TransitionAFN>();

        ListTansitionAFN.add(TransitionAFN);
        AutomateAFN AutomateAFN = new AutomateAFN(EtatInitiale, EtatFinaux, Etats, ListTansitionAFN);

        return AutomateAFN;
    };

    public AutomateAFN ConstruireTransitionAFNAddition(AutomateAFN Automate1, AutomateAFN Automate2) {
        int i, j, k, l, m, n;
        k = 1;
        l = Automate1.GetEtats().size() + 1;
        m = 1;
        n = 1;
        Etat EtatInitiale = new Etat(0, Status.INITIALE);
        Etat EtatFinal = new Etat(Automate1.GetEtats().size() + Automate2.GetEtats().size() + 1, Status.FINAL);
        ArrayList<Etat> EtatFinaux = new ArrayList<>();
        EtatFinaux.add(EtatFinal);
        ArrayList<Etat> Etats = new ArrayList<>();
        Etats.add(EtatInitiale);

        ArrayList<Etat> EtatsAutomate1 = Automate1.GetEtats();
        ArrayList<Etat> EtatsAutomate2 = Automate1.GetEtats();

        for (Etat etat : EtatsAutomate1) {
            for (i = k; i <= Automate1.GetEtats().size(); i++) {

                etat.SetEtat(i);
                Etats.add(etat);
                i = Automate1.GetEtats().size();
            }
            k++;
        }
        ;

        for (Etat etat : EtatsAutomate2) {
            m = n;
            for (j = l; m <= Automate2.GetEtats().size(); m++) {

                etat.SetEtat(j);
                Etats.add(etat);
                m = Automate2.GetEtats().size();

            }
            l++;
            n++;

        }
        ;

        Etats.add(EtatFinal);

        /// pour demain je doit retourner l'automate qui en découle et pour cela je doit
        /// construire les transitions du nouveaux automate
        Etat EtatInitialeAutomate1 = new Etat();
        Etat EtatInitialeAutomate2 = new Etat();
        Etat EtatFinaleAutomate1 = new Etat();
        Etat EtatFinaleAutomate2 = new Etat();

        for (Etat etat : EtatsAutomate1) {
            if (etat.GetStatus() == Status.INITIALE) {
                EtatInitialeAutomate1 = etat;
            }
        }

        for (Etat etat : EtatsAutomate2) {
            if (etat.GetStatus() == Status.INITIALE) {
                EtatInitialeAutomate2 = etat;
            }
        }

        for (Etat etat : EtatsAutomate1) {
            if (etat.GetStatus() == Status.FINAL) {
                EtatFinaleAutomate1 = etat;
            }
        }

        for (Etat etat : EtatsAutomate2) {
            if (etat.GetStatus() == Status.FINAL) {
                EtatFinaleAutomate2 = etat;
            }
        }

        ArrayList<Etat> EtatsSuiventNouvelleTransition1 = new ArrayList<>();
        EtatsSuiventNouvelleTransition1.add(EtatInitialeAutomate1);
        EtatsSuiventNouvelleTransition1.add(EtatInitialeAutomate2);

        ArrayList<Etat> EtatsSuiventNouvelleTransition2 = new ArrayList<>();
        EtatsSuiventNouvelleTransition2.add(EtatFinal);

        ArrayList<Etat> EtatsSuiventNouvelleTransition3 = new ArrayList<>();
        EtatsSuiventNouvelleTransition2.add(EtatFinal);

        Etat  EtatAventNouvelleTransition2 ;
        Etat EtatAventNouvelleTransition3 ;
        EtatAventNouvelleTransition2 = EtatFinaleAutomate1;
        EtatAventNouvelleTransition3 = EtatFinaleAutomate2;

       

        HashMap<Etat, HashMap<ArrayList<Etat>, String>> NouvelleValeurTransition1 = new HashMap<Etat, HashMap<ArrayList<Etat>, String>>() {
            {
                put(EtatInitiale, new HashMap<ArrayList<Etat>, String>() {
                    {
                        put(EtatsSuiventNouvelleTransition1, "£");
                    }
                });
            }
        };
        

        HashMap<Etat, HashMap<ArrayList<Etat>, String>> NouvelleValeurTransition2 = new HashMap<Etat, HashMap<ArrayList<Etat>, String>>() {
            {
                put(EtatAventNouvelleTransition2, new HashMap<ArrayList<Etat>, String>() {
                    {
                        put(EtatsSuiventNouvelleTransition2, "£");
                    }
                });
            }
        };

        HashMap<Etat, HashMap<ArrayList<Etat>, String>> NouvelleValeurTransition3 = new HashMap<Etat, HashMap<ArrayList<Etat>, String>>() {
            {
                put(EtatAventNouvelleTransition3, new HashMap<ArrayList<Etat>, String>() {
                    {
                        put(EtatsSuiventNouvelleTransition3, "£");
                    }
                });
            }
        };

        TransitionAFN TransitionAFN1 = new TransitionAFN();
        TransitionAFN TransitionAFN2 = new TransitionAFN();
        TransitionAFN TransitionAFN3 = new TransitionAFN();

       
        TransitionAFN1.SetValeur(NouvelleValeurTransition1);
        TransitionAFN2.SetValeur(NouvelleValeurTransition2);
        TransitionAFN3.SetValeur(NouvelleValeurTransition3);

        ArrayList<TransitionAFN> ListTansitionAFN = new ArrayList<TransitionAFN>();

        ListTansitionAFN.add(TransitionAFN1);

        for (TransitionAFN transitionAFN : Automate1.GetTransition()) {
        ListTansitionAFN.add(transitionAFN);
        }
        ListTansitionAFN.add(TransitionAFN2);
        for (TransitionAFN transitionAFN : Automate2.GetTransition()) {
        ListTansitionAFN.add(transitionAFN);
        }
        ListTansitionAFN.add(TransitionAFN3);

        for (Etat etat : Automate1.GetEtats()) {
        etat.SetStatus(Status.PASSAGE);

        }

        for (Etat etat : Automate2.GetEtats()) {
        etat.SetStatus(Status.PASSAGE);

        }

        AutomateAFN automateResultat = new AutomateAFN(EtatInitiale, EtatFinaux,
        Etats, ListTansitionAFN);

        return automateResultat;

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
        t1.construireTransitionAFNSinple("a");
        System.out.println(t1.Valeur);
    }

}
