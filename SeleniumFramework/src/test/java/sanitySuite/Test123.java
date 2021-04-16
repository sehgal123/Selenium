package sanitySuite;

import org.testng.annotations.Test;

public class Test123 {
	
	@Test
	public void printPattern() {
		
		for(int i=0; i<=5; i++) {
			for(int j=0; j<i; j++) {				
				System.out.print("*");
			}
			System.out.println();
		}		
	}
	
	@Test
	public void printPatternNew() {
		
		for(int i=0; i<=5; i++) {
			for(int j=0; j<i; j++) {				
				System.out.print(i);
			}
			System.out.println();
		}		
	}

}
