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
	
	public static final int noteOn = 0x90; //Note onset
	public static final int noteOff= 0x80; //Note offset
	public static final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	
	
	private Sequence midiSequence;
	private Track[] allTracks;
	
	int numTracks;
	int[] trackPositions = new int[numTracks];
	
	
	public MidiReader(String filePath){
		try {
			midiSequence = MidiSystem.getSequence(new File(filePath));
		} catch(Exception midiIOError){
			midiIOError.printStackTrace();
			System.out.println("Could not load MIDI file supplied.");
		}
		
		//Extract tracks at initialization
		allTracks = midiSequence.getTracks();
		numTracks = allTracks.length;
	}
	
	//Used to check contents of a track for debugging and testing
	public void enumerateTrack(int trackNumber){
		
		Track currentTrack = allTracks[trackNumber];
		/*MIDI files are composed of events which capture information such as note
		 * onset, offset, and the velocity of the  note. The velocity is not needed
		 * for our purposes, so we will not read it. Go thru all events*/
		for (int i = 0; i < currentTrack.size(); i++){
			
			MidiEvent event = currentTrack.get(i);
			MidiMessage message = event.getMessage();
			
			if (message instanceof ShortMessage){  //This check is failing
				ShortMessage currentShort = (ShortMessage) message;
				
				
				if (currentShort.getCommand() == noteOn){
					
					int key = currentShort.getData1();
					int octave = (key/12) - 1;
					int note = key % 12;
					String noteName = notes[note];
					System.out.println("Note on: " + noteName + octave + "key: " + key);
					
				}else if (currentShort.getCommand() == noteOff){
					
					int key = currentShort.getData1();
					int octave = (key/12) - 1;
					int note = key % 12;
					String noteName = notes[note];
					System.out.println("Note off: " + noteName + octave + "key: " + key);
					
				}
			}
			
		}
		
		
	}
		
	
}
