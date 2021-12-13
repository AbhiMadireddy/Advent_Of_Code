package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SmokeBasin{
	
	
	public static int[][] visited;
	
	
	public static void main(String[] args) {
		
		ArrayList<String> data = importFile("smoke.txt");
		
		int[][] smokes = new int[data.size()][data.get(0).length()]; 
		
		for(int i = 0; i < smokes.length; i++) {
			for(int n = 0; n < smokes[0].length; n++) {
				smokes[i][n] = Integer.parseInt(data.get(i).substring(n,n+1)); 
			
			}
		
		}
		
		System.out.println("The risk of each low-point is " + riskSum(smokes)); 
		
		System.out.println("The product of the three largest basins is "+basinArea(smokes));
		
		
	}
	
	public static int riskSum(int[][] smokes) {
		int sum = 0; 
		
		int row = smokes.length; 
		
		int col = smokes[0].length; 
		
		
		
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
	
	
	public static int basinArea(int[][] smokes) {
		
		visited = new int[smokes.length][smokes[0].length]; 
		
		int basin1 = 0; 
		
		int basin2 = 0; 
		
		int basin3 = 0;
		
		
		for(int i = 0; i < smokes.length; i++) {
			for(int j = 0; j < smokes[0].length; j++) {
				if(smokes[i][j] != 9 && visited[i][j] != 1) {
					int temp = parseBasin(smokes,i,j,smokes.length,smokes[0].length); 
					if(temp>basin1) {
						basin3 = basin2; 
						basin2 = basin1; 
						basin1 = temp; 
					}else if(temp>basin2) {
						basin3 = basin2; 
						basin2 = temp;
					}else if(temp>basin3) {
						basin3 = temp; 
					}
				}
			}
		}
		
		
		
		
		return basin1*basin2*basin3; 
	}
	
	
	public static int parseBasin(int[][] smokes, int i, int j, int row, int col) {
		int count = 0; 
		
		if(j<0 || i<0 || j>=col || i>=row || visited[i][j]==1) {
			return 0; 
		}
		
		visited[i][j] = 1; 
		
		if(smokes[i][j] == 9) {
			return 0; 
		}
		count++; 
		
		if(j<col) {
			count = count + parseBasin(smokes, i, j+1, row, col); 
		}
		
		if(j>0) {
			count = count + parseBasin(smokes, i, j-1, row, col);
		}
		
		if(i>0) {
			count = count + parseBasin(smokes, i-1, j, row, col);
		}
		
		if(i<row) {
			count = count + parseBasin(smokes, i+1, j, row, col); 
		}
		
		return count; 
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

