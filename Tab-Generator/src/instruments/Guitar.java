package instruments;

public class Guitar {
	
	int numStrings;
	
	GuitarString[] strings;
	String[] tuning = new String[numStrings];
	
	public Guitar(int numStrings, String[] tuning) {
		
		this.numStrings = numStrings;
		this.tuning = tuning;
		this.strings = new GuitarString[numStrings];
	
		for (int i = 0; i < numStrings; i++){
			this.strings[i] = new GuitarString(tuning[i]);
		}
		
	}
	
	

}
