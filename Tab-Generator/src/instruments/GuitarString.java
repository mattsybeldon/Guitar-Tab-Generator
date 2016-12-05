package instruments;

public class GuitarString {
	
	String baseNote;
	int stringOctave;
	int numFrets = 24;
	String[] notes = new String[numFrets+1];
	
	public GuitarString(String rootNote){
		
		baseNote = rootNote;
		stringOctave = Character.getNumericValue(baseNote.length() - 1);
		
		//Keep track of the next note and octave to add
		char noteLetter = rootNote.charAt(0);
		char noteOctave = rootNote.charAt(rootNote.length() - 1);
		
		boolean sharpFlag = false;
		
		if (rootNote.length() == 3){
			sharpFlag = true;
		}
		
		for (int i = 0; i <= numFrets; i++){
			
			if (sharpFlag == true){
				if (noteLetter == 'E' || noteLetter == 'B'){ //E and B only increment by half step on scale
					noteLetter++;
					sharpFlag = true;
					notes[i] = "" + noteLetter + noteOctave;
					continue;
				}
				notes[i] = "" + noteLetter + "#" + noteOctave;
				sharpFlag = false;
				noteLetter++;
			}else{
				notes[i] = "" + noteLetter + noteOctave;
				sharpFlag = true;
			}
			
			//When octave jumps
			if (noteLetter == 'B' && (sharpFlag == true)){
				noteOctave++;
			}
			
			//Scale goes from A to G letterwise.
			if (noteLetter >= 'H'){
				noteLetter = 'A';
			}
			
		}
		
		
	}
	
	public void printNotes(){
		for (int i = 0; i < numFrets; i++){
			System.out.println(notes[i]);
		}
	}
	
	public int returnFrets(String note){
		int targetFret = 99; //Default case, which means no possible fret
		for (int i = 0; i <= numFrets; i++){
			if (note.equals(notes[i])){
				targetFret = i;
			}
		}
		
		return targetFret;
		
	}
	
/*	int returnFret(String note){
		
		int octave = Character.getNumericValue(note.charAt(note.length() - 1));
		int stringOctave = Character.getNumericValue(baseNote.charAt(baseNote.length() - 1));
		int startNote = Character.getNumericValue(note.charAt(0));
		
		//Check if the note is possible on the string
		
		
		
		
	}*/
	

}
