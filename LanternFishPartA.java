package Day6;

import java.util.ArrayList; 

public class LanternFishPartA {
	
	public static void main(String[] args) {
		
		int[] fishes = {5,3,2,2,1,1,4,1,5,5,1,3,1,5,1,2,1,4,1,2,1,2,1,4,2,4,1,5,1,3,5,4,3,3,1,4,1,3,4,4,1,5,4,3,3,2,5,1,1,3,1,4,3,2,2,3,1,3,1,3,1,5,3,5,1,3,1,4,2,1,4,1,5,5,5,2,4,2,1,4,1,3,5,5,1,4,1,1,4,2,2,1,3,1,1,1,1,3,4,1,4,1,1,1,4,4,4,1,3,1,3,4,1,4,1,2,2,2,5,4,1,3,1,2,1,4,1,4,5,2,4,5,4,1,2,1,4,2,2,2,1,3,5,2,5,1,1,4,5,4,3,2,4,1,5,2,2,5,1,4,1,5,1,3,5,1,2,1,1,1,5,4,4,5,1,1,1,4,1,3,3,5,5,1,5,2,1,1,3,1,1,3,2,3,4,4,1,5,5,3,2,1,1,1,4,3,1,3,3,1,1,2,2,1,2,2,2,1,1,5,1,2,2,5,2,4,1,1,2,4,1,2,3,4,1,2,1,2,4,2,1,1,5,3,1,4,4,4,1,5,2,3,4,4,1,5,1,2,2,4,1,1,2,1,1,1,1,5,1,3,3,1,1,1,1,4,1,2,2,5,1,2,1,3,4,1,3,4,3,3,1,1,5,5,5,2,4,3,1,4};
		ArrayList<Integer> lamp = new ArrayList<>(); 
		
		for(int i = 0; i<fishes.length; i++) {
			lamp.add(fishes[i]); 
		}
		
		simulate(lamp,80);
	}
	
	public static ArrayList<Integer> day(ArrayList<Integer> lamp) {
		
		int temp = lamp.size();
		for(int i = 0; i < temp; i++) {
			if(lamp.get(i) == 0) {
				lamp.set(i, 6);
				lamp.add(8); 
			}else {
				lamp.set(i, lamp.get(i)-1);
			}
		}
		return lamp;
	}
	
	public static void simulate(ArrayList<Integer> lamp, int n){
		
		for(int i = 0; i < n; i++) {
			lamp = day(lamp);
		}
		System.out.println(lamp.size()); 
	}
	

}
