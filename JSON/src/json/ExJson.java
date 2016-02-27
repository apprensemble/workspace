package json;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

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
			System.out.println("fin");
		}
		catch(JsonParseException e) {
			e.printStackTrace();
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
	}

}
