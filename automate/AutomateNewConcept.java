package automate;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class AutomateNewConcept {
    private HashMap<Etat, HashMap<String,ArrayList<Etat>>> Valeur = new HashMap<Etat, HashMap<String,ArrayList<Etat>>>(); 
    public  void Construireautomate(char c){
        Etat EtatInitiale = new Etat(0, Status.INITIALE);
        Etat EtatFinal = new Etat(1, Status.FINAL);
        ArrayList<Etat> list= new ArrayList<Etat>();
        list.add(EtatFinal);
        HashMap<String,ArrayList<Etat>> Map = new HashMap<String,ArrayList<Etat>>();
        Map.put(Character.toString(c),list);
        Valeur.put( EtatInitiale,Map);
        return;
    }

  
 }

  
