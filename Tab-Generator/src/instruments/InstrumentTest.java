package instruments;

public class InstrumentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tuning = {"E3", "A3", "D4", "G4", "B4", "E5"};
		Guitar testGuitar = null;
		try{
			testGuitar = new Guitar(6, tuning);
		}catch(Exception e){
			System.out.println("Tunings and number of strings not in agreement.");
		}
		
		testGuitar.strings[1].printNotes();
			

	}

}
