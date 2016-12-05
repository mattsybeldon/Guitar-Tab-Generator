package instruments;

public class Guitar {
	
	protected int numStrings;
	
	protected GuitarString[] strings;
	protected String[] tuning = new String[numStrings];
	
	public Guitar(int numStrings, String[] tuning) throws Exception {
		
		if (tuning.length != numStrings){
			throw new Exception();
		}
		
		this.numStrings = numStrings;
		this.tuning = tuning;
		this.strings = new GuitarString[numStrings];
	
		for (int i = 0; i < numStrings; i++){
			this.strings[i] = new GuitarString(tuning[i]);
		}
		
	}
	
	

}
