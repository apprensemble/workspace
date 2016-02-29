package json;

public class City {
	private String name;
	private Integer nbr;

	/**
	 *
	 */
	public City() {
	}

	/**
	 * @param name
	 * @param nbr
	 */
	public City(String name, Integer nbr) {
		this.name = name;
		this.nbr = nbr;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nbr
	 */
	public Integer getNbr() {
		return nbr;
	}

	/**
	 * @param nbr the nbr to set
	 */
	public void setNbr(Integer nbr) {
		this.nbr = nbr;
	}
	public String toString() {
		String nNbr = String.valueOf(nbr);
		return name+" "+nNbr;
	}
}
