package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SmokeBasin{
	
	
	
	public static void main(String[] args) {
		
		ArrayList<String> data = importFile("smoke.txt");
		
		int[][] smokes = new int[data.size()][data.get(0).length()]; 
		
		for(int i = 0; i < smokes.length; i++) {
			for(int n = 0; n < smokes[0].length; n++) {
				smokes[i][n] = Integer.parseInt(data.get(i).substring(n,n+1)); 
			
			}
		
		}
		
		
		System.out.println(riskSum(smokes));
		
		
	}
	
	public static int riskSum(int[][] smokes) {
		int sum = 0; 
		
		int row = smokes.length; 
		
		int col = smokes[0].length; 
		
		
		
		System.out.println("row = "+ row+" col = "  + col);
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				int temp = smokes[r][c]; 
				if(r == 0) {
					if(c == 0) {
						if(temp < smokes[r][c+1] && temp < smokes[r+1][c]) {
							sum += temp+1; 
						}
					}else if(c == col-1) {
						if(temp < smokes[r][c-1] && temp < smokes[r+1][c]) {
							sum += temp+1; 
						}
					}else {
						if(temp < smokes[r][c-1] && temp < smokes[r][c+1] && temp < smokes[r+1][c]) {
							sum += temp+1; 
						}
					}
				}else if(r == row-1) {
					if(c == 0) {
						if(temp < smokes[r][c+1] && temp < smokes[r-1][c]) {
							sum += temp+1; 
						}
					}else if(c == col-1) {
						if(temp < smokes[r][c-1] && temp < smokes[r-1][c]) {
							sum += temp+1; 
						}
					}else {
						if(temp < smokes[r][c-1] && temp < smokes[r][c+1] && temp < smokes[r-1][c]) {
							sum += temp+1; 
						}
					}
				}else {
					if( c == 0) {
						if(temp < smokes[r][c+1] && temp < smokes[r+1][c] && temp < smokes[r-1][c]) {
							sum += temp+1; 
						}
					}else if(c == col-1) {
						if(temp < smokes[r][c-1] && temp < smokes[r-1][c] && temp < smokes[r+1][c]) {
							sum += temp+1; 
						}
					}else {
						if(temp < smokes[r][c+1] && temp < smokes[r][c-1] && temp < smokes[r-1][c] && temp < smokes[r+1][c]) {
							sum += temp+1; 
						}
					}
				}
			}
		}
		
		return sum; 
	}
	
	
	public static ArrayList<String> importFile(String fileName){
			
			ArrayList<String> nums = new ArrayList<>();
		    try {
		      File myObj = new File(fileName);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        nums.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		    return nums;
		  }

}
