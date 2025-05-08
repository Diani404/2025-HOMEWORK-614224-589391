package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class testStanzaBloccata {

	StanzaBloccata bloccata;
	Stanza sud;
	Giocatore giocatore;
	Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		bloccata = new StanzaBloccata("Atrio","sud","Chiave");
		giocatore= new Giocatore("Mauro");
		attrezzo= new Attrezzo("Chiave",1);
		sud = new Stanza("N11");
		
		bloccata.impostaStanzaAdiacente("sud",sud);
		
	}

	//testa se la stanza adiacente viene sbloccata correttamente Con
	@Test
	void testConOggetto() {
		giocatore.getBorsa().addAttrezzo(attrezzo);
		assertEquals(sud,bloccata.getStanzaAdiacente("sud"));
	}
	
	//testa che la stanza adiacente non venga sbloccata senza oggetto
	@Test
	void testSenzaOggetto() {
		assertNotEquals(sud,bloccata.getStanzaAdiacente("sud"));
	}
}
