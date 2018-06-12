//import backend.implementierung.SteuerungsAnzeige;
import backend.Ticker;
import backend.anzeige.Einstellungen;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**Diese Klasse dient zur Anzeige der Informationen am rechten Rand und 
 * zur Anmeldung des SPIELSTEUERUNGS-Objekts am backend.
 * @author Sebastian Zinkhahn
 */
class STEUERUNGSANZEIGE extends SteuerungsAnzeige  
{
    /**Der Punktestand*/
    int punkteStand;
    /**Die Anzahl der Leben*/
    int anzahlLeben;
    /**Die Nummer des Levels*/
    int levelNummer;
    /**Die Farbe, in der die Schrift angezeigt wird*/
    String schriftFarbe;
    /**Die Hintergrundfarbe des Panels*/
    String hintergrundFarbe;
    private static OBERFLAECHE oberflaeche = null;
    private static TICKER t = null;
    SPIELSTEUERUNG steuerung;
    /**Zeitintervall in ms*/
    int ZeitIntervall;
    /**Erzeugt eine neues Objekt dieser Klasse*/
    STEUERUNGSANZEIGE()
    {
        super();
        if (oberflaeche==null)
        {
            oberflaeche = new OBERFLAECHE();
        }
        ZeitIntervall= 1000;
    }

    /** Weist dem Attribut punkteStand einen neuen Wert zu
     * @param punkteStandNeu Der neue Wert
     */
    public void PunkteStandSetzen(int punkteStandNeu)
    {
        super.PunkteStandSetzen(punkteStandNeu);
        punkteStand = punkteStandNeu;
    }

    /** Weist dem Attribut anzahlLeben einen neuen Wert zu
     * @param anzahlNeu - Der neue Wert
     */
    public void LebenSetzen(int anzahlNeu)
    {
        if(anzahlNeu>=0)
        {   
            super.LebenSetzen(anzahlNeu);
            anzahlLeben = anzahlNeu;
        }
        else System.err.println("Anzahl der Leben darf nicht negativ sein");
    }

    /** Weist dem Attribut levelNummer einen neuen Wert zu
     * @param nummerNeu Der neue Wert
     */
    public void LevelSetzen(int nummerNeu)
    {
        if(nummerNeu>=0)
        {
            super.LevelSetzen(nummerNeu);
            levelNummer = nummerNeu;
        }
        else System.err.println("Nummer des Levels darf nicht negativ sein");
    }

    /** Weist dem Attribut schriftFarbe einen neuen Wert zu
     * @param farbeNeu Der neue Wert (Name der Farbe)
     */
    public void SchriftFarbeSetzen(String farbeNeu)
    {
        super.SchriftFarbeSetzen(farbeNeu);
        schriftFarbe = farbeNeu;
    }

    /** Weist dem Attribut hintergrundFarbe einen neuen Wert zu
     * @param farbeNeu Der neue Wert (Name der Farbe)
     */
    public void HintergrundFarbeSetzen(String farbeNeu)
    {
        super.HintergrundFarbeSetzen(farbeNeu);
        hintergrundFarbe = farbeNeu;
    }

    /** Meldet das &uuml;bergebene Objekt am Backend als Spielsteurung an
     * @param steuerung Das {@link SPIELSTEUERUNG}-Objekt
     */
    public void Anmelden(SPIELSTEUERUNG steuerungNeu)
    {
        //if(super.steuerungsDummy == null)
        {
            super.Anmelden(steuerungNeu);
            steuerung = steuerungNeu;
        }
        //else System.err.println("Es wurde schon eine Spielsteuerung angemeldet");
    }

    /**Setzt in der Klasse {@link Einstellungen} die Anzahl Zellen
     * @param anzahl Die Anzahl der Zellen
     * @return Der resultierende Zellradius
     */
    int ZellenAnzahlSetzen(int anzahl)
    {
        Einstellungen.ZellenRadiusBerechnen(anzahl);
        return Einstellungen.ZellenRadiusGeben();
    }

    /**Setzt den Zellenradius (halbe Hoehe und Breite einer Zelle)auf den angegebenen Wert
     * @param zellenRadiusNeu Der Zellenradius
     */
    void ZellenRadiusSetzen(int zellenRadiusNeu)
    {
        Einstellungen.ZellenRadiusSetzen(zellenRadiusNeu);
    }

    /**Startet einen {@link Ticker}
     * @param zeitIntervall Der Zeitabstand in welchem die Ticks kommen sollen
     * in Millisekunden
     */
    public void TickerStarten(int zeitIntervall)
    {
        //if(super.steuerungsDummy != null)
        {
            super.TickerStarten(zeitIntervall);
            ZeitIntervall= zeitIntervall;
            if (t== null) 
                t = new TICKER(zeitIntervall); 
            else 
                t.intervall = zeitIntervall;
            t.start();
        }
        //else System.err.println("Es muss erst eine Spielsteuerung angemeldet werden");
    }

    public void TickerAnhalten()
    {
        super.TickerAnhalten();
        if (t!= null) t.intervall = 1000000;

    }

    public void LabyrinthAnzeigeLoeschen()
    {
        super.LabyrinthAnzeigeLoeschen();
    }
    public class TICKER extends Thread{
        int intervall;
        public TICKER(int i){intervall=i; }

        public void run()
        {
            try
            {
                while(true){
                    Thread.sleep(intervall);
                    steuerung.AufTickReagieren();
                }

            }
            catch(Exception e)
            {
            }
        }
    }
    public class OBERFLAECHE extends JFrame implements WindowListener,KeyListener{

        private Image image;
        private LEINWAND leinwand;

        private OBERFLAECHE(String name, int width, int height) {
            super(name);
            setPreferredSize(new Dimension(width, height));
            pack();
            addWindowListener(this);
            setVisible(true);
            leinwand = new LEINWAND(this);

        }

        private OBERFLAECHE() {
            super("Steuerung");
            setPreferredSize(new Dimension(11,11));
            pack();
            addWindowListener(this);
            setVisible(true);
            leinwand = new LEINWAND(this);
            addKeyListener(this);
        }

        public OBERFLAECHE OberflaecheGeben()
        {
            return new OBERFLAECHE();
        }

        public void Warten() {
            while (isVisible()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    setVisible(false);
                }
            }
        }

        public void keyTyped(KeyEvent e) 
        {
        }

        public void keyPressed(KeyEvent e) 
        {
            /* if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
            {
            s.AufTasteReagieren(39);
            } 
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) 
            {
            s.AufTasteReagieren(37);
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP) 
            {
            s.AufTasteReagieren(38);
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) 
            {
            s.AufTasteReagieren(40);
            }
             */           
            steuerung.AufTasteReagieren(e.getKeyCode() );
        }

        public void keyReleased(KeyEvent e) 
        {
            /*   if (e.getKeyCode() == KeyEvent.VK_RIGHT) 
            {
            s.AufTasteReagieren("rechtsLos");
            } 
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) 
            {
            s.AufTasteReagieren("linksLos");
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP) 
            {
            s.AufTasteReagieren("HochLos");
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) 
            {
            s.AufTasteReagieren("RunterLos");
            }
             */
        }

        public void windowActivated(WindowEvent e) {    
            paint(getGraphics());
        }

        public void windowClosed(WindowEvent e) {
        }

        public void windowClosing(WindowEvent e) {
            setVisible(false);
            dispose();
        }

        public void windowDeactivated(WindowEvent e) {
        }

        public void windowDeiconified(WindowEvent e) {
            paint(getGraphics());
        }

        public void windowIconified(WindowEvent e) {
        }

        public void windowOpened(WindowEvent e) {
        }

        public void paint(Graphics graphics) {
            super.paint(graphics);
            graphics.drawImage(image, 0, 0, Color.white, null);
        }

        public void LeinwandAktivieren()
        {
            leinwand.setVisible(false);
            leinwand = new LEINWAND(this);
            leinwand.setVisible(true);

            add(leinwand);
            pack();
        }

        public void LinieZeichnen(int x1, int y1, int x2, int y2, Color farbe)
        {
            leinwand.LinieZeichnen(x1,y1,x2,y2, farbe);
        }

        public void Loeschen()
        {
            leinwand.Loeschen();
        }

        public class LEINWAND extends JPanel

        {

            double hoehe, breite;
            Graphics2D g;
            java.awt.image.BufferedImage img ;

            /**
             * Constructor for objects of class TURTLESYMBOL
             */
            public LEINWAND(OBERFLAECHE cont)
            {
                super();
                hoehe = 1000;
                breite = 1000;

                setSize((int)hoehe, (int)breite);
                setBackground(Color.red);

                int width = 1000, height = 1000;
                img = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage( width, height );
                g = img.createGraphics();
                g.setColor( Color.WHITE );
                g.fillRect(0,0,width, height);

            }

            void LinieZeichnen(int x1neu, int y1neu, int x2neu, int y2neu, Color c)
            {

                g.setColor(c);
                g.drawLine(x1neu, y1neu, x2neu, y2neu);
                repaint();
            }

            public void paint(Graphics g) {

                g.drawImage(img,0,0,this);
            }

            public void Loeschen()
            {
                g.setColor(Color.white);
                g.fillRect(0,0,2000,2000);
                repaint();
            }

        }
    }
}
