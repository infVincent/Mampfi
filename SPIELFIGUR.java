
class SPIELFIGUR
{
    // instance variables - replace the example below with your own
    int positionX;
    int positionY;
    boolean verwundbar;
    char blickrichtung;

    LABYRINTH labyrinth;

    /**
     * Constructor for objects of class SPIELFIGUR
     */
    SPIELFIGUR(LABYRINTH labyrinthNeu)
    {
        // initialise instance variables
        verwundbar = true;
        blickrichtung = 'N';
        labyrinth=labyrinthNeu;
    }

    void SymbolAktualisieren()
    {

    }

    char BlickrichtungGeben()
    {
        return blickrichtung;
    }

    void NachVorneGehen()
    { 

        switch (blickrichtung) {
            case 'N':   NachNordenGehen();
            break;
            case 'W':   NachWestenGehen();
            break;
            case 'S':   NachSuedenGehen();
            break;
            case 'O':   NachOstenGehen();
            break;

        }

    }

    void NachNordenBlicken()
    { 
        blickrichtung = 'N';
        SymbolAktualisieren();
    }

    void NachSuedenBlicken()
    { 
        blickrichtung = 'S';
        SymbolAktualisieren();
    }

    void NachWestenBlicken()
    { 
        blickrichtung = 'W';
        SymbolAktualisieren();
    }

    void NachOstenBlicken()
    { 
        blickrichtung = 'O';
        SymbolAktualisieren(); 
    }

    void verwundbarSetzen(boolean verwundbarNeu)
    {
        verwundbar= verwundbarNeu;
        SymbolAktualisieren();        
    }

    void rechtsDrehen()
    {

        switch (blickrichtung) {
            case 'N':   NachOstenBlicken();
            break;
            case 'W':   NachNordenBlicken();
            break;
            case 'S':   NachWestenBlicken();
            break;
            case 'O':   NachSuedenBlicken();
            break;

        }
    }

    void linksDrehen()
    {

        switch (blickrichtung) {
            case 'N':   NachWestenBlicken();
            break;
            case 'W':   NachSuedenBlicken();
            break;
            case 'S':   NachOstenBlicken();
            break;
            case 'O':   NachNordenBlicken();
            break;

        }
    }

    void NachOstenGehen()
    {
        NachOstenBlicken();
        if (positionX < labyrinth.BreiteGeben()-1)
        {
            if (labyrinth.IstMauerAufZelle(positionX+1,positionY))
            {}
            else
            {
                positionX=positionX+1;

            }
        } 
        SymbolAktualisieren(); 
    }

    void NachWestenGehen()
    {
        NachWestenBlicken();
        if (positionX >0)
        {
            if (labyrinth.IstMauerAufZelle(positionX-1,positionY))
            {}
            else
            {
                positionX=positionX-1;

            }
        } 
        SymbolAktualisieren(); 
    }

    void NachSuedenGehen()
    {
        NachSuedenBlicken();
        if (positionY < labyrinth.HoeheGeben()-1)
        {
            if (labyrinth.IstMauerAufZelle(positionX,positionY+1))
            {}
            else
            {
                positionY=positionY+1;

            }   
        }
        SymbolAktualisieren(); 
    }

    void NachNordenGehen()
    {
        NachNordenBlicken();
        if (positionY >0)
        {
            if (labyrinth.IstMauerAufZelle(positionX,positionY-1))
            {}
            else
            {
                positionY=positionY-1;

            }
        } 
        SymbolAktualisieren(); 
    }
    int PosXGeben()
    {
        return positionX;
    }
     int PosYGeben()
    {
        return positionY;
    }
}

