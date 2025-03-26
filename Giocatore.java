package esercizio1;

//TODO fare classe test 

/**
 * Questa classe gestisce i cfu del giocatore durante la partita
 *
 * @author  Diana
 * @see Stanza
 * @version base
 */

public class Giocatore {

	static final private int CFU_INIZIALI = 20;	
	private int cfu;
	
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu=CFU_INIZIALI;
		borsa = new Borsa();
	}
	
	//aggiunge un attrezzo
	public void aggiungiAttrezzo(Attrezzo attrezzo) {
		borsa.addAttrezzo(attrezzo);
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}

}
