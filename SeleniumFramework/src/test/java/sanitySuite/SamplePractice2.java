package sanitySuite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// import com.gargoylesoftware.htmlunit.javascript.host.html.Enumerator;

public class SamplePractice2 {
	
		
	//@Test
	public void hello() {
		String str = "AHCECLWLXO";
		String strNew = "";
		String s[] = str.split("");
		for(int i=1; i<s.length; i=i+2) {
			strNew = strNew + s[i];
		}
		System.out.println(strNew);
	}
	
	//@Test
	public void helloCaps() {
		String str = "ahceclwlxo";
		String strNew = "";
		String s[] = str.split("");
		for(int i=1; i<s.length; i=i+2) {
			strNew = strNew + s[i].toUpperCase();
		}
		System.out.println(strNew);
	}
	
	//@Test
	public void numbers() {
		for(int i=-15; i<10; i++) {
			System.out.println(i);
		}		
	}
	
	//@Test
	public void multiply() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i = 1; i<=10; i++) {
			System.out.println("Multiply is: " + num*i);
		}		
	}
	
	//@Test
	public void primeNum() {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int flag = 0;
		for(int i = num1; i<=num2; i++) {
			for(int j = 2; j<i; j++) {
				if(i%j == 0) {
					flag=0;
					break;
				}
				else {
					flag = 1;
				}
			}		
			if(flag == 1) {
				System.out.println(i + " Number is Prime");
			}
		}		
	}
	
	//@Test
	public void fact() {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int fact = 1;
		for(int i = num1; i>0; i--) {
			fact = i*fact;
		}		
		System.out.println("Fact is: " + fact);
	}
	
	//@Test
	public void reverse() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String strRev = "";
		for(int i = str.length()-1; i>=0; i--) {
			strRev = strRev + str.charAt(i);
		}		
		System.out.println("Reverse is: " + strRev);
	}
	
	//@Test
	public void numCalc() {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		boolean flag = false;
		if(num1==6  || num2 ==6 || num1+num2==6 || num1-num2==6 || num2-num1==6) {
			flag = true;
		}
		System.out.println(flag);				
	}
	
	//@Test
	public void strRem() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String strRem = "";
		int num1 = sc.nextInt();
		for(int i = str.length()-1; i>=0; i--) {
			if(i != num1) {
				strRem = str.charAt(i) + strRem;
			}
		}		
		System.out.println("String is: " + strRem);
	}
	
	//@Test
	public void strDev() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String str1 = "";
		String str2 = "";
		for(int i = 0; i<str.length()/2; i++) {
			str1 = str1 + str.charAt(i);			
		}
		System.out.println("String1 is: " + str1);
		for(int i = str.length()/2; i<str.length(); i++) {
			str2 = str2 + str.charAt(i);			
		}	
		System.out.println("String1 is: " + str2);
		
	}
	
	//@Test
	public void printChar() {
		Character c = 'a';	
		
		System.out.println(c);
		System.out.println('k');		
	}
	
	//@Test
	public void arrSort() {
		int[] arr= {1,6,7,1,2,8,9,4,5,3,9,2,7,8,3,5,7,1,2,6,7,9,4,3};
		int temp;
		for(int i=0; i < arr.length-1; i++) {
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		 for(int k=0; k<arr.length-1; k++) {
			 System.out.println(arr[k]);
		 }
		
	}
	
	//@Test
	public void strCount() {
		final int ASCII_SIZE = 256; 
		String str = "sumitsehgalsamsingh";
		int count[] = new int[ASCII_SIZE]; 
		int len = str.length(); 
        for (int i=0; i<len; i++) {
            //count[str.charAt(i)]++; 
            System.out.println(str.charAt(i) +" : " + count[str.charAt(i)]++);
        }
        int max = -1;
        char result = ' ';        
        
        for (int i = 0; i < len; i++) { 
            if (max < count[str.charAt(i)]) { 
                max = count[str.charAt(i)]; 
                result = str.charAt(i); 
            } 
        } 
       
        System.out.println(result);
		
	}
	
	@Test
	public void TC014()
	{
		String String = "ABC";
		System.out.println(String);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
