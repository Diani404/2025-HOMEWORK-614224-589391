package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

class testComandoPosa {

	private ComandoPosa posa;
	private Partita partita;
	private Stanza stanza;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	
	@BeforeEach
	void setUp() throws Exception {
		posa = new ComandoPosa();
		partita= new Partita();
		stanza = new Stanza("N11");
		attrezzo1 = new Attrezzo("Martello",2);
		attrezzo2 = new Attrezzo("Chiave",1);
		
		partita.setStanzaCorrente(stanza);
		stanza.addAttrezzo(attrezzo1);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo2);
		
	}

	//testa se l'attrezzo preso viene posato correttamente nella stanza
	@Test
	void testAttrezzoPresoEPosato() {		
		posa.setParametro("Chiave");
		posa.esegui(partita);
		
		assertTrue(stanza.hasAttrezzo("Chiave"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("Chiave"));
	}
	
	//testa se viene posato un attrezzo che non è stato preso
	@Test 
	void testAttrezzoNonEsistente() {
		posa.setParametro("Pinza");
		posa.esegui(partita);
		
		assertFalse(stanza.hasAttrezzo("Pinza"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("Pinza"));
	}
	
	
}
