package flight.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import com.flightapp.entity.Flight;


public class StreamFilght {
	public static void main(String[] args) {
		List<Flight> allFlights = new ArrayList<>();
		Flight f1= new Flight(101,"indigo","chennai","delhi",1.2f,3.4f,"jan 11",2000,1.2f);
		Flight f2= new Flight(102,"indigo","Banglore","delhi",2.2f,3.4f,"jan 11",3000,2.2f);
		Flight f3= new Flight(103,"Airindia","delhi","hyderabad",3.2f,6.4f,"jan 20",5000,3.2f);
		
		Stream<Flight> stream = Stream.of(f1,f2,f3);
		
		//printAllFlights(stream);
		//filterAndSortBasedOnPrice(stream);
		//filterOnFlight(stream);
		filterAndUpdate(stream);
		
	}
	public static void printAllFlights(Stream<Flight> stream)
	{
		stream.forEach((flight)->{
			System.out.println(flight);
		});
	}
	
	public static void filterAndSortBasedOnPrice(Stream<Flight> stream)
	{
		stream.filter((flight)->{
			if(flight.getCarrierName().equals("indigo")) return true;
			else return false;
		}).
		sorted((f1,f2)->{
			return f1.getPrice() - f2.getPrice();
		}).
		forEach((flight)->{
			System.out.println(flight);
		});
	}
	public static void filterOnFlight(Stream<Flight> stream)
	{
		stream
		.filter((p)->{
			if((p.getFlightDuration() == 1.2f)) return true;
			else return false; 
		})
		.forEach((b)->{
			System.out.println(b);
		});
		
		
	}
	
	public static void filterAndUpdate(Stream<Flight> stream)
	{
		
		
		stream.filter((p)->{
			if((p.getCarrierName() == "indigo")) return true;
			else return false; 
		}).map((a)->{
			int oldPrice = a.getPrice();
			int newPrice = oldPrice + 999;
			a.setCost(newPrice);
			return a;
		}).map((k)->{
			float oldDuration = k.getFlightDuration();
			float newDuration = oldDuration + 1;
			k.setFlightDuration(newDuration);
			return k;
	    }).forEach((flight1)->{
			System.out.println(flight1);
		});
		
	}
	

}
