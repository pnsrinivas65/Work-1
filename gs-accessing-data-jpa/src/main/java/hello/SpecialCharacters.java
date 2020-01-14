package hello;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SpecialCharacters {

	public static void main(String[] args) {
		String array [] = {"1","#","$","%","&","*","!","2","3","5","6","@","8","9","?","7","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
				
		};
		
		System.out.println(Charset.isSupported("IBM1047"));
		Charset encoding = Charset.forName("IBM1047");
		//Comparator<String> encComparator = (s1, s2) -> encoding.encode(s1).compareTo(encoding.encode(s2));
		Comparator<String> ebcdicComparator1 = (string1, string2) -> new String(string1.getBytes(encoding))
				.compareTo(new String(string2.getBytes(encoding)));
		Arrays.sort(array, (string1, string2) -> new String(string1.getBytes(encoding))
				.compareTo(new String(string2.getBytes(encoding))));
//		System.out.println(Arrays.toString(array));
		for (String string : array) {
			System.out.print(string+",");
			
		}
		List <String> list = new ArrayList<String>();
		list.add("A");
		list.add("2");
		list.add("C");
		list.add("a");
		list.add("c");
		
		list.sort(Comparator.comparing(String::toString));
		
		list.forEach(s->System.out.println(s));
		
		/*
		 * String str =
		 * "1,!,$,*,%,#,@,A,B,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,&,2,3,5,6,7,8,9";
		 * Charset ebcdicCharset = Charset.forName("IBM1047");// IBM037,IBM1047
		 * Comparator<String> ebcdicComparator = (string1, string2) -> new
		 * String(string1.getBytes(ebcdicCharset)) .compareTo(new
		 * String(string2.getBytes(ebcdicCharset))); List<String> list =
		 * Arrays.asList(str.split(","));
		 * 
		 * 
		 * //list.stream().sorted(((string1, string2) -> new
		 * String(string1.getBytes(ebcdicCharset)) // .compareTo(new
		 * String(string2.getBytes(ebcdicCharset))))).collect(Collectors.toList());
		 * //Collections.sort(list, Comparator.comparing(string1 -> new
		 * String(str).getBytes(ebcdicCharset))); //string ->
		 * ebcdicCharset.encode(string))); list.sort(ebcdicComparator); list.forEach(s
		 * -> System.out.println(s));
		 */
		
		/*
		 * try { byte[] ebcdicData = "Some Text Value".getBytes("Cp037"); for (byte b :
		 * ebcdicData) { System.out.print(b+",");
		 * 
		 * } } catch (UnsupportedEncodingException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */
		
			 
			 


	}

}
