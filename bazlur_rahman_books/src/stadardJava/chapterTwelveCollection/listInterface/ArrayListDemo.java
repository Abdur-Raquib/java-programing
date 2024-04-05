package stadardJava.chapterTwelveCollection.listInterface;
import java.util.List;
import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] a) {
		List<String> topCities=new ArrayList<>();
		
		topCities.add("London");
		topCities.add("New York");
		topCities.add("Paris");
		topCities.add("Moscow");
		topCities.add("Tokyo");
		topCities.add("Dubai");
		topCities.add("Bacelona");
		
		topCities.add(2,"Dhaka"); //void add(int index, E element) add element in specific index.
		
		String str = topCities.get(2);
		
		System.out.print("top Cities: ");
		System.out.print(topCities+"\n");
		for(int i=0; i<topCities.size(); i++) {
			System.out.print(topCities.get(i) + " ");
		}
		System.out.print(str);
	}
}
