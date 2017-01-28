package instruments;
import sequencing.NoteSequencer;

public class InstrumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tuning = {"E2", "A2", "D3", "G3", "B3", "E4"};
		Guitar testGuitar = null;
		try{
			testGuitar = new Guitar(tuning);
		}catch(Exception e){
			System.out.println("Tunings and number of strings not in agreement.");
		}
		
		int[] result = (testGuitar.returnFretCandidates("E3"));
		for (int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}
			

	}

}
