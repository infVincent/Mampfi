class ZELLE
{
    //Deklaration
    int posX;
    int posY;
    boolean istMauer;
    ZELLENSYMBOL symbol;
    KRUEMEL k;

    ZELLE(int xNeu, int yNeu)
    {

        // Initialisierung
        posX = xNeu;
        posY = yNeu;
        istMauer = false;
        symbol = new ZELLENSYMBOL(posX,posY);
        k = new KRUEMEL(posX,posY);
        k.MachtUnverwundbarSetzen(false);

    }

    void KruemelEntfernen(){
        if (k != null)
        {
            k.KruemelSymbolEntfernen();
            k = null;
        }
    }

    void IstMauerSetzen(boolean IstMauerNeu)
    {
        istMauer= IstMauerNeu;
        symbol.FuellungSichtbarSetzen(istMauer);
        KruemelEntfernen();
    }

    boolean IstMauerGeben()
    {
        return istMauer;
    }

    char KruemelBelegungAnzeigen()
    {
        if (k == null) 
            return 'L';
        else
        if (k.MachtUnverwundarGeben() == true)
            return 'P';
        else 
            return 'N';
    }

    void PowerUpSetzen()
    {
        k.MachtUnverwundbarSetzen(true);
    }
}
