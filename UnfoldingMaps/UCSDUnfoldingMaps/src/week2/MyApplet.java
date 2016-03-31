package week2;

import java.net.URI;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import processing.core.PApplet;
import processing.core.PImage;

public class MyApplet extends PApplet {
	
	String imageUrl = "http://images1.miaminewtimes.com/imager/u/original/8101242/sunrse_jacksonbville.jpg";
	private PImage backgroundImg;
	

	@Override
	public void setup() {
		size(200,200);
		
		backgroundImg = loadImage(imageUrl,"jpg");
		
	}
	
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
//		adding 0 to one of the parameters will make it keep aspect ratio
//		making second parameter height makes picture dynamic
		backgroundImg.resize(0, height);
		image(backgroundImg, 0, 0);
		Calendar cal = Calendar.getInstance();
		
		int hours = cal.get(Calendar.HOUR_OF_DAY);
		if(hours<13)
			fill(255,209,0);
		else
			fill(255,0,0);
		ellipse(width/4, height/5, width/5, height/5);
		
	}

}
