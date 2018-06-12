public class LABYRINTH
{
   //Deklaration
  int breite;
  int hoehe;
  ZELLE [][] spielFlaeche;

    // Konstruktor
    LABYRINTH()
    {
       // Initialisierung
       breite = 10;
       hoehe = 10;
       spielFlaeche = new ZELLE [breite][hoehe];
           
      for (int zaehlerY = 0; zaehlerY < hoehe; zaehlerY = zaehlerY +1)
      {      
          for (int zaehlerX = 0; zaehlerX < breite; zaehlerX = zaehlerX +1)
            spielFlaeche[zaehlerX] [zaehlerY] = new ZELLE( zaehlerX, zaehlerY);
            
      }                     
    }
    void LabyrinthFuellen1()
    {
        spielFlaeche[2][3].IstMauerSetzen(true);
        spielFlaeche[2][4].IstMauerSetzen(true);
        spielFlaeche[2][5].IstMauerSetzen(true);
        spielFlaeche[7][7].PowerUpSetzen();
    }
    
    int BreiteGeben()
    {
        return breite;
    }
    int HoeheGeben()
    {
        return hoehe;
    }
    boolean IstMauerAufZelle( int positionX, int positionY)
    {
        return spielFlaeche[positionX][positionY].IstMauerGeben();
    }
    void KruemelEntfernen( int positionX, int positionY)
    {
        spielFlaeche[positionX][positionY].KruemelEntfernen();
    }
    char KruemelBelegungAnzeigen( int positionX, int positionY)
    {
        return spielFlaeche[positionX][positionY].KruemelBelegungAnzeigen();
    }
}
