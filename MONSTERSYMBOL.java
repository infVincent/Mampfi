
/**Diese Klasse dient zur Darstellung der Monster und zum Anmelden der Monster-Objekte am backend.
 *
 */
class MONSTERSYMBOL extends MonsterDarstellungImpl
{
	/**Die x-Position.*/
	int positionX;
	/**Die y-Position.*/
	int positionY;
	/**Die Farbe, mit der das Symbol ausgefuellt werden soll.*/
	String fuellFarbe;
	/**Die Farbe, mit der der Rand des Symbols gezeichnet werden soll.*/
	String randFarbe;
	/**Gibt an, ob das Symbol ausgefuellt werden soll.*/
	boolean fuellungSichtbar;
	/**Gibt an, ob der Rand des Symbols gezeichnet werden soll.*/
	boolean randSichtbar;
	/**Gibt die Blickrichtung an*/
	char blickRichtung;
	/**Gibt an ob sich die Darstellung bewegt*/
	boolean fuesseBewegenSich;
	
	MONSTERSYMBOL(int x, int y)
	{
		super(x,y);
		positionX = x;
		positionY = y;
		fuellFarbe = "schwarz";
		fuellungSichtbar = super.fuellungSichtbar;
		randFarbe = "schwarz";
		randSichtbar = super.randSichtbar;
		//blickRichtung = super.blickRichtung;
		bewegtSich = super.bewegtSich;
	}
	
	/**Weist dem Attribut positionX einen neuen Wert zu.
	 * @param xNeu der neue Wert
	 */
	public void PositionXSetzen(int xNeu)
	{
		super.PositionXSetzen(xNeu);
		positionX = xNeu;
	}
	

	/**Weist dem Attribut positionY einen neuen Wert zu.
	 * @param yNeu der neue Wert
	 */
	public void PositionYSetzen(int yNeu)
	{
		super.PositionYSetzen(yNeu);
		positionY = yNeu;
	}
	
	/**Weist dem Attribut fuellFarbe einen neuen Wert zu
	 * @param farbeNeu der neue Wert (Name der Farbe)
	 */
	public void FuellFarbeSetzen(String farbeNeu)
	{
		fuellFarbe = farbeNeu;
		super.FuellFarbeSetzen(farbeNeu);
	}
	
	/** Weist dem Attribut randFarbe einen neuen Wert zu
	 * @param farbeNeu der neue Wert (Name der Farbe)
	 */
	public void RandFarbeSetzen(String farbeNeu)
	{
		randFarbe = farbeNeu;
		super.RandFarbeSetzen(farbeNeu);
	}
	
	/** Weist dem Attribut fuellungSichtbar einen neuen Wert zu
	 * @param sichtbarNeu true f&uumlr sichtbar, false f&uumlr unsichtbar
	 */
	public void FuellungSichtbarSetzen(boolean sichtbarNeu)
	{
		fuellungSichtbar = sichtbarNeu;
		super.FuellungSichtbarSetzen(sichtbarNeu);
	}
	
	/**Weist dem Attribut randSichtbar einen neuen Wert zu
	 * @param sichbarNeu true f&uumlr sichtbar, false f&uumlr unsichtbar
	 */
	public void RandSichtbarSetzen(boolean sichtbarNeu)
	{
		randSichtbar = sichtbarNeu;
		super.RandSichtbarSetzen(sichtbarNeu);
	}
	
	/**Weist dem Attribut blickRichtung einen neuen Wert zu
	 * @param blickrichtungNeu N,S,O,W - f&uumlr Nord, Sued, Ost, West
	 */
	public void BlickRichtungSetzen(char blickrichtungNeu) 
	{
		super.BlickRichtungSetzen(blickrichtungNeu);
		blickRichtung = blickrichtungNeu;
	}
	
	public void FuesseBewegenSichSetzen(boolean bewegtSichNeu)
	{
		super.Bewegen(bewegtSichNeu);
		bewegtSich = bewegtSichNeu;
	}
	
	public void GroesseSetzen(int seitenlaenge)
	{
	    super.GroesseSetzen(seitenlaenge);
	}
	
	public void GroesseSetzen(int breiteNeu, int hoeheNeu)
	{
	    super.GroesseSetzen(breiteNeu, hoeheNeu);
	}
	   
}
