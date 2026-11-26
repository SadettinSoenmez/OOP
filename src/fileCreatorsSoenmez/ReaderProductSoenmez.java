package fileCreatorsSoenmez;

import java.io.IOException;

public abstract class ReaderProductSoenmez {
	public abstract String[] leseAusDatei() throws IOException;
	public abstract void schliesseDatei() throws IOException;
}
