package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;
public class OlympicSystem {
	
	private static Olympic olympic; 
	private static Scanner sca; 
	
	
	public static void main(String[] args) {
		
		sca = new Scanner(System.in);
		
		System.out.println("=================================================");
		System.out.println("          Welcome to Olympic system :D           ");
		System.out.println("=================================================\n");
		
		
		int numberCountries = 0; 
		int counter = 0;
		try {
			do
				numberCountries = sca.nextInt(); 
				
			while(numberCountries<=0);
			sca.nextLine(); 
			olympic = new Olympic();
			
			while(counter<numberCountries) {
				
				enterCountry(counter);
				counter++; 
			}
			//Acá debo invocar los métodos de ordenamiento.
			//printArray();
			olympic.sortMedalsMale();
			//printArray();
			//olympic.sortMedalsFemale();
			printArray(); 
			
		} catch(InputMismatchException e) {
			System.out.println("Invalid data, check again :( ");
			e.printStackTrace();
		}	
	}
	
	public static void enterCountry(int counter) {
		
		try {
			String info = sca.nextLine(); 
			String[] infoCountry = info.split(";");
			String name = infoCountry[0];
			int medalGoldMale = Integer.parseInt(infoCountry[1]);
			int medalSilverMale = Integer.parseInt(infoCountry[2]); 
			int medalBronzeMale = Integer.parseInt(infoCountry[3]); 
			int medalGoldFemale = Integer.parseInt(infoCountry[4]);
			int medalSilverFemale = Integer.parseInt(infoCountry[5]); 
			int medalBronzeFemale = Integer.parseInt(infoCountry[6]);
			olympic.addCountry(name, medalGoldMale, medalSilverMale, medalBronzeMale, medalGoldFemale, medalSilverFemale, medalBronzeFemale);
		}catch(Exception e){
			System.out.println("Invalid data, check again :(");
			e.printStackTrace();
		}
	}
	public static void printArray() {
		System.out.println("Masculino");
		for(int i = 0; i<olympic.getCountries().size();i++) {
			System.out.println(olympic.getCountries().get(i).getName() + " " + olympic.getCountries().get(i).getMedalGoldMale() + " " + olympic.getCountries().get(i).getMedalSilverMale() + " " +
					olympic.getCountries().get(i).getMedalBronzeMale()); 
		}
		System.out.println("------");  
		System.out.println("Femenino"); 
		for(int i = 0; i<olympic.getCountries().size();i++) {
			System.out.println(olympic.getCountries().get(i).getName() + " " + olympic.getCountries().get(i).getMedalGoldFemale() + " " + olympic.getCountries().get(i).getMedalSilverFemale() + " " +
					olympic.getCountries().get(i).getMedalBronzeFemale()); 
		}
		System.out.println("------"); 
	}
	
}
