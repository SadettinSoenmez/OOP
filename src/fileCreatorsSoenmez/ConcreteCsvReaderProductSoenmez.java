package fileCreatorsSoenmez;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteCsvReaderProductSoenmez extends ReaderProductSoenmez{

	private BufferedReader ein;
	
	public ConcreteCsvReaderProductSoenmez() throws IOException {
		this.ein = new BufferedReader(new FileReader("Stadtfuehrung.csv"));
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		return this.ein.readLine().split(";");
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.ein.close();
		
	}


}
