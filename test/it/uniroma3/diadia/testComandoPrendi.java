package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;


class testComandoPrendi {

	private ComandoPrendi prendi;
	private Partita partita;
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		prendi = new ComandoPrendi();
		partita = new Partita();
		stanza = new Stanza("Atrio");
		attrezzo = new Attrezzo("Chiave",1);
		
		partita.setStanzaCorrente(stanza);
		stanza.addAttrezzo(attrezzo);
		
	}

	//testa se l oggetto viene rimosso dall stanza
	@Test 
	void testPrendiAttrezzo() {
		prendi.setParametro("Chiave");
		prendi.esegui(partita);
		
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("Chiave"));
		assertFalse(stanza.hasAttrezzo("Chiave"));
	}
	
	// testa se in una stanza vuota prende l'oggetto
	@Test
	void testStanzaVuota() {
		stanza.removeAttrezzo(attrezzo);
		prendi.setParametro("Chiave");
		
		prendi.esegui(partita);
		
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("Chiave"));
	}
	
	//testa se gli oggetti precedenti rimangono
	@Test
	void testAttrezzoNonEsistente(){
		prendi.setParametro("Giacca");
		prendi.esegui(partita);
		
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("Giacca"));
		
	}

}
