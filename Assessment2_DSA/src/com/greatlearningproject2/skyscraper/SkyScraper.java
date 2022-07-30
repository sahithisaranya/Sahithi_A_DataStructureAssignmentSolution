package com.greatlearningproject2.skyscraper;

import java.util.*;

public class SkyScraper {
	
	//method name: findIndexUtil
	//arguments: an object to LinkedHashSet and an integer which is element to be searched
	//returns: an integer which is the index of the element found from the set
	//description: traverses through a LinkedHashSet and searches for an element
	//if element is found, the method returns its index; other wise returns -1
	private int findIndexUtil(LinkedHashSet<Integer> floorSet,int element) {
		
		//declare an Integer Iterator object
		Iterator<Integer> it=floorSet.iterator();
		
		//create an integer for element index and set it to -1
		int elIndex=-1;
		
		//traverse through the LinkedHashSet
		while(it.hasNext()) {
			//increment index each time
			elIndex++;
			
			//if element that we are searching for is found break from the loop
			if(it.next().equals(element)) {
				break;
			}
			
		}
		
		//if elIndex is greater or equal to size of hash set, element
		//is not found so return -1
		if(elIndex>=floorSet.size())
			return -1;
		
		//returns elIndex value
		return elIndex;
	}
	
	//method name: buildSkyScraper
	//arguments: a vector of type Integer and an integer for number of floors
	//returns: nothing
	//description: gives size of floors that are to be assembled
	//on ith day of a skyscraper bulding project. The floors are assembled
	//in descending order of their sizes.
	public void buildSkyScraper(Vector<Integer> sizes,int numFloors) {
		
		//create a LinkedHashSet named floorSizes
		LinkedHashSet<Integer> floorSizes=new LinkedHashSet<>();
		//add all the values of floor sizes from vector sizes to LinkedHashSet floorSizes
		floorSizes.addAll(sizes);
		
		//start with day 1
		int dayCount=1;
		
		//repeat the process until number of floors are positive
		while(numFloors>0) {
			
			//get at what day, the current highest floor size is available
			int currentFloorIndex=findIndexUtil(floorSizes,numFloors);
			
			//check if the floor size is available in the list of sizes given
			//if so proceed
			if(currentFloorIndex!=-1) {
				
				//declare a queue called floorQueue to collect
				//all the smaller floors available before
				//the current highest floor
				Queue<Integer> floorQueue=new LinkedList<>();
				
				//adds the current highest floor size to Queue
				floorQueue.add(numFloors);
				
				//now we search the LinkedHashSet for all floor numbers below
				//the current highest floor size available and also below the current day count
				//and adds them to the Queue.
				int nextFloorSize=--numFloors;
				int nextFloorSizeIndex;
				
				do{
					nextFloorSizeIndex=findIndexUtil(floorSizes,nextFloorSize);
					if(nextFloorSizeIndex!=-1 && nextFloorSizeIndex<currentFloorIndex) {
						floorQueue.add(nextFloorSize);
						nextFloorSize--;
					}
					
				}while(nextFloorSizeIndex<currentFloorIndex);
				
				//for all the days where floor can not be assembled print an empty line
				for(int i=dayCount-1;i<currentFloorIndex;i++) {
					
					System.out.println("Day: "+(i+1));
					System.out.println();
				}
				
				//print the day where floors are available to be assembled
				System.out.println("Day: "+(currentFloorIndex+1));
				
				//traverse through the queue, pop each element out
				//and print the available floors to screen
				while(!floorQueue.isEmpty()) {
					System.out.print(floorQueue.poll()+" ");
				}
				
				//update the day count and number of floors to repeat
				dayCount=currentFloorIndex+2;
				System.out.println();
				numFloors=nextFloorSize;
			}
			
		}
	}
}
