package com.greatlearningproject2.transactionsBST;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class TransactionsTest {

	//method name: sampleTest
	//arguments: none
	//returns: nothing
	//description: this method is a test with some hardcoded values
	//to check a BST converted to right skewed BST
	public static void sampleTest() {
		NoLeftNodeBST tree=new NoLeftNodeBST();
		tree.insertIntoBST(50);
		tree.insertIntoBST(30);
		tree.insertIntoBST(60);
		tree.insertIntoBST(10);
		tree.insertIntoBST(55);
		
		NoLeftNodeBST modifiedTree=tree.constructRightSkewedTree();
		modifiedTree.printRightSkewedTree();
	}
	
	//method name: simulationTest
	//arguments: none
	//returns: nothing
	//description: here 30 random numbers are generated in the range of 10-100
	//and are inserted to BST, later converted it to right skewed tree and
	//prints to screen
	public static void simulationTest() {
		NoLeftNodeBST tree=new NoLeftNodeBST();
		
		//create a linked has set named treeValues and
		//fill it with 30 random numbers in the range 10-100
		Set<Integer> treeValues=new LinkedHashSet<Integer>();
		Random rnd=new Random();
		for(int i=1;i<=30;i++) {
			treeValues.add(rnd.nextInt(10,100)+1);
		}
		
		
		//iterate through the set and add each element
		//from the set to BST
		Iterator<Integer> it=treeValues.iterator();
		
		while(it.hasNext())
		{
			tree.insertIntoBST(it.next());
		}
		
		//convert the BST into right skewed tree and print it 
		NoLeftNodeBST modifiedTree=tree.constructRightSkewedTree();
		modifiedTree.printRightSkewedTree();
	}
	
	
	public static void main(String[] args) {
		
		//call either of sampleTest or similationTest methods to see the results
		sampleTest();
		
		//uncomment this method call to see simulated result
		//simulationTest();
	}

}
