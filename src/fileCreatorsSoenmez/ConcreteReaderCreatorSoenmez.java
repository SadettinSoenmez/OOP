package fileCreatorsSoenmez;

import java.io.IOException;

public class ConcreteReaderCreatorSoenmez extends ReaderCreatorSoenmez {

	@Override
	public ReaderProductSoenmez factoryMethod(String typ) throws IOException {
		if ("csv".equals(typ))
			return new ConcreteCsvReaderProductSoenmez();

		return new ConcreteTxtReaderProduct();
	}
	
}
