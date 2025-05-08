package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Comando "Posa", prende un oggetto dalla borsa e lo 
 * posa nella stanza.
 */

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	private IO io;
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo;
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Scegli l'attrezzo che vuoi posare: ");
			io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());  
			nomeAttrezzo = io.leggiRiga();
		}
		if(nomeAttrezzo==null) 
			io.mostraMessaggio("Prima scegli l'attrezzo che vuoi posare.");
		
		else if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			attrezzo = new Attrezzo(nomeAttrezzo,partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo).getPeso());
			
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			io.mostraMessaggio("Hai posato l'attrezzo.");		

		}
		else 
			io.mostraMessaggio("Quell'attrezzo non è nella tua borsa... ");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}

}
