package hello;

import java.util.ArrayList;
import java.util.HashMap;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

@SuppressWarnings("restriction")
public class ObjectSize {
	
	public static void main(String s[]) {
		//System.out.println(ObjectSizeCalculator.getObjectSize(new gnu.trove.map.hash.TObjectIntHashMap<String>(12000, 0.6f, -1)));
		HashMap <String, String> values = new HashMap<String, String>(16);
		values.put("Naga1", "NagaSrinivas1");
		values.put("Naga2", "NagaSrinivas2");
		//values.put("Naga3", "NagaSrinivas3");
		//values.put("Naga4", "NagaSrinivas4");
		int value = 3;
		
		System.out.println("\"Hashmap Size\"+"+ObjectSizeCalculator.getObjectSize(values));
		System.out.println("Int object size value "+ObjectSizeCalculator.getObjectSize(value));
		System.out.println(ObjectSizeCalculator.getObjectSize(new int[]{1, 2, 3, 4, 5, 6, 7 }));
		System.out.println(ObjectSizeCalculator.getObjectSize(new int[100]));
		
		System.out.println("Inter Object "+ ObjectSizeCalculator.getObjectSize(new Integer(10)));
		
		ArrayList <String> aListMemorySize = new ArrayList<String>();
		aListMemorySize.add("Naga Srinivas1");
		aListMemorySize.add("Naga Srinivas2");
		aListMemorySize.add("Naga Srinivas3");
		aListMemorySize.add("Naga Srinivas4");
		System.out.println(ObjectSizeCalculator.getObjectSize(aListMemorySize));
		
	}
	

}
