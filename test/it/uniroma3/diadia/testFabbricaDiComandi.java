package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class testFabbricaDiComandi {
	
	private FabbricaDiComandiFisarmonica fabbrica;
	private ComandoPrendi prendi;
	private ComandoNonValido nullo;

	@BeforeEach
	void setUp() throws Exception {
		fabbrica = new FabbricaDiComandiFisarmonica();
		prendi = new ComandoPrendi();
		nullo= new ComandoNonValido();
		prendi.setParametro("torcia");
	}

	//testa se il comando viene registrato correttamente
	@Test
	void testCostruisciComando() {
		 assertEquals(prendi,fabbrica.costruisciComando("prendi torcia"));
	}
	
	//testa se crea il comando anche se è sbagliato
	@Test
	void testComandoNullo() {
		assertEquals(nullo,fabbrica.costruisciComando(""));
	}

	//testa se crea il comando anche con piu di 2 parole
	@Test
	void testComandoTreParole() {
		 assertEquals(prendi,fabbrica.costruisciComando("prendi torcia sotto"));
	}
}
