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
	
	public Node buildTree(int[][] fretArray){
		
		Node root = this;
		
		numStrings = fretArray.length;
		
		for (int i = 0; i < fretArray.length; i++){
			System.out.println("here");
			Node temp = root;
			for (int j = 0; j < fretArray[i].length; j++){
				
				if (temp.leaves[j] == null){
					Node child = new Node (numStrings, fretArray[i][j]);
					temp.leaves[j] = child;
					temp = child;
				}else{
					temp = temp.leaves[j];
				}
				
			}
		}
		
		return root;
		
	}
	
	
	
	

}
