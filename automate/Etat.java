package automate;

// cette classe permet d'effectuer les opérations les états au besoin 
public class Etat {
    private int Etat;
    private Status Status; 

 public Etat(int etat,Status status)
 {
this.Etat = etat;
this.Status = status;
 }
  public String toString() 
  {
      return (""+this.Etat);
  } 

    public void SetEtat (int etat)
    {
        this.Etat = etat;
    }

    public void SetStatus (Status status)
    {
        this.Status = status;
    }
    

}
