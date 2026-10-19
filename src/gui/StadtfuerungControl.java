package gui;

import java.io.IOException;

import business.Stadtfuehrung;
import business.StadtfuerungModel;
import javafx.stage.Stage;

public class StadtfuerungControl {
	private StadtfuerungModel sModel;
	private StadtfuerungView sView;

	public StadtfuerungControl(Stage primaryStage) {
		this.sModel = new StadtfuerungModel();
		this.sView = new StadtfuerungView(this.sModel, this, primaryStage);
	}

	public void nehmeStadtfuehrungAuf(Stadtfuehrung s) {
		this.sModel.setStadtfuehrung(s);
		this.sView.zeigeInformationsfensterAn("Die Stadtfuehrung wurde aufgenommen!");
	}

	public void leseAusDatei(String typ) {
		if (!"csv".equals(typ)) {
			this.sView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			return;
		}
		try {
			this.sModel.leseStadtfuehrungAusCsvDatei();
			this.sView.zeigeInformationsfensterAn("Die Stadtfuehrung wurde gelesen!");
		}
		catch (IOException exc) {
			this.sView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		}
		catch (Exception exc) {
			this.sView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}

	public void schreibeStadtfuehrungenInCsvDatei() {
		try {
			this.sModel.schreibeStadtfuehrungenInCsvDatei();
			this.sView.zeigeInformationsfensterAn("Die Stadtfuehrungen wurden gespeichert!");
		}
		catch (IOException exc) {
			this.sView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		}
		catch (Exception exc) {
			this.sView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}
}
