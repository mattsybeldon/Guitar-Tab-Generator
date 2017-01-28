package sequencing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import instruments.Guitar;

import sequencing.Node;

public class NoteSequencer {
	
	protected Guitar currentGuitar;
	protected StringBuilder sb; //Used for returning the decision for a block
	
	public NoteSequencer(Guitar current){
		this.currentGuitar = current;
		this.sb = new StringBuilder();
	}
	
	public String[] returnFretSequence(int[][] fretArray){
		
		int[] arraySize = new int[fretArray.length];
		int[] counters = new int[fretArray.length];
		
		int totalCombinations = 1;
		for (int i = 0; i < fretArray.length; i++){
			arraySize[i] = fretArray[i].length;
			totalCombinations *= fretArray[i].length;
		}
		
		int[] currentFrets = new int[fretArray.length];
		int[] currentStrings = new int[fretArray.length];
		
		int[] bestCombination = new int[fretArray.length];
		int[] bestStrings = new int[fretArray.length];
		
		String[] output = new String[fretArray.length];
		
		int maxShift = 100, currentShift;
					
		for (int i = totalCombinations; i > 0; i--){
			
			for (int n = 0; n < fretArray.length; n++){
				currentFrets[n] = fretArray[n][counters[n]];
				currentStrings[n] = counters[n];						
			}
			
			boolean validFlag = true;
			
			for (int n = 0; n < currentFrets.length; n++){
				if (currentFrets[n] == 99){
					validFlag = false;
				}
			}
			
			if (validFlag) {				
				currentShift = 0;
				
				for (int n = 0; n < currentFrets.length - 1; n++){
					if (currentFrets[n] == 0 || currentFrets[n+1] == 0){
						currentShift = 0;
					}
					currentShift = Math.max(currentShift, Math.abs(currentFrets[n+1] - currentFrets[n]));
				}
				
				if (currentShift < maxShift){
					for (int n = 0; n < currentFrets.length; n++){
						bestCombination[n] = currentFrets[n];
						bestStrings[n] = currentStrings[n];
						output[n] = Integer.toString(currentStrings[n]) + "-" + Integer.toString(currentFrets[n]);
					}
					maxShift = currentShift;
				}
			}
			
			for (int j = arraySize.length - 1; j >= 0; j--){
				if (counters[j] + 1 < arraySize[j]){
					++counters[j];
					break;
				}
				counters[j] = 0;
			}
		}
		return output;
		
		
	}
	
	public static void main(String[] args){ //Testing
		int[][] testArray = new int[4][];
		String[] result = new String[4];
		
		String[] tuning = {"E2", "A2", "D3", "G3", "B3", "E4"};
		Guitar testGuitar = new Guitar(tuning);
		
		testArray[0] = testGuitar.returnFretCandidates("E4");
		testArray[1] = testGuitar.returnFretCandidates("F#4");
		testArray[2] = testGuitar.returnFretCandidates("E5");
		testArray[3] = testGuitar.returnFretCandidates("F#5");
		
		NoteSequencer testSequencer = new NoteSequencer(testGuitar);
		
		System.out.println("here we go");
		result = testSequencer.returnFretSequence(testArray);
		
		System.out.println(Arrays.toString(result));
	}
	
	
	//public static string generateTab(int[] fretCandidates){
		//fretCandidates should be an array of arrays
		
		//Generate tree from array. Do BFS on tree to find combinations that don't exceed 5
		//If not possible, do DFS search and return the combination with the smallest maximum jump
	//}
	
	

}
