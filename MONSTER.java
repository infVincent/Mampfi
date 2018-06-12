
/**
 * Write a description of class MONSTER here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MONSTER extends SPIELFIGUR
{
    // instance variables - replace the example below with your own
    MONSTERSYMBOL monstersymbol;
    String farbe;
    int intelligenz;
    /**
     * Constructor for objects of class MONSTER
     */
    public MONSTER(LABYRINTH labyrinthNeu, int xStart, int yStart, String farbeNeu)
    {super(labyrinthNeu);
        
        monstersymbol = new MONSTERSYMBOL(xStart, yStart);
        
        positionX = xStart;
        positionY = yStart;
        verwundbar = false;
        farbe = farbeNeu;
        monstersymbol.FuellFarbeSetzen(farbe);
        SymbolAktualisieren();

    }

    void SymbolAktualisieren()
    {
        monstersymbol.PositionYSetzen(positionY);
        monstersymbol.PositionXSetzen(positionX);
        monstersymbol.BlickRichtungSetzen(blickrichtung);
        if (verwundbar == true)
        {
            monstersymbol.FuellFarbeSetzen("gelb");
        }
        else
        {   
            monstersymbol.FuellFarbeSetzen(farbe);
        }
    }


}
