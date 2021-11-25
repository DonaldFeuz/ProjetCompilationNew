package automate;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

//cette classe noous permetras d'effectuer les opération liées aux transition de l'AFN
public class TransitionAFN {
    private HashMap<Etat, HashMap<ArrayList<Etat>, String>> Valeur = new HashMap<Etat, HashMap<ArrayList<Etat>, String>>();
    // private HashMap<Etat, HashMap<String,ArrayList<Etat> >> Valeur = new
    // HashMap<Etat, HashMap<String,ArrayList<Etat> >>();
    // public int GetTransitionkey() {
    // this.Valeur.keySet().;
    // return 0;
    // }

    public AutomateAFN construireTransitionAFNSinple(String Caractere) // permet de construire les transitions pour un
                                                                       // regex a
    // un seul caractère
    {
        Etat EtatInitiale = new Etat(0, Status.INITIALE);
        Etat EtatFinal = new Etat(1, Status.FINAL);
        ArrayList<Etat> EtatFinaux = new ArrayList<>();
        EtatFinaux.add(EtatFinal);

        ArrayList<Etat> Etats = new ArrayList<>();
        Etats.add(EtatInitiale);
        Etats.add(EtatFinal);

        HashMap<Etat, HashMap<ArrayList<Etat>, String>> Valeur = new HashMap<Etat, HashMap<ArrayList<Etat>, String>>() {
            {
                put(EtatInitiale, new HashMap<ArrayList<Etat>, String>() {
                    {
                        put(EtatFinaux, Caractere);
                    }
                });
            }
        };
        this.SetValeur(Valeur); // me permet de mettre à jour la valeur de l'objet transition sur le quel la
                                // methode à été appeller
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
        ArrayList<Etat> EtatsAutomate2 = Automate2.GetEtats();

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
        EtatsSuiventNouvelleTransition3.add(EtatFinal);

        Etat EtatAventNouvelleTransition2;
        Etat EtatAventNouvelleTransition3;
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

        for (TransitionAFN transitionAFN : Automate1.GetTransitions()) {
            ListTansitionAFN.add(transitionAFN);
        }
        ListTansitionAFN.add(TransitionAFN2);
        for (TransitionAFN transitionAFN : Automate2.GetTransitions()) {
            ListTansitionAFN.add(transitionAFN);
        }
        ListTansitionAFN.add(TransitionAFN3);

        for (Etat etat : Automate1.GetEtats()) {
            etat.SetStatus(Status.PASSAGE);

        }

        for (Etat etat : Automate2.GetEtats()) {
            etat.SetStatus(Status.PASSAGE);

        }

        AutomateAFN automateResultat = new AutomateAFN(EtatInitiale, EtatFinaux, Etats, ListTansitionAFN);

        return automateResultat;

    };

    public void SetValeur(HashMap<Etat, HashMap<ArrayList<Etat>, String>> Valeur) {
        this.Valeur = Valeur;
    };

    public HashMap<Etat, HashMap<ArrayList<Etat>, String>> GetValeur() {

        return this.Valeur;
    };

    public String toString() {
        return ("" + this.Valeur);
    }

    public AutomateAFN ConstruireTransitionAFNEtoile(AutomateAFN automateAFN)

    {
        int i = 1;
        Etat EtatInitiale = new Etat(0, Status.INITIALE);
        Etat EtatFinal = new Etat(automateAFN.GetEtats().size() + 1, Status.FINAL);
        ArrayList<Etat> EtatFinaux = new ArrayList<>();
        EtatFinaux.add(EtatFinal);
        ArrayList<Etat> Etats = new ArrayList<>();
        Etats.add(EtatInitiale);

        ArrayList<Etat> EtatsautomateAFN = automateAFN.GetEtats();

        for (Etat etat : EtatsautomateAFN) {

            etat.SetEtat(i);

            Etats.add(etat);

            i++;

        }
        Etats.add(EtatFinal);

        Etat EtatInitialeAutomateAFN = new Etat();
        Etat EtatFinalAutomateAFN = new Etat();

        for (Etat etat : EtatsautomateAFN) {
            if (etat.GetStatus() == Status.INITIALE) {
                EtatInitialeAutomateAFN = etat;
            }
        }

        for (Etat etat : EtatsautomateAFN) {
            if (etat.GetStatus() == Status.FINAL) {
                EtatFinalAutomateAFN = etat;
            }
        }

        ArrayList<Etat> EtatsSuiventNouvelleTransition1 = new ArrayList<>();
        ArrayList<Etat> EtatsSuiventNouvelleTransition2 = new ArrayList<>();

        EtatsSuiventNouvelleTransition1.add(EtatInitialeAutomateAFN);
        EtatsSuiventNouvelleTransition1.add(EtatFinal);
        EtatsSuiventNouvelleTransition2.add(EtatInitialeAutomateAFN);
        EtatsSuiventNouvelleTransition2.add(EtatFinal);

        Etat EtatAventNouvelleTransition2;

        EtatAventNouvelleTransition2 = EtatFinalAutomateAFN;

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

        TransitionAFN TransitionAFN1 = new TransitionAFN();
        TransitionAFN TransitionAFN2 = new TransitionAFN();

        TransitionAFN1.SetValeur(NouvelleValeurTransition1);
        TransitionAFN2.SetValeur(NouvelleValeurTransition2);

        ArrayList<TransitionAFN> ListTansitionAFN = new ArrayList<TransitionAFN>();

        ListTansitionAFN.add(TransitionAFN1);

        for (TransitionAFN transitionAFN : automateAFN.GetTransitions()) {
            ListTansitionAFN.add(transitionAFN);
        }

        ListTansitionAFN.add(TransitionAFN2);

        for (Etat etat : automateAFN.GetEtats()) {
            etat.SetStatus(Status.PASSAGE);

        }

        AutomateAFN automateResultat = new AutomateAFN(EtatInitiale, EtatFinaux, Etats, ListTansitionAFN);

        return automateResultat;
    }

    public static void main(String[] args) {

        System.out.println("ca deja commencer !!");
        AutomateAFN automateafn1;
        AutomateAFN automateafn2;
        AutomateAFN automateafn3;
        AutomateAFN automateafn4;
        AutomateAFN automateafn5;
        AutomateAFN automateafn6;
        AutomateAFN automateafn7;
        TransitionAFN t1 = new TransitionAFN();
        automateafn1 = t1.construireTransitionAFNSinple("r");
        // automateafn2 = t1.construireTransitionAFNSinple("b");
        // automateafn6 = t1.construireTransitionAFNSinple("c");
        // automateafn7 = t1.construireTransitionAFNSinple("d");
        // automateafn3 = t1.ConstruireTransitionAFNAddition(automateafn1,
        // automateafn2);
        // automateafn4 = t1.ConstruireTransitionAFNAddition(automateafn6,
        // automateafn7);
        // automateafn5 = t1.ConstruireTransitionAFNAddition(automateafn3,
        // automateafn4);
        automateafn5 = t1.ConstruireTransitionAFNEtoile(automateafn1);
        System.out.println("----------je comence ici------------");

        System.out.println("----------l'etat initiale est------------");
        System.out.println(automateafn5.GetEtat());

        System.out.println("----------les etats finaux sont------------");
        for (Etat etat : automateafn5.GetEtatFinales()) {
            System.out.println(etat);
        }

        System.out.println("----------la liste des états est ------------");
        for (Etat etat : automateafn5.GetEtats()) {
            System.out.println(etat);
            System.out.println("avec pour status" + etat.GetStatus());

        }
        System.out.println("----------la liste des transitions est  ------------");

        for (TransitionAFN transitionAFN : automateafn5.GetTransitions()) {
            System.out.println(transitionAFN);
        }
        List<TransitionAFN> transitionAFN = automateafn5.GetTransitions();
        List<Etat> listeE = automateafn5.GetEtatTransitions(transitionAFN, 1, "£");
        if (listeE != null) {
            for (Etat etat : listeE) {
                System.out.println(etat);

            }
        } 
        else System.out.println("pas d'etat acessible avec cette etiquette");
            

    }

}
