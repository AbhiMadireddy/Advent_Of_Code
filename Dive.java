package Day2; 

import java.util.ArrayList; 
import java.io.File;  // Import the File class
import java.io.FileNotFoundException; 
import java.util.Scanner; 


public class Dive {
	
	
	public static void main(String[] args) {
		
		ArrayList<String> list = importFile("commands.txt");
		
		int horizontal = 0; 
		int vertical = 0; 
		int aim = 0; 
		
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i); 
			String t = str.substring(str.indexOf(" ")+1);
			int num = Integer.parseInt(t);
			if(str.indexOf("forward") != -1) {
				horizontal += num;
				vertical += aim*num; 
			}else if(str.indexOf("down") != -1) {
				aim += num; 
			}else {
				aim -= num; 
			}
		}
		
		System.out.println(vertical*horizontal); 
	}
	
	public static ArrayList<String> importFile(String fileName){
		ArrayList<String> words = new ArrayList<>();
	    try {
	      File myObj = new File(fileName);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        words.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return words;
	}

}
