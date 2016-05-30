package week3;

public class acessModiferExample {
	public int x;
	private float y;
	protected boolean a;
	double z;

	public acessModiferExample(){
		x = 5;
		y = 6.7f;
		a  = false;
		z = 5d;
	}
	
	public void display(){
		System.out.println("Inside accessModifierExample Class");
		System.out.println(this.x+","+this.y+","+this.a+","+this.z);
	}

	@Override
	public String toString() {
		return "acessModiferExample [x=" + x + ", y=" + y + ", a=" + a + ", z=" + z + "]";
	}
	
  
}
