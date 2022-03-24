package model;

public class Country implements Comparable<Country>{
	
	private String name;
	private int medalGoldMale;
	private int medalSilverMale; 
	private int medalBronzeMale; 
	private int medalGoldFemale;
	private int medalSilverFemale; 
	private int medalBronzeFemale;
	private int combinationGold;
	private int combinationSilver;
	private int combinationBronze; 
	
	
	public Country(String name, int medalGoldMale, int medalSilverMale, int medalBronzeMale, int medalGoldFemale,
			int medalSilverFemale, int medalBronzeFemale) {
	
		this.name = name;
		this.medalGoldMale = medalGoldMale;
		this.medalSilverMale = medalSilverMale;
		this.medalBronzeMale = medalBronzeMale;
		this.medalGoldFemale = medalGoldFemale; 
		this.medalSilverFemale = medalSilverFemale;
		this.medalBronzeFemale = medalBronzeFemale;
		this.combinationGold= medalGoldMale + medalGoldFemale;
		this.combinationSilver = medalSilverMale + medalSilverFemale;
		this.combinationBronze = medalBronzeMale + medalBronzeFemale; 
	}
	
	public int getCombinationGold() {
		return combinationGold;
	}

	public void setCombinationGold(int combinationGold) {
		this.combinationGold = combinationGold;
	}

	public int getCombinationSilver() {
		return combinationSilver;
	}

	public void setCombinationSilver(int combinationSilver) {
		this.combinationSilver = combinationSilver;
	}

	public int getCombinationBronze() {
		return combinationBronze;
	}

	public void setCombinationBronze(int combinationBronze) {
		this.combinationBronze = combinationBronze;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMedalGoldMale() {
		return medalGoldMale;
	}
	public void setMedalGoldMale(int medalGoldMale) {
		this.medalGoldMale = medalGoldMale;
	}
	public int getMedalSilverMale() {
		return medalSilverMale;
	}
	public void setMedalSilverMale(int medalSilverMale) {
		this.medalSilverMale = medalSilverMale;
	}
	public int getMedalBronzeMale() {
		return medalBronzeMale;
	}
	public void setMedalBronzeMale(int medalBronzeMale) {
		this.medalBronzeMale = medalBronzeMale;
	}
	public int getMedalSilverFemale() {
		return medalSilverFemale;
	}
	public void setMedalSilverFemale(int medalSilverFemale) {
		this.medalSilverFemale = medalSilverFemale;
	}
	public int getMedalBronzeFemale() {
		return medalBronzeFemale;
	}
	public void setMedalBronzeFemale(int medalBronzeFemale) {
		this.medalBronzeFemale = medalBronzeFemale;
	}

	public int getMedalGoldFemale() {
		return medalGoldFemale;
	}

	public void setMedalGoldFemale(int medalGoldFemale) {
		this.medalGoldFemale = medalGoldFemale;
	} 
	
	public String toString() {
		String info = ""; 
		info += "Country name: " + name; 
		return info;
	}
	@Override
	public int compareTo(Country other) {
		int result = this.medalGoldFemale-other.medalGoldFemale;
		if(result==0) {
			result = this.medalSilverFemale-other.medalSilverFemale;
		}
		if(result==0) {
			result = this.medalBronzeFemale-other.medalBronzeFemale;
		}
		if(result ==0) {
			result = this.name.compareTo(other.name);
		}
		result*=-1;
		return result;
	}

	
}
