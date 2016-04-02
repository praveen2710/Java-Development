package week2;

import java.net.URI;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Example to add a visual sun that will change colour based on time of day
 * @author praveen
 *
 */
public class MyApplet extends PApplet {
	
	String imageUrl = "http://images1.miaminewtimes.com/imager/u/original/8101242/sunrse_jacksonbville.jpg";
	private PImage backgroundImg;
	

	@Override
	public void setup() {
		size(200,200); //set canvas size
		
		backgroundImg = loadImage(imageUrl,"jpg");  //load background image
		backgroundImg.resize(0, height);   //resize background to canvas size
		image(backgroundImg, 0, 0);  //display image
	}
	
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
//		adding 0 to one of the parameters will make it keep aspect ratio
//		making second parameter height makes picture dynamic
		
		int[] color = sunColorSec(second());
		
		fill(color[0],color[1],color[2]);
		
		ellipse(width/4, height/5, width/5, height/5);
		
	}

	/**
	 * This is used to change the ratio of RGB based on how many seconds have passed
	 * since the last minute. We do a ratio so that the value does not go beyond 255
	 * since that is the max that a color can be.
	 * @param second
	 * @return
	 */
	private int[] sunColorSec(int second) {
		int[] rgb = new int[3];
		float difffrom30 = Math.abs(30-second);
		
		float ratio = difffrom30/30; //done so as not to exceed one
		rgb[0] = (int) (255*ratio);
		rgb[1] = (int) (255*ratio);
		rgb[2] = (int) (2555*ratio);
		
		return rgb;
	}

}
