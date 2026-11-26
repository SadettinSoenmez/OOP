package fileCreatorsSoenmez;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTxtReaderProduct extends ReaderProductSoenmez {

	private BufferedReader ein;
	
	public ConcreteTxtReaderProduct() throws IOException {
		this.ein = new BufferedReader(new FileReader("Stadtfuehrung.txt"));
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		String[] ergebnisZeile = new String[5];
		String zeile = this.ein.readLine();
		int i = 0;
		while (i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = this.ein.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.ein.close();
		
	}

}
