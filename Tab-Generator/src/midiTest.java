import music_readers.MidiReader;

class midiTest {

	public static void main(String[] args) {
		
		String midiPath = "D:\\Documents\\Repos\\Guitar-Tabee-Generator\\Tab-Generator\\deb_prel.mid";
		
		MidiReader reader = null;
		
		try{
			reader = new MidiReader(midiPath);
		}catch(Exception e){
			System.out.println("Could not find MIDI file.");
		}
		
		reader.enumerateTrack(1);

	}

}
