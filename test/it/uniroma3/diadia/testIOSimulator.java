package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

class testIOSimulator {

	IOSimulator sim;
	
	@BeforeEach
	void setUp() throws Exception {
		sim = new IOSimulator();
	}

	//test per vedere se la partita automatica funziona
	@Test
	void testSim() {
		
		// Comandi da simulare come input
        String[] comandi = {"prendi pass","vai sud","prendi lanterna","vai est","vai est","vai ovest","vai nord","posa pass","vai nord","vai ovest","fine"};
        String inputSimulato = String.join("\n", comandi) + "\n";
        InputStream input = new ByteArrayInputStream(inputSimulato.getBytes());

        // Salva stdin e stdout originali
        InputStream stdinOriginale = System.in;
        PrintStream stdoutOriginale = System.out;

        // Per catturare l'output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);

        try {
            // Reindirizza System.in e System.out
            System.setIn(input);
            System.setOut(out);

            for (int i = 0; i < comandi.length; i++) {
               sim.leggiRiga();
            }

            // === Fine esecuzione ===

            // Ottieni le righe stampate
            String[] outputRighe = output.toString().split(System.lineSeparator());


        } finally {
            // Ripristina stdin e stdout originali
            System.setIn(stdinOriginale);
            System.setOut(stdoutOriginale);
        }
		
	}

}
