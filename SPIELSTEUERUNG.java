import java.util.Random;
/**
 * Write a description of class SPIELSTEUERUNG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SPIELSTEUERUNG
{
    private int punkteStand;
    private int leben;
    private int level;
    private LABYRINTH la;
    private MAMPFI m;
    private MONSTER monster1,monster2;
    private STEUERUNGSANZEIGE anzeige;
    private Random zGenerator;
    private int timer;

    /**
     * Constructor for objects of class SPIELSTEUERUNG
     */
    public SPIELSTEUERUNG()
    {
        timer = 0;
        punkteStand=0;
        leben=3;
        level=1;
        la = new LABYRINTH();
        la.LabyrinthFuellen1();
        m = new MAMPFI (la);
        monster1 =new MONSTER(la, 5,5,"orange");
        monster2 =new MONSTER(la, 8,8,"zufall");
        anzeige = new STEUERUNGSANZEIGE();
        anzeige.Anmelden (this);
        anzeige.TickerStarten(500);
        anzeige.LebenSetzen(leben);
        zGenerator = new Random();
    }

    void AufTickReagieren()
    {
        timer = timer -1;
        //Bewegungen von Mampfi        
        m.NachVorneGehen();
        //Bewegung der Monster:
        int zahl1, zahl2;
        zahl1 = zGenerator.nextInt(7);
        zahl2 = zGenerator.nextInt(7);

        switch (zahl1){
            case 0: monster1.NachNordenGehen();
            break;
            case 1:   monster1.NachWestenGehen();
            break;
            case 2:   monster1.NachSuedenGehen();
            break;
            case 3:   monster1.NachOstenGehen();
            break;
            default: monster1.NachVorneGehen();
        }
        switch (zahl2){
            case 0: monster2.NachNordenGehen();
            break;
            case 1:   monster2.NachWestenGehen();
            break;
            case 2:   monster2.NachSuedenGehen();
            break;
            case 3:   monster2.NachOstenGehen();
            break;
            default: monster2.NachVorneGehen();
        }
        //Monster fressen Mampfi

        
        //Krüemelfressen
        int posX = m.PosXGeben();        
        int posY = m.PosYGeben();
        char Belegung =  la.KruemelBelegungAnzeigen(posX, posY);
        if (Belegung != 'L')
        {
            punkteStand = punkteStand+10;
            anzeige.PunkteStandSetzen(punkteStand);
            if (Belegung == 'P')
            {
                m.verwundbarSetzen(false);
                monster1.verwundbarSetzen(true);
                monster2.verwundbarSetzen(true);
            }
            la.KruemelEntfernen(posX, posY);
        }

    }

    void AufTasteReagieren(int taste)
    {
        switch(taste)
        {
            case 37: 
            m.NachWestenBlicken();
            break;
            case 38: 
            m.NachNordenBlicken();
            break;
            case 39: 
            m.NachOstenBlicken();
            break;
            case 40: 
            m.NachSuedenBlicken();
            break;
        }
    }

}
