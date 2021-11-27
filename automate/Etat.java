package automate;

// cette classe permet d'effectuer les opérations les états au besoin 
public class Etat {
    private int Etat;
    private Status Status;

    public Etat() {
        Etat = 0;
        Status = Status.PASSAGE;
       
    
    }

    public Etat(int etat, Status status) {
        this.Etat = etat;
        this.Status = status;
    }

    public String toString() {
        return ("" + this.Etat);
    }
    

    public void SetEtat(int etat) {
        this.Etat = etat;
    }

    public int GetEtat() {
        return Etat;
    }

    public Status GetStatus() {
        return Status;
    }

    public void SetStatus(Status status) {
        this.Status = status;
    }

}
