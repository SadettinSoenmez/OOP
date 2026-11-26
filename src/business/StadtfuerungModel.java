package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsSoenmez.ConcreteCsvReaderProductSoenmez;
import fileCreatorsSoenmez.ConcreteReaderCreatorSoenmez;
import fileCreatorsSoenmez.ReaderProductSoenmez;

public class StadtfuerungModel {
	private Stadtfuehrung stadtfuehrung;

	public Stadtfuehrung getStadtfuehrung() {
		return stadtfuehrung;
	}

	public void setStadtfuehrung(Stadtfuehrung stadtfuehrung) {
		this.stadtfuehrung = stadtfuehrung;
	}

	public void leseStadtfuehrungAusDatei(String typ) throws IOException {
		ConcreteReaderCreatorSoenmez creator = new ConcreteReaderCreatorSoenmez();
		ReaderProductSoenmez product = creator.factoryMethod(typ);
		String[] zeile = product.leseAusDatei();
		product.schliesseDatei();
		
		this.stadtfuehrung = new Stadtfuehrung(zeile[0],
				Integer.parseInt(zeile[1]),
				zeile[2],
				Float.parseFloat(zeile[3]),
				zeile[4].split("_"));	
	}

	public void schreibeStadtfuehrungenInCsvDatei() throws IOException {
		try (BufferedWriter aus = new BufferedWriter(new FileWriter("StadtfuehrungenAusgabe.csv", true))) {
			aus.write(stadtfuehrung.gibStadtfuehrungZurueck(';'));
		}
	}
}
