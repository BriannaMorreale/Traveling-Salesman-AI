import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//Brianna Morreale

public class Search {
	
	public static ArrayList<City[]> search(City[] cities) {
		ArrayList<City[]> states = new ArrayList<City[]>();

		// This returns a single result
//		City [] c = new City[2];
//		c[0] = new City();
//		c[1] = new City();
//		states.add(c);
//		return states;
		
		City[] shortestDistance = cities;

		//make enough room for changes
		for (int i = 100; i >0 ; i--) {
			City[] tmpArray = new City[cities.length];
			int randomNumber = (int)(Math.random()*100);
			for (int j = 0; j < cities.length; j++) {
				tmpArray[j] = cities[j];
			}

			int randomCity = (int) (Math.random() * shortestDistance.length - 1);
			City city1 = tmpArray[randomCity];
			City city2 = tmpArray[randomCity + 1];

			tmpArray[randomCity] = city2;
			tmpArray[randomCity + 1] = city1;

			double tmpDistance = tmpArray[0].distance(tmpArray[tmpArray.length - 1]);
			double citiesDistance = shortestDistance[0].distance(shortestDistance[shortestDistance.length - 1]);

			for (int k = 0; k < cities.length - 1; k++) {
				tmpDistance += tmpArray[k].distance(tmpArray[k + 1]);
				citiesDistance += shortestDistance[k].distance(shortestDistance[k + 1]);
			}

			if (tmpDistance < citiesDistance || i > randomNumber) {
				shortestDistance = tmpArray;
				states.add(shortestDistance);
				cities = tmpArray;
				continue;
			}

			// if not, reset the cities
			tmpArray[randomCity] = city1;
			tmpArray[randomCity + 1] = city2;

		}
		
	
		return states;
	}
	
	
	
	
}
