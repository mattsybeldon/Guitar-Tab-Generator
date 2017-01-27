package sequencing;
import instruments.Guitar;
import sequencing.Node;

public class NoteSequencer {
	
	protected Guitar currentGuitar;
	protected StringBuilder sb; //Used for returning the decision for a block
	
	public NoteSequencer(Guitar current){
		this.currentGuitar = current;
		this.sb = new StringBuilder();
	}
	
	public static void main(String[] args){
		int[][] testArray = new int[6][];
		for (int i = 0; i < 6; i++){
			testArray[i] = new int[4];
			for (int j = 0; j < 4; j++){
				testArray[i][j] = i*j;
			}
		}
		
		Node tree = new Node(6, 42);
		tree.buildTree(testArray);
	}
	
	
	//public static string generateTab(int[] fretCandidates){
		//fretCandidates should be an array of arrays
		
		//Generate tree from array. Do BFS on tree to find combinations that don't exceed 5
		//If not possible, do DFS search and return the combination with the smallest maximum jump
	//}
	
	

}
