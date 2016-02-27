package json;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 *
 * @author
 */
public class ExJson {
	private static Path city = Paths.get("res","city.json");
	private static File fCity = city.toFile();
	private static Path listCity = Paths.get("res","listCity.json");
	private static File fListCity = listCity.toFile();
	private static void exercice1() {
		City paris = new City();
		paris.setName("Paris");
		paris.setNbr(2000000);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(fCity,paris);

		}
		catch (JsonParseException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static void exercice2() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			City paris = mapper.readValue(fCity,City.class);
			System.out.format("%s : %s -> %s",paris,paris.getName(),paris.getNbr());

		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	private static void exercice3() {
		CityList capitales = new CityList();
		capitales.add(new City("Paris",2000000));
		capitales.add(new City("Washington",10));
		ArrayList<City> reste = new ArrayList<>();
		reste.add(new City("London",500));
		reste.add(new City("Tokyo",100));
		capitales.addAll(reste);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(fListCity,capitales);	
		}
		catch(JsonParseException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

	private static void exercice4() {
		JsonFactory jf = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper();
		JsonParser jp;
		ArrayList<City> lc = new ArrayList<>();	
		try {
			jp = jf.createParser(fListCity);
			//on pointe vers le debut
			System.out.println("debut");
			System.out.println(jp.nextToken());
			//on pointe vers le nom de l'array
			System.out.println(jp.nextToken());
			//System.out.format("parsing de l'objet : %s",mapper.readValue(jp, String.class));
			System.out.println(jp.nextToken());
			//System.out.println(jp.nextToken());
			while(jp.nextToken() == JsonToken.START_OBJECT) {
				City c = mapper.readValue(jp, City.class);
				System.out.format("city : %s\n",c);
				lc.add(c);
			}
			lc.forEach(c -> System.out.format("{%s,%s}",c.getName(),c.getNbr()));
			System.out.println("fin");
		}
		catch(JsonParseException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pareille que l'exercice 4 mais avec une map au lieu d'une liste pour voir
	 * Pourquoi se prendre la tête à parser ?
	 *
	 */
	@SuppressWarnings("unchecked")
	private static void exercice4Bis() {
		ObjectMapper mapper = new ObjectMapper();
		SortedMap<String,City> mc = new TreeMap<>();
		try {
			mc = mapper.readValue(fListCity,SortedMap.class);
			System.out.format("%s",mc);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}	
	private static void exercice5() {
		System.out.println("exercice5");
		ObjectMapper mapper = new ObjectMapper();
		City paris = new City("Paris",20);
		//recup exercice3
		CityList capitales = new CityList();
		capitales.add(new City("Paris",2000000));
		capitales.add(new City("Washington",10));
		ArrayList<City> reste = new ArrayList<>();
		reste.add(new City("London",500));
		reste.add(new City("Tokyo",100));
		capitales.addAll(reste);
		try {
			System.out.println("la city à londre");
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(paris));
			System.out.println("la liste");
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(capitales));

		}
		catch(IOException e) {
			e.printStackTrace();
		}
	
	}

	public static void main(String[] args) {
		exercice1();
		exercice2();
		exercice3();
		exercice4();
		exercice4Bis();
		exercice5();
	}

}
