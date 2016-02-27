package json;

import java.util.ArrayList;

/**
 *
 *
 * @author
 */
public class CityList {
	private ArrayList<City> cityList;

	/**
	 *
	 */
	public CityList() {
		cityList = new ArrayList<>();
	}

	/**
	 * @param cityList
	 */
	public CityList(ArrayList<City> cityList) {
		this.cityList = cityList;
	}

	/**
	 * @return the cityList
	 */
	public ArrayList<City> getCityList() {
		return cityList;
	}

	/**
	 * @param cityList the cityList to set
	 */
	public void setCityList(ArrayList<City> cityList) {
		this.cityList = cityList;
	}

	/**
	 * add a city to the cityList
	 *
	 * @param city
	 */
	public void add(City city) {
		cityList.add(city);
	}

	/**
	 * add many cities to the cityList
	 *
	 * @param manyCity
	 */
	public void addAll(ArrayList<City> manyCity) {
		cityList.addAll(manyCity);
	}

}
