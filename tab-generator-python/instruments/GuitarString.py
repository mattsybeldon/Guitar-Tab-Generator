class GuitarString:
    #Guitar String Class Definition
    #This class serves as a note generator to model the behavior of a guitar string.
    #Initialize this class by providing a root note like E2, F#2, etc as the open note.
    #Attributes:
    #    1. baseNote - The open note of the string. Stored as str
    #    2. stringOctave - The octave of the string. Stored as int
    #    3. numFrets - The number of frets on the string. Stored as int
    #    4. self.notes - All possible self.notes on the string. Stored as int array.

    def __init__(self, rootNote, *arg):
        if not(isinstance(rootNote, str)):
            raise TypeError("Guitar string root not specified with a string.")
        elif (rootNote == ''):
            raise ValueError("Guitar string root not specified.")
        elif (len(rootNote) < 2 or len(rootNote) > 3):
            raise ValueError("Guitar string root note too long or short.")
        elif (rootNote[0].isdigit() or not( rootNote[-1].isdigit())):
            raise ValueError("Guitar string root note should be in [Note][Octave] format.")
        else:
            self.baseNote = rootNote[0:len(rootNote)]
            self.stringOctave = rootNote[-1]

        self.numFrets = []
        for currentArg in arg:
            print arg
            if (isinstance(currentArg, int)):
                self.numFrets = currentArg
        if (not(isinstance(self.numFrets, int))):
            self.numFrets = 24

        self.notes = []

        self.createStringNotes()
    
    def createStringNotes(guitarString):
        noteLetter = guitarString.baseNote[0]
        noteOctave = guitarString.baseNote[-1]

        # Essentially says whether next step increments the note letter
        sharpFlag = (len(guitarString.baseNote) == 3) #A2 is not sharp. A#2 is

        for i in xrange(0, guitarString.numFrets):
            if (sharpFlag):
                # These letter jumps are only a half step
                if (noteLetter == "E" or noteLetter == "B"):
                    noteLetter =  ''.join(chr(ord(noteLetter) + 1) for letter in noteLetter)
                    sharpFlag = True
                    guitarString.notes.append(noteLetter + noteOctave)
                else:
                    guitarString.notes.append(noteLetter + "#" + noteOctave)
                    sharpFlag = False
                    noteLetter =  ''.join(chr(ord(noteLetter) + 1) for letter in noteLetter)
            else:
                guitarString.notes.append(noteLetter + noteOctave)
                sharpFlag = True

            # Handle octave jump
            if (noteLetter == "B" and sharpFlag):
                noteOctave = str(int(noteOctave) + 1)
            
            # Scale ends at G
            if (ord(noteLetter) >= ord("H")):
                noteLetter = "A"
