package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class testStanzaBuia {

	private StanzaBuia buia;
	private Giocatore giocatore;
	private Attrezzo attrezzo;
	
	private String desc="Qui c'è un buio pesto";
	
	@BeforeEach
	void setUp() throws Exception {
		buia= new StanzaBuia("N8","torcia");
		giocatore = new Giocatore("Mario");
		attrezzo = new Attrezzo("torcia",3);
	}

	
	//testa se la descrizione è giusta se il giocatore ha l'oggetto luminoso
	@Test
	void testOggetto() {
		giocatore.getBorsa().addAttrezzo(attrezzo);
		assertEquals(desc,buia.getDescrizione(giocatore));
	}
	
	//testa che la descrizione sia giusta quando il giocatore non ha l'oggetto luminoso
	@Test
	void testSenzaOggetto() {
		assertNotEquals(desc,buia.getDescrizione(giocatore));
	}
}
