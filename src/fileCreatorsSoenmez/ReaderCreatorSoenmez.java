package fileCreatorsSoenmez;

import java.io.IOException;

public abstract class ReaderCreatorSoenmez {
	public abstract ReaderProductSoenmez factoryMethod(String typ) throws IOException;
}
