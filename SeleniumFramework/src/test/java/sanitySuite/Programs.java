package sanitySuite;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.Test;

public class Programs {
	
	
	@Test 
	public void listPrint() {
		ArrayList<String> ls = new ArrayList<String>();
		//ls.add("Sum");
		//ls.add("Ram");
		System.out.println(ls.get(0));
		System.out.println(ls.get(1));
		System.out.println(ls.get(2));		
	}
	
	//@Test 
	public void splitString() {
		String str = "iuabcGetabcbusyabclivabcingabcdsaabcwabcwqabc";
		String pat = "abc";
		int N = str.length();
		int M = pat.length();
		int res = 0;
		for(int i=0; i<=N-M; i++) {
			int j=0;
			for(j=0; j<M; j++) {
				if (str.charAt(i+j) != pat.charAt(j)) {
					break;
				}
			}
			if(j==M) {
				res = res + 1;
				j = 0;
			}			
		}
		System.out.println(res);
	}
	
	//@Test 
	public void multilineString() {
		String str = "Get 123busy living\n"
	            + "or\n"
	            + "get busy456 dying.\n"
	            + "--Stephen@3$%^&* King";
		System.out.println(str);
		String strNew = str.replace("\n", "");
		System.out.println(strNew);		
		System.out.println(strNew.replace(" ", ""));
		int numCount=0, charCount=0, specCount=0;
		
		for(int i=0; i<str.length();i++) {
			if(Character.isAlphabetic(str.charAt(i))) {
				charCount = charCount+1;
			}
			else if (Character.isDigit(str.charAt(i))) {
				numCount = numCount + 1;
			}
			else {
				specCount = specCount + 1;
			}
		}
		System.out.println(charCount + " " + numCount + " " + specCount);
	}
	
	//@Test 
	public void stringUpperLower() {
		String str = "SumitSem is Good PerSon";
		StringBuffer strNew=new StringBuffer(str); 
		for(int i=0;i<str.length()-1;i++) {
			if(Character.isLowerCase(str.charAt(i))) { 
				 strNew.setCharAt(i, Character.toUpperCase(str.charAt(i)));    
			}
			else if(Character.isUpperCase(str.charAt(i))) {   
				strNew.setCharAt(i, Character.toLowerCase(str.charAt(i)));    
			}    
		}		
		System.out.println(strNew);
	}
	
	//@Test
	public void stringReplace() {
		String str = "SumitSem is Good PerSon";
		StringBuffer strNew=new StringBuffer(str); 
		for(int i=0;i<str.length()-1;i++) {
			if(str.charAt(i) == ' ') { 
				 strNew.setCharAt(i, '-'); 			 
			}
		}
		System.out.println(strNew);
	}
	
	//@Test
	public void stringRemoveSpaces() {
		String str = "SumitSem is good person";
		String strNew = "";
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) != ' ') {
				strNew += str.charAt(i);
			}
		}
		System.out.println(strNew);
	}
	
	//@Test
	public void stringSubset() {
		String str = "SumitSem";
		int len = str.length();
		int temp = 0;
		String arr[] = new String[len*(len+1)/2]; 
		
		//This loop maintains the starting character  
        for(int i = 0; i < len; i++) {  
            //This loop adds the next character every iteration for the subset to form and add it to the array  
            for(int j = i; j < len; j++) {  
                arr[temp] = str.substring(i, j+1);  
                temp++;  
            }  
        }  
        System.out.println("All subsets for given string are: ");  
        for(int i = 0; i < arr.length; i++) {  
            System.out.println(arr[i]);  
        }  		
	}
	
	//@Test
	public void stringChars() {
		String str = "SumitSem is good person";
		int count=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) != ' ')
				count = count+1;
		}
		System.out.println(count);
	}
	
	//@Test
	public void stringVowelChars() {
		String str = "SumitSem is good person";
		int cCount=0, vCount=0;
		str = str.toLowerCase();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c != ' ') {
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					vCount = vCount+1;
				}
				else if (c >= 'a' && c <= 'z') {
					cCount = cCount + 1;
				}
			}
		}
		System.out.println(cCount + " " + vCount);
	}
	
	//@Test
	public void stringAnagram() {
		String str1 = "SumitSem is good person";
		String str2 = "person SumitSem good is";
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		if(str1.length() != str2.length()) {
			System.out.println("not eqaul - no Anagram");
		}
		else {
			char c1[] = str1.toCharArray();
			char c2[] = str2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			if(Arrays.equals(c1, c2)) {
				System.out.println("Anagram");
			}
			else {
				System.out.println("Not anagram");
			}
		}
	}
	
	//@Test
	public void printStar() {
		for(int i=0; i<6; i++) {
			for(int j=i; j>=0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//@Test
	public void printRevStar() {
		for(int i=6; i>=0; i--) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//@Test
	public void fibbonacci() {
		int n1=0,n2=1,n3,i,count=10;
		System.out.println(n1 + " " + n2);
		for(i=2;i<count;i++) {
			n3 = n1 + n2;
			System.out.println(n3);
			n1 = n2;
			n2 = n3;
		}
	}
	
	//@Test
	public void armStrongNumber() {
		int num = 159;
		int c = 0;
		int a;
		int temp = num;
		while(num>0) {
			a = num % 10;
			num = num / 10;
			c = c + (a*a*a);
		}
		System.out.println(c);
		if(c==temp) {
			System.out.println("Number is armstrong");
		}
		else {
			System.out.println("Number not armstrong");
		}
	}
	
	//@Test
	public void primeNumber() {
		int num = 20;
		boolean flag = true;
		for(int i = 2; i<=num/2; i++)
		{
			if(num % i == 0) {
				flag = false;
			}
		}
		if(flag == true) {
			System.out.println("Num is prime");
		}
		else {
			System.out.println("Not prime");
		}		
	}
	
	//@Test
	public void factorial() {
		int num = -4;
		int fact = 1;
		if(num>=1) {
			for(int i=num; i>0; i--) {
				fact = fact * i;
			}
			System.out.println(fact);
		}
		else
			System.out.println("Wrong input");		
	}

}
