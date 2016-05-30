package GuiModels;

import processing.core.PApplet;
/**
 * Example to draw a happy face using processing library
 * See <a href="https://processing.org/reference/libraries/">https://processing.org/reference/libraries/</a>
 * @author praveen
 *
 */
public class MyDisplay extends PApplet {

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		super.setup();
		size(400, 400);
		background(255,67,134);
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
		fill(255,255,0);
		ellipse(200,200,390,390);
		fill(0,0,0);
		ellipse(100,120,50,70);
		ellipse(300,120,50,70);
		noFill();
		arc(200,280,200,100, 0, PI);
		
	}
}
