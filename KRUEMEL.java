
/**
 * Write a description of class KRUEMEL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KRUEMEL
{
    int positionX;
    int positionY;
    boolean machtUnverwundbar;
    KRUEMELSYMBOL kSymbol;
    /**
     * Constructor for objects of class KRUEMEL
     */
    public KRUEMEL(int positionXNeu, int positionYNeu)
    {
        positionX = positionXNeu;
        positionY = positionYNeu;
        machtUnverwundbar = false;
        kSymbol = new KRUEMELSYMBOL(positionX,positionY);

    }

    void KruemelSymbolEntfernen()
    {
        kSymbol.KruemelSymbolEntfernen();
    }

    void MachtUnverwundbarSetzen (boolean machtUnverwunbarNeu)
    {
        machtUnverwundbar = machtUnverwunbarNeu;
        if (machtUnverwundbar==false)
        {
            kSymbol.RadiusSetzen(3);
        }
        else
        {
            kSymbol.RadiusSetzen(6);
        }
            
    }

    boolean MachtUnverwundarGeben()
    {
        return machtUnverwundbar;
    }

}
