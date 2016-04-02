package week2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;
/**
 * My implementation of the example being explained in coursera.
 * 
 * @author praveen
 *
 */
public class LifeExpetency extends PApplet{
	
	UnfoldingMap map;
	
	Map<String, Float> lifeExpMap ;
	
	List<Marker> countryMarkers;
	List<Feature> countries;
	
	
	@Override
	public void setup() {
		size(800,600,OPENGL);
		
		loadLifeExpectancy("/Users/praveen/Documents/UnfoldingMaps/UCSDUnfoldingMaps/data/LifeExpectancyWorldBank.csv");
		
		countries = GeoJSONReader.loadData(this, "/Users/praveen/Documents/UnfoldingMaps/UCSDUnfoldingMaps/data/countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		
		map = new UnfoldingMap(this, 50, 50, 700, 500,new Google.GoogleMapProvider());
		
		map.addMarkers(countryMarkers);
		shadeCountries();
//		this add zooming functionality
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	
	@Override
	public void draw() {
	 map.draw();
	}
	
	/**
	 * This will retrieve and store the country name and life expectancy as a map 
	 * @param fileName : the file which stores data
	 * @return {@link Map} Country and Life Expectancy.
	 */
	private Map<String,Float>
		loadLifeExpectancy(String fileName){
		
		
		lifeExpMap = new HashMap<String,Float>();
		
		String[] rows = loadStrings(fileName);
			
		for(String row : rows){
			String[] columns = row.split(",");
			if(columns[4] !=null && isFloat(columns[5])){
				float value = Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4],value);
			}
		}
		
		return lifeExpMap;
		
	}
	
	/**
	 * for each marker that is for each country . We will shade the marker based on life expectancy.
	 */
	private void shadeCountries(){
		
		for(Marker marker :  countryMarkers){
			String countryId = marker.getId();
			
			if(lifeExpMap.containsKey(countryId)){
				float lifeExp = lifeExpMap.get(countryId);
				//this will translate the life expectancy(40-90) to a color.
				int colorLevel = (int) map(lifeExp,40,90,10,255);
				marker.setColor(color(255-colorLevel,100,colorLevel));
			}else{
				marker.setColor(color(150,150,150));
			}
		}
	}
	
	private boolean isFloat(String value){
		try{
			Float.parseFloat(value);
			return true;
		}catch(NumberFormatException ne){
			return false;
		}
	}
	
}
