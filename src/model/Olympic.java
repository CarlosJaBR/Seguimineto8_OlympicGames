package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Olympic {

	private ArrayList<Country> countries; 
	private BufferedWriter bw; 
	public Olympic() {
		countries = new ArrayList<Country>();
		
	}
	
	public ArrayList<Country> getCountries() {
		return countries; 
	}
	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries; 
	}
	
	public void addCountry(String name, int medalGoldMale, int medalSilverMale, int medalBronzeMale, int medalGoldFemale,
			int medalSilverFemale, int medalBronzeFemale) {
		
		Country obj = new Country(name,medalGoldMale,medalSilverMale,medalBronzeMale,medalGoldFemale,
				medalSilverFemale,medalBronzeFemale);
		countries.add(obj);
		
		
	}
	
	public void sortMedalsMale() {
		
		Collections.sort(countries,
				
				new Comparator<Country>() {

					@Override
					public int compare(Country c1, Country c2) {
						
						int result = c1.getMedalGoldMale()-c2.getMedalGoldMale(); 
						if(result==0) {
							result = c1.getMedalSilverMale()-c2.getMedalSilverMale(); 
						}
						if(result==0) {
							result = c1.getMedalBronzeMale()-c2.getMedalBronzeMale(); 
						}
						if(result==0) {
							result = c1.getName().compareTo(c2.getName());
						}
						//System.out.println("Hola " + result);
						result*=-1;
						return result;
					}
			
		});
	}
	
	public void sortMedalsFemale() {
		
		int n = countries.size();
		boolean flag = true; 
		for (int i = 0; i < n && flag; i++) {
			flag = false;
	    	for (int j = 1; j < n - i; j++) {
	    		if (countries.get(j).compareTo(countries.get(j-1)) > 0) {
	    			Country temp = countries.get(j);
	    			countries.set(j, countries.get(j-1));
	    	        countries.set(j-1, temp);
	    			flag = true;
	    		}
	    	}
	    }
		
	}
	public void sortMedalsCombinate() {
		boolean flag = true; 
		for(int i = 0; i<countries.size();i++) {
			flag = false;
			for(int j = 1; j<countries.size()-i;j++) {
				
				int result = countries.get(j).getCombinationGold()-countries.get(j-1).getCombinationGold();
				if(result==0) {
					result = countries.get(j).getCombinationSilver()-countries.get(j-1).getCombinationSilver();
				}
				if(result==0) {
					result = countries.get(j).getCombinationBronze()-countries.get(j-1).getCombinationBronze();
				}
				if(result==0) {
					result = countries.get(j).getName().compareTo(countries.get(j-1).getName());
				}
				result*=-1;
				if(result<0) {
					Country temp = countries.get(j);
					countries.set(j,countries.get(j-1));
					countries.set(j-1, temp);
					flag = true;
				}
			}
		}
	}
	
	public void loadCountries() throws IOException,NullPointerException {
		File file = new File(".\\files\\Countries.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		while((linea = br.readLine()) != null) {
			String[] info = linea.split(";");
			//System.out.println(linea);
			//System.out.println("-------");
			String name = info[0];
			int medalGoldMale = Integer.parseInt(info[1]);
			int medalSilverMale = Integer.parseInt(info[2]); 
			int medalBronzeMale = Integer.parseInt(info[3]); 
			int medalGoldFemale = Integer.parseInt(info[4]);
			int medalSilverFemale = Integer.parseInt(info[5]); 
			int medalBronzeFemale = Integer.parseInt(info[6]);
			addCountry(name, medalGoldMale, medalSilverMale, medalBronzeMale, medalGoldFemale, medalSilverFemale, medalBronzeFemale);
		}
	}
	public void saveCountries(String infoCountry) throws IOException {
		File file = new File(".\\files\\Countries.txt");
		FileWriter fw = new FileWriter(file,true);
		bw = new BufferedWriter(fw); 
		bw.write(infoCountry);
		bw.newLine();
		bw.close();
		fw.close();
		
	}
}
