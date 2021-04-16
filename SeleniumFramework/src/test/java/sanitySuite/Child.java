package sanitySuite;

import java.util.HashMap;

public class Child extends Parent {
	int i=20;
	public static void main(String args[]) {
		System.out.println("Main");
		//main2();
		Parent c = new Child();
		//c.main3();
		c.main2();
		System.out.println(c.i);
	}
	
	public void main2() {
		System.out.println("Main2");
	}
	
	public void main3() {
		System.out.println("Main3");
		new Child().main4();
	}
	 
	public void main4() {
		System.out.println("Main4");
	}
	
	public void main5() {
		System.out.println("Main5");
		new Child().main4();
	}	
}
