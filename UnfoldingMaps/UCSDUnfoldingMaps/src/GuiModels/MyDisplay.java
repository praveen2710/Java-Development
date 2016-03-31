package GuiModels;

import processing.core.PApplet;

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
	}
}
