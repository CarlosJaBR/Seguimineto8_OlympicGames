package ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;
public class OlympicSystem {
	
	private static Olympic olympic; 
	private static Scanner sca; 
	
	
	public static void main(String[] args) throws IOException {
		
		sca = new Scanner(System.in);
		
		System.out.println("=================================================");
		System.out.println("          Welcome to Olympic system :D           ");
		System.out.println("=================================================\n");
		
		//Método para borrar contenido de una lista cuando se desee. 
		//deleteInfoFile(); 
		
		int numberCountries = 0; 
		int counter = 0;
		olympic = new Olympic();
			try {
				if(validationFile()==false) {
					
					do {
						numberCountries = sca.nextInt(); 
						
					}while(numberCountries<=0);
					sca.nextLine(); 
					
					while(counter<numberCountries) {
						
						enterCountry(counter);
						counter++; 
					}
				}else {
					try {
						olympic.loadCountries();
					}catch(NullPointerException e) {
						e.printStackTrace();
					} 
					catch (IOException e) {
						System.out.println("Error with data, check again :(");
						e.printStackTrace();
					}
				}
				System.out.println("\n");
				olympic.sortMedalsMale();
				printMedalMale();
				olympic.sortMedalsFemale();
				printMedalFemale(); 
				olympic.sortMedalsCombinate();
				printMedalCombinate();
			
			} catch(InputMismatchException e) {
				System.out.println("Invalid data, check again :( ");
				e.printStackTrace();
			}
		
	}
	
	public static void enterCountry(int counter) {
		String info = "";	
			try {
				info = sca.nextLine(); 
				String[] infoCountry = info.split(";");
				String name = infoCountry[0];
				int medalGoldMale = Integer.parseInt(infoCountry[1]);
				int medalSilverMale = Integer.parseInt(infoCountry[2]); 
				int medalBronzeMale = Integer.parseInt(infoCountry[3]); 
				int medalGoldFemale = Integer.parseInt(infoCountry[4]);
				int medalSilverFemale = Integer.parseInt(infoCountry[5]); 
				int medalBronzeFemale = Integer.parseInt(infoCountry[6]);
				olympic.saveCountries(info);
				olympic.addCountry(name, medalGoldMale, medalSilverMale, medalBronzeMale, medalGoldFemale, medalSilverFemale, medalBronzeFemale);
			}catch(Exception e){
				System.out.println("Error reading and saving data, check again :(");
				e.printStackTrace();
			}
		
	}
	public static void printMedalMale() {
		System.out.println("Masculino");
		for(int i = 0; i<olympic.getCountries().size();i++) {
			System.out.println(olympic.getCountries().get(i).getName() + " " + olympic.getCountries().get(i).getMedalGoldMale() + " " + olympic.getCountries().get(i).getMedalSilverMale() + " " +
					olympic.getCountries().get(i).getMedalBronzeMale()); 
		}
		System.out.println("------");  
	}
	public static void printMedalFemale() {
		System.out.println("Femenino"); 
			for(int i = 0; i<olympic.getCountries().size();i++) {
				System.out.println(olympic.getCountries().get(i).getName() + " " + olympic.getCountries().get(i).getMedalGoldFemale() + " " + olympic.getCountries().get(i).getMedalSilverFemale() + " " +
						olympic.getCountries().get(i).getMedalBronzeFemale()); 
			}
		System.out.println("------"); 
	}
	
	public static void printMedalCombinate() {
		System.out.println("Combinado"); 
		for(int i = 0; i<olympic.getCountries().size();i++) {
			System.out.println(olympic.getCountries().get(i).getName() + " " + olympic.getCountries().get(i).getCombinationGold() + " " + olympic.getCountries().get(i).getCombinationSilver() + " " +
					olympic.getCountries().get(i).getCombinationBronze()); 
		}
		System.out.println("------"); 
	}
	public static boolean validationFile() {
		File file = new File(".\\files\\Countries.txt");
		boolean indication = false;
		if(file.length()==0) {
			indication =false;
		}else {
			indication =true;
		}
		return indication;
	}
	
	public static void deleteInfoFile() {
		File file; 
		FileWriter fw;
		BufferedWriter bw;
		try {
			file = new File(".\\files\\Countries.txt");
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw); 
			bw.write("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
