package day01;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.util.ArrayList; 
public class SonarSweep {
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> depths = importFile("numbers.txt");
		
		System.out.println(depthChanges(depths)); 
		
		System.out.println(sumChanges(depths)); 
		
		
	}
	
	
	public static ArrayList<Integer> importFile(String fileName){
		
		
	    ArrayList<Integer> words = new ArrayList<>();
	    try {
	      File myObj = new File(fileName);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        int data = myReader.nextInt();
	        words.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return words;
	  }
	
	public static int depthChanges(ArrayList<Integer> depths) {
		int changes = 0; 
		
		for(int i = 0; i<depths.size()-1; i++) {
			if(depths.get(i)<depths.get(i+1)) {
				changes++; 
			}
		}
		return changes;
	}
	
	public static int sumChanges(ArrayList<Integer> depths) {
		int changes = 0; 
		
		for(int i = 0; i < depths.size()-3; i++) {
			if(depths.get(i) < depths.get(i+3)) {
				changes++; 
			}
		}
		
		
		return changes; 
	}
	

}
