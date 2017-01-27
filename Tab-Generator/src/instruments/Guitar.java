package instruments;

public class Guitar {
	
	protected int numStrings;
	
	protected GuitarString[] strings;
	protected String[] tuning = new String[numStrings];
	
	public Guitar(String[] tuning) throws Exception {
		
		this.numStrings = tuning.length;
		this.tuning = tuning;
		this.strings = new GuitarString[numStrings];
	
		for (int i = 0; i < numStrings; i++){
			this.strings[i] = new GuitarString(tuning[i]);
		}
		
	}
	
	

}
