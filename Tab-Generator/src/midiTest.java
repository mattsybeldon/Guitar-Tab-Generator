import music_readers.MidiReader;

class midiTest {

	public static void main(String[] args) {
		
		String midiPath = "D:\\Documents\\Repos\\Guitar-Tab-Generator\\Tab-Generator\\deb_prel.mid";
		
		MidiReader reader = new MidiReader(midiPath);
		
		reader.enumerateTrack(1);

	}

}
