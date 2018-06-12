
class MAMPFI extends SPIELFIGUR
{
    // instance variables - replace the example below with your own
    
    MAMPFISYMBOL symbol;
    

    /**
     * Constructor for objects of class MAMPFI
     */
    MAMPFI(LABYRINTH labyrinthNeu)
    {
        // initialise instance variables
        super(labyrinthNeu);

        symbol = new MAMPFISYMBOL();
        symbol.RadiusSetzen(25);
        symbol.BogenArtSetzen(2);
        symbol.StartWinkelSetzen(120);
        symbol.BogenWinkelSetzen(300);
        symbol.MundBewegtSichSetzen(true);

    }

    void SymbolAktualisieren()
    {
        symbol.PositionYSetzen(positionY);
        symbol.PositionXSetzen(positionX);
        switch(blickrichtung){
            case 'N':   symbol.StartWinkelSetzen(120);
            break;
            case 'W':   symbol.StartWinkelSetzen(210);
            break;
            case 'S':   symbol.StartWinkelSetzen(300);
            break;
            case 'O':   symbol.StartWinkelSetzen(30);
            break;
        }
        if (verwundbar == true)
        {
            symbol.FuellFarbeSetzen("gelb");
        }
        else
        {   
            symbol.FuellFarbeSetzen("rot");
        }
    }


}
