package com.greatlearningproject2.skyscraper;

import java.util.Vector;
import java.util.Scanner;

public class ScyScraperTest {

	public static void main(String[] args) {
		//declare an integer to store number of floors in the building
		int numOfFloors;
		
		//declare a Vector to store the floor sizes given on ith day
		Vector<Integer> floorSizes=new Vector<Integer>();
		
		//asks the user to enter total number of floors and reads the value
		//accepts only a positive value >0 for the number of floors
		//if not then user needs to correct his input and re-enter
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("Enter the total number of floors in the building: ");
			numOfFloors=sc.nextInt();
			if(numOfFloors<=0)
				System.out.println("Number of floors should be a positive integer greater than 0");
		}while(numOfFloors<=0);
		
			
		//loop through number of floors and asks the user to enter the floor size
		//given on ith day, then reads that value
		//checks if floor size is with in the range of 1 to total number of floors value
		//if so accepts it and stores in the vector
		//otherwise asks the user to re-enter the correct value
		for(int i=0;i<numOfFloors;i++) {
			int fsize;
			do {
				System.out.println("Enter the floor size given on day: "+(i+1));
				fsize=sc.nextInt();
				if(fsize<=0 || fsize>numOfFloors)
					System.out.println("Floor size should be in the range of 1-"+numOfFloors);
			}while(fsize<=0 || fsize>numOfFloors);
			floorSizes.add(fsize);
		}
		
		System.out.println();
		System.out.println("The order of construction is as follows");
		System.out.println();
		//create an object to SkyScraper class and call method buildSkyScraper to see
		//how the assembly is to be done.
		SkyScraper scraper=new SkyScraper();
		scraper.buildSkyScraper(floorSizes, numOfFloors);
		sc.close();
	}

}
