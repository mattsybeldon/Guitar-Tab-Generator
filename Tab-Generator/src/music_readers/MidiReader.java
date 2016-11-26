package music_readers;

import java.io.File;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MidiReader {
	
	Logger logger = LoggerFactory.getLogger(MidiReader.class);
	
	public static final int note_on = 0x90; //Note onset
	public static final int note_off = 0x80; //Note offset
	public static final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	public String filePath; //Path to the MIDI file
	Sequence sequence = MidiSystem.getSequence(new File(filePath));
	int numTracks;
	int[] trackPositions = new int[numTracks];
	

}
