package sanitySuite;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Test;

public class ArrayPrograms {
	
	//@Test
	public void sortArray() {
		int arr[] = {1,2,4,6,8,6,4,3,2,1,45,67,54,21,34,98,78};
		int temp;
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1; j++) {
				if (arr[j]<arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int k=0; k<arr.length; k++) {
			System.out.println(arr[k]);
		}
	}
	
	//@Test
	public void sortString() {
		String []s = {"ert", "er", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "i"};
		for(int i=0; i<s.length-1; i++) {
			for(int j=0; j<s.length-1; j++) {
				int s1 = s[j].toString().length();
				int s2 = s[j+1].toString().length();
				if (s1 > s2) {
					String temp = s[j+1];
					s[j+1] = s[j];
					s[j] = temp;
				}
			}
		}
		for(int k=0; k<s.length; k++) {
			System.out.println(s[k]);
		}
	}
	
	//@Test
	public void countChars()
	{
		String s="abeeiioouueeuuiiooiiuuiiooiiuuiiooieueiieioeuieoaaaaeaeaeaeasasasasascabcdsg";
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				if(mp.containsKey(c)) {
					mp.put(c, mp.get(c)+1);
				}
				else {
					mp.put(c, 1);
				}					
			}
		}
		System.out.println(mp);		
	}
	
	//@Test
	public void TC005()
	{
		String str="tHis is INDIA";
		String newSentence="";
		char ch[] = str.toCharArray();
		for(char c : ch) {
			if(Character.isLowerCase(c)) {
				c = Character.toUpperCase(c);
			}
			else {
				c = Character.toLowerCase(c);
			}
			newSentence += c;
		}
		System.out.println(newSentence);
	}
	
	//@Test
	public void TC006()
	{
		String sentence="This is QTP Welcome";
		String[] str=sentence.split(" ");
		String newLine = "";
		for(String word : str){
			String newWord = "";
			for(int i=0; i<word.length(); i++) {
				newWord = word.charAt(i) + newWord;
			}
			newLine = newWord + " " + newLine;
		}	
		System.out.println(newLine);
	}
	
	//@Test
	public void hello() {
		String str = "AHCECLWLXO";
		String strNew = "";
		for(int i=1; i<str.length(); i=i+2) {
			strNew = strNew + str.charAt(i);
		}
		System.out.println(strNew);		
	}
	
	//@Test
	public void printList() {
		ArrayList<String> colours = new ArrayList<String>();
		colours.add("Red");
		colours.add("Black");
		colours.add("Pink");
		colours.add("Blue");
		colours.add("White");
		colours.add("Green");
		
		Iterator ls = colours.iterator();
		while(ls.hasNext()) {
//			if(ls.next().equals("Pink")) {
//				ls.remove();
//			}
			System.out.println(ls.next());
		}		
	}
	
	//@Test
	public void TC015()
	{
		int[][] arrInt = { { 1, 2,301 }, { 4, 21, 7 } ,{ 104, 23, 37 }};
		int maxxNumber = 1;
		for(int i=0; i<arrInt.length; i++) {
			for(int j=0; j<arrInt.length; j++) {
				if(arrInt[i][j] > maxxNumber) {
					maxxNumber = arrInt[i][j];
				}
			}
		}
		System.out.println(maxxNumber);		
	}
	
	//@Test
	public void TC011()
	{
		int number=1234;
		int reverse	=0;
		int remainder=0;
	    do {
	    	remainder = number%10;
	    	reverse = reverse*10 + remainder;
	    	number = number/10;	    	
	    }while(number>0);
		System.out.println(reverse);
	}
	
	//@Test
	public void TC012() {
		ArrayList<String> colours = new ArrayList<String>();
		colours.add("Red");
		colours.add("Black");
		colours.add("Pink");
		colours.add("Blue");
		colours.add("White");
		colours.add("Green");
		
		Comparator<String > cmp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}			
		};
		
		Collections.sort(colours, cmp);
		System.out.println("**********");
		colours.forEach(System.out::println);
		
		Collections.sort(colours, (a,b)->{
			return a.compareTo(b);
		});	
		System.out.println("**********");
		colours.forEach(System.out::println);
	}
	
	@Test
	public void TC013() {
		ArrayList<Integer> colours = new ArrayList<Integer>();
		colours.add(123);
		colours.add(245);
		colours.add(721);
		colours.add(984);
		colours.add(583);
		colours.add(199);
		
		Comparator<Integer> cmp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1%10 > o2%10) {
					return 1;
				}
				return 0;
			}				
		};
		
		Collections.sort(colours, cmp);
		System.out.println("**********");
		colours.forEach(System.out::println);
		
		Collections.sort(colours, (a,b)->{
			return a.compareTo(b);
		});	
		System.out.println("**********");
		colours.forEach(System.out::println);
	}
	
	
		
}
