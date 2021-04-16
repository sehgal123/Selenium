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
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

// import com.gargoylesoftware.htmlunit.javascript.host.html.Enumerator;

public class SamplePractice {
	
	@Test
	public void TC001()
	{
		int[] arr= {1,6,7,1,2,8,9,4,5,3,9,2,7,8,3,5,7,1,2,6,7,9,4,3,};
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j+1]; 
	                arr[j+1]=arr[j];
	                arr[j]=temp;
				}
			}
		}
		for(int k=0;k<arr.length;k++)
		{
			System.out.println(arr[k]);
			System.out.println();
		}
	}
	
	@Test
	public void TC002()
	{
		 String []s = {"ert", "er", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", "i"};
		 
		 for(int i=0;i<s.length-1;i++)
		 {
			 for(int j=0;j<s.length-1;j++)
			 {
				 if(s[j].toString().length()<s[j+1].toString().length())
				 {
					 String temp=s[j+1];
					 s[j+1]=s[j];
					 s[j]=temp;
				 }
			 }
			 
		 }
		 for(int k=0;k<s.length;k++)
			{
				System.out.println(s[k]);
				System.out.println();
			}
		 System.out.println(s[1]);		 
	}
	
	@Test
	public void TC003()
	{
		String s="abeeiioouueeuuiiooiiuuiiooiiuuiiooieueiieioeuieoaaaaeaeaeaeasasasasascabcdsg";
		Map<Character,Integer> map= new HashMap<Character,Integer>();
		char[]c=s.toCharArray();
		for(char ch :c)
		{
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
			{
				if(map.containsKey(ch))
				{
					map.put(ch,map.get(ch)+1);
				}
				else
				{
				map.put(ch, 1);
				}
			}
		
		
	}
		System.out.println(map);
	}
	
	@Test
	public void TC004()
	{
		
		int count=0;
		int n=132;
		for(int i=1;i<n/2;i++)
		{
			if(n%i==0)
			{
				count=count+1;
			}
		}
		if(count>2)
		{
			System.out.println("not prime number");
		}
		else
		{
			System.out.println("prime number");
		}
	}
	
	@Test
	public void TC005()
	{
		String str="tHis is INDIA";
		String newSentence="";
        for(int i=0;i<str.length();i++)
        {
        	
        	char c;
        	
        	if(Character.isLowerCase(str.charAt(i)))
        	{
        		c=Character.toUpperCase(str.charAt(i));
        	}
        	else
			{
        		c=Character.toLowerCase(str.charAt(i));
			}
        	newSentence+=c;
        }
        System.out.println(newSentence);
		
		/*String[] split=str.split(" ");
		String newString="";
		
		for(String s:split )
		{
			String newWord="";
			char[] ch=s.toCharArray();
			for(char c:ch)
			{
				if(Character.isUpperCase(c))
				{
					c=Character.toLowerCase(c);
					System.out.println( c);
					
				}
				else
				{
					c=Character.toUpperCase(c);
					System.out.println(c);
				}
				
				
			    
				newWord+=c;
				
			}
			
			newString+=newWord+" ";
		}
	
		System.out.println(newString);*/
	}
	
	
	@Test
	public void TC006()
	{
		String sentence="This is QTP Welcome";
		String[] str=sentence.split(" ");
		String newSentence="";
		for(String s:str)
		{
			String revWord="";
			char[] ch=s.toCharArray();
			for(int i=ch.length-1;i>=0;i--)
			{
				revWord+=ch[i];
			}
			
			newSentence+=revWord+" ";	
		}
		System.out.println(newSentence);
	}
	
	@Test
	public void TC007() throws IOException
	{
		
		/*FileInputStream f= new FileInputStream("C:/Users/vijay.a.rawat/Downloads/Colors1.txt");
		BufferedReader br= new BufferedReader(new InputStreamReader(f));
		StringBuilder sb= new StringBuilder();*/
		List<String> list= new ArrayList<String>();
		for(String str:Files.readAllLines(Paths.get("C:/Users/vijay.a.rawat/Downloads/Colors.txt")))
		{
			if(str.length()!=0)
			{
			list.add(str);
			}
		}
		Map<String, Integer> map= new HashMap<String,Integer>();
		for(String str:list)
		{
		
			if(map.containsKey(str))
			{
				map.put(str, map.get(str)+1);
			}
			else
			{
				map.put(str, 1);
			}
			
		}
		System.out.println(map);
	}
	
	@Test
	public void TC008()
	{
		Map<Integer,String> map= new HashMap<Integer,String>();
		map.put(1, "Grey");
		map.put(2, "Red");
		map.put(3, "white");
		map.put(4, "Grey");
		map.put(5, "Red");
		map.put(6, "white");
		Map<Integer,String>	map1= new HashMap<Integer,String>();
		Set<String>set =map.entrySet().stream().map(e->e.getValue()).collect(Collectors.toSet());
		for(Map.Entry<Integer, String> entry:map.entrySet())
		{
			if(!map1.containsValue(entry.getValue()))
			{
				
				map1.put(entry.getKey(), entry.getValue());
				
			}
		}
		System.out.println(map1);
		
		map.forEach(
				(key,value)->{
					if(!map1.containsValue(value))
					{
						map1.put(key,value);
					}
				});
		System.out.println(map1);
	}
	
	@Test
	public void TC009()
	{
		List<String> colors= new ArrayList<String>();
		colors.add("Grey");
		colors.add("Red");
		colors.add("white");
		colors.add("Grey");
		colors.add("Red");
		colors.add("white");
		
		Set<String> set=colors.stream().collect(Collectors.toSet());
		set.stream().collect(Collectors.toList()).forEach(e->System.out.println(e));
		System.out.println("***************");
		colors.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList()).forEach(e->System.out.println(e));
	}
	
	@Test
	public void TC0010()
	{
		Map<Integer,String> map= new HashMap<Integer,String>();
		map.put(1, "Grey");
		map.put(2, "Red");
		map.put(3, "white");
		map.put(4, "Grey");
		map.put(5, "Red");
		map.put(6, "white");
		
		Map<Integer,String>	map1= new HashMap<Integer,String>();
		
		map1.putAll(map.entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey(), e->e.getValue().toString())));
		System.out.println(map1);
		
		
	}
	
	
	@Test
	public void TC011()
	{
		int number=1234;
		int reverse	=0;
		int remainder=0;
		do {
			remainder=number%10;
			reverse=reverse*10+remainder;
			number=number/10;
		}while(number>0);
		
		System.out.println(reverse);
	}
	
	@Test
	public void TC012()
	{
		int num1=76;
		int num2=12;
		int quotient = 0; 
        while (num1 >= num2) 
        { 
            num1 = num1 - num2 ; 
            quotient++ ; 
        } 
          
        
        System.out.println(quotient); 
        System.out.println(num1);
	}
	
	@Test
	public void TC013()
	{
		 List<String> colors= new ArrayList<String>();
			colors.add("Grey");
			colors.add("Red");
			colors.add("White");
			colors.add("Orange");
			colors.add("Pink");
			colors.add("Blue");
			Comparator<String > cmp= new Comparator<String>() {
				public int compare(String o1,String o2)
				{
					return o1.compareTo(o2);
				}
			};
				Collections.sort(colors,cmp);
				System.out.println("*************");
				colors.forEach(System.out::println);
				
				
				Collections.sort(colors, (a,b)->{
					return a.compareTo(b);
				});
				
				colors.forEach(System.out::println);
	}
	
	@Test
	public void TC014()
	{
		
		Hashtable<Integer,String> table=new Hashtable<Integer,String>();
		
		 List<String> colors= new ArrayList<String>();
			colors.add("Grey");
			colors.add("Red");
			colors.add("White");
			colors.add("Orange");
			colors.add("Pink");
			colors.add("Blue");
			Iterator<String> it=colors.iterator();
			while(it.hasNext())
			{
				if(it.next().equals("Red"));
				{
					it.remove();
				}
				
				System.out.println(it.next());
			}
			
	}
	
	
	@Test
	public void TC015()
	{
		int[][] arrInt = { { 1, 2,3 }, { 4, 21, 7 } ,{ 104, 23, 37 }};
		int maxNumber=1;
		for(int i=0;i<arrInt.length;i++)
		{
			
			for(int j=0;j<arrInt.length;j++)
			{
				if(arrInt[i][j]>maxNumber)
				{
					maxNumber=arrInt[i][j];
				}
			}
		}
		System.out.println(maxNumber);
	}
	
	
	@Test
	public void TC016()
	{
		
		
		List<String> colors= new ArrayList<String>();
		colors.add("Grey");
		colors.add("Red");
		colors.add("White");
		colors.add("Orange");
		colors.add("Pink");
		colors.add("Blue");
		
		Iterator itr=colors.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
       
	}
	
	//@Test
	public void TC017()
	{
		
		for(int i=0;i<1234567889;i++)
		{
		String s= new String("Vijay");
		System.out.println(s);
		}
	}
	
	@Test
	public void hello() {
		String str = "AHCECLWLXO";
		String strNew = "";
		String s[] = str.split("");
		for(int i=0; i<s.length; i=i+2) {
			strNew = strNew + s[i];
		}
		System.out.println(strNew);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
