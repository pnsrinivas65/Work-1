package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;




public class StreamsVanilla {
    public static final int N = 100;

    static List<Integer> sourceList = new ArrayList<>();
    static {
        for (int i = 0; i < N; i++) {
            sourceList.add(i);
        }
    }

    public List<Double> vanilla() {
        List<Double> result = new ArrayList<>(sourceList.size() / 2 + 1);
        for (Integer i : sourceList) {
            if (i % 2 == 0){
                result.add(Math.sqrt(i));
            }
        }
        return result;
    }

    public List<Double> stream() {
        return sourceList.stream()
                .filter(i -> i % 2 == 0)
                .map(Math::sqrt)
                .collect(Collectors.toCollection(
                    () -> new ArrayList<>(sourceList.size() / 2 + 1)));
    }
    
    public static void main(String s[]) {
    	StreamsVanilla sv = new StreamsVanilla();
    	System.out.println("Vanilla -->"+sv.vanilla());
    	System.out.println("Streams -->"+sv.stream());
    	
    }
}