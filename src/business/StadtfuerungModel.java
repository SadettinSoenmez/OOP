package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StadtfuerungModel {
	private Stadtfuehrung stadtfuehrung;

	public Stadtfuehrung getStadtfuehrung() {
		return stadtfuehrung;
	}

	public void setStadtfuehrung(Stadtfuehrung stadtfuehrung) {
		this.stadtfuehrung = stadtfuehrung;
	}

	public void leseStadtfuehrungAusCsvDatei() throws IOException {
		try (BufferedReader ein = new BufferedReader(new FileReader("Stadtfuehrung.csv"))) {
			String[] zeile = ein.readLine().split(";");
			this.stadtfuehrung = new Stadtfuehrung(zeile[0],
				Integer.parseInt(zeile[1]),
				zeile[2],
				Float.parseFloat(zeile[3]),
				zeile[4].split("_"));
		}
	}

	public void schreibeStadtfuehrungenInCsvDatei() throws IOException {
		try (BufferedWriter aus = new BufferedWriter(new FileWriter("StadtfuehrungenAusgabe.csv", true))) {
			aus.write(stadtfuehrung.gibStadtfuehrungZurueck(';'));
		}
	}
}
