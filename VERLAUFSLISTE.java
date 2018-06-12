
class VERLAUFSLISTE
{
    
    String [] name;
    int [] punkte;
    PUNKTELISTEANZEIGE verlaufslisteAnzeize;
    /**
     * Constructor for objects of class VERLAUFSLISTE
     */
    public VERLAUFSLISTE()
    {
        // initialise instance variables
        name = new String[10];
        punkte = new int [10];
        for (int zaehler = 0; zaehler <= 9 ; zaehler= zaehler+1){
            name [zaehler]="---";
            punkte [zaehler]=0;
        }
        verlaufslisteAnzeize= new PUNKTELISTEANZEIGE();
        verlaufslisteAnzeize.Aktualisieren(name, punkte);
        verlaufslisteAnzeize.UeberschriftSetzen("Liste der letzten 10 Spieler");
    }

    /**
     * 
     */
    void neuesErgebnisEintragen(String nameNeu, int punkteNeu)
    {
        for (int i=8; i>=0; i= i-1){
            name[i+1]=name[i];
            punkte[i+1]=punkte[i];
        }
        name[0] = nameNeu;
        punkte[0] = punkteNeu;
        verlaufslisteAnzeize.Aktualisieren(name, punkte);
    }
}
