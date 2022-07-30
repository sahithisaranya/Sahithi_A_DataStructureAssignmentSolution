package com.greatlearningproject2.transactionsBST;

//class to define the node of a binary search tree
class BSTNode{
	
	//member variables are
	//one integer to store data and
	//two objects to BSTNode for left and right children
	int data;
	BSTNode left;
	BSTNode right;
	
	//parameterised constructor with value of node
	BSTNode(int val){
		data=val;//assign val to data
		left=null;//set left child as null
		right=null;//set right child as null
	}
}


//class named NoLeftNodeBST to create a binary search tree with no left child
public class NoLeftNodeBST {
	
	//declare object for root node of the BST 
	BSTNode root;
	
	//Default constructor that sets root node as null
	public NoLeftNodeBST(){
		root=null;
	}
	
	//method name: insertUtil
	//arguments: a BST node and value to insert into the tree
	//returns: node of a BST
	//description: this utility method is used to insert a tree node into the binary search tree
	private BSTNode insertUtil(BSTNode currentNode, int val) {
		//checks if current node is null
		if(currentNode==null) {
			//if so create a new node with the value given as argument
			currentNode=new BSTNode(val);
			//and return that newly created node
			return currentNode;
		}
		
		//check if argument val is less than current node's data
		if(val<currentNode.data) {
			//if so insert the node as left child of the current node
			currentNode.left=insertUtil(currentNode.left,val);
		}
		//otherwise check if argument val is greater than current node's data
		else if(val>currentNode.data) {
			//if so insert the node as right child of the current node
			currentNode.right=insertUtil(currentNode.right,val);
		}
			
		//return the current node
		return currentNode;
		
	}
	
	
	//method name: insertIntoBST
	//arguments: an integer
	//returns: nothing
	//description: calls utility function to insert a value into BST
	public void insertIntoBST(int val) {
		root=insertUtil(root,val);
	}
	
	
	//method name: rightSkewedTreeUtil
	//arguments: a binary tree node and a new BST
	//returns: nothing
	//description: This method converts a BST into right skewed BST by using inorder traversal technique
	private void rightSkewedTreeUtil(BSTNode currentNode,NoLeftNodeBST newTree) {
		
		//check if current node is null if so
		if(currentNode==null)
			return;//return
		
		//traverse to left subtree
		rightSkewedTreeUtil(currentNode.left,newTree);
		
		//insert current node data into the new tree
		newTree.insertIntoBST(currentNode.data);
		
		//traverse to right subtree
		rightSkewedTreeUtil(currentNode.right, newTree);
		
	}
	
	//method name: constructRightSkewedTree
	//arguments: none
	//returns: a newly created right skewed BST
	//description: this method converts a normal BST to right skewed BST	
	public NoLeftNodeBST constructRightSkewedTree() {
		//create a new tree
		NoLeftNodeBST newTree=new NoLeftNodeBST();
		//call the rightSkewedUtil utility function to convert the BST to right skewed tree
		rightSkewedTreeUtil(root, newTree);
		//return the new tree
		return newTree;
	}
	
	//method name: rightSkewTraversalUtil
	//arguments: a node to the BST
	//returns: none
	//description: traverse through the right skewed tree
	private void rightSkewTraversalUtil(BSTNode currentNode) {
		if(currentNode==null)//checks if the current node is null
			return;//if so return nothing
		
		//print the node's value
		System.out.print(currentNode.data+" ");
		//traverse through right side of the tree as there are no left nodes in this tree
		rightSkewTraversalUtil(currentNode.right);
	}
	
	//method name: printRightSkewedTree
	//arguments: none
	//returns: nothing
	//description: calls a utility function to perform right skewed tree traversal
	public void printRightSkewedTree() {
		rightSkewTraversalUtil(root);
		System.out.println();
	}
	
}
