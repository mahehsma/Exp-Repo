
public class CityStack {
	String capital[];
	String country[];
	int population[];
	int itemCounter;

	CityStack(int i) {
		itemCounter = 0;
		capital = new String[i];
		country = new String[i];
		population = new int[i];
	}

	public void setCapitalCountry(String capital, String country, int population) {
		this.capital[itemCounter] = capital;
		this.country[itemCounter] = country;
		this.population[itemCounter] = population;
		itemCounter++;
	}

	public int getItemCounter() {
		return itemCounter;
	}

	public String getCapital(int pos) {
		return capital[pos];
	}

	public String getCountry(int pos) {
		return country[pos];
	}

	public int getPopulation(int i) {
		
		return population[i];
	}
}
