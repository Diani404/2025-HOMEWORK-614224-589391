package it.uniroma3.diadia.ambienti;


//stanza che ha una direzione bloccata che puo essere sbloccata solo da un determinato oggetto

public class StanzaBloccata extends Stanza {
	
	private String direzioneBloccata;
	private String oggettoSbloccante;
	
	public StanzaBloccata(String nome, String dir, String unlock) {
		super(nome);
		direzioneBloccata = dir;
		oggettoSbloccante = unlock;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!this.hasAttrezzo(this.oggettoSbloccante) && direzione.equals(this.direzioneBloccata)) {
			System.out.println("La direzione è bloccata! Serve: " + this.oggettoSbloccante); 
			return this;
		}
		else {
			return super.getStanzaAdiacente(direzione);
		}
			
	}
}
