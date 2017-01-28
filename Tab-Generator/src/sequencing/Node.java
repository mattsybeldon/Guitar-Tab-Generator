package sequencing;

public class Node {
	
	protected int fretNumber;
	protected int numStrings;
	protected  Node[] leaves;
	
	public Node(int numStrings, int fretNumber){
		this.fretNumber = fretNumber;
		this.numStrings = numStrings;
		this.leaves = new Node[numStrings];
	}
	
	public void printChildren(){
		for (int i = 0; i < this.leaves.length; i++){
			System.out.println(this.leaves[i].fretNumber);
		}
	}
	
	public Node buildTree(int[][] fretArray){
		
		Node root = this;
		Node temp = root;
		
		numStrings = fretArray[0].length;
		
		for (int i = 0; i < fretArray[0].length; i++){
			temp = root;
			for (int j = 0; j < fretArray.length; j++){
				Node child = new Node(numStrings, fretArray[j][i]);
				temp.leaves[i] = child;
			}
		}
		
		
		return root;
		
	}
	
	
	
	

}
