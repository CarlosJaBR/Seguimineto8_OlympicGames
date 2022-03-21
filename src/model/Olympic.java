package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Olympic {

	private ArrayList<Country> countries; 
	
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
	/*
	 public void sortByAgeAsc() {
		Collections.sort(contacts, 
				//Clase anonima comparator
				new Comparator<Contact>() {
					//Criterio personalizado
					@Override
					public int compare(Contact o1, Contact o2) {
						return o1.getAge() - o2.getAge();
					}
		});
	}
	 */
	
}
