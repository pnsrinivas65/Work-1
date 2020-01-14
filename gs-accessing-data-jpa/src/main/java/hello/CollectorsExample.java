package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsExample {

	private List<Golfer> golfers = Arrays.asList(
		    new Golfer("REL", "Nicklaus", 2),
		    new Golfer("SCH", "Woods", 3),
		    new Golfer("HLD", "Watson", 2),
		    new Golfer("REL", "Webb", 1),
		    new Golfer("SCH", "Watson", 2)
		);
	
	public List<Golfer> sortByScoreThenLastThenFirst() {
	    return golfers.stream()
	    	
	        .sorted(Comparator.comparing(Golfer::getFirst)
	                    //.thenComparing(Golfer::getLast)
	        		.thenComparing(Golfer::getScore))
	        
	        
	        //.collect(Collectors.groupingBy(Golfer::getFirst))
	        //.collect(Collectors.toList());
	        .collect(Collectors.toList());
	    
	}
	public static void main(String s[]) {
		List<BlogPost> posts = Arrays.asList();
		System.out.println("Here --> "+new CollectorsExample().sortByScoreThenLastThenFirst());
		// Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
		// .collect(groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));

		// Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
		// .collect(groupingBy(BlogPost::getType));

		// 3 apple, 2 banana, others 1
		//List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		//Map<String, Long> result = items.stream()
			//	.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		//System.out.println(result);
		
		Record r1 = new Record("REL", 1);
		Record r2 = new Record("SCH", 1);
		Record r3 = new Record("HLD", 1);
		Record r4 = new Record("REL", 5);
		Record r5 = new Record("SCH", 4);
		Record r6 = new Record("HLD", 3);
		
		ArrayList<Record> records = new ArrayList<Record>();
		records.add(r1);
		records.add(r2);
		records.add(r3);
		records.add(r4);
		records.add(r5);
		records.add(r6);
		
		Map<String, List<Record>> result = records.stream()
			    .collect(Collectors.groupingBy(Record::getName));
		//System.out.println("result --> "+result);
		//List<Record> result = records.stream()
				//.sorted(
			    //.sorted(comparingInt(Record::getPriority).reversed())
			    //.collect(groupingBy(Record::getName, LinkedHashMap::new, toList()))
			    //.values().stream()
			    //.flatMap(Collection::stream)
			    //.collect(toList());
	
		
		Student s3 = new Student(1728, "John3", Status.HLD);
		Student s1 = new Student(1726, "John1", Status.RLS);
		Student s2 = new Student(1727, "John2", Status.SCD);
		
		Student s4 = new Student(1725, "John4", Status.HLD);
		Student s5 = new Student(1724, "John5", Status.SCD);
		Student s6 = new Student(1723, "John6", Status.RLS);
		Student s7 = new Student(1722, "John7", Status.HLD);
		Student s8 = new Student(1729, "John8", Status.SCD);
		Student s9 = new Student(1730, "John9", Status.SCD);
		

		Collection<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		students.add(s7);
		//students.add(s7);
		students.add(s8);
		students.add(s9);
		
		
		//first, use your function to group students
		Map<Status, List<Student>> studlistGrouped = students.stream()
		        .collect(Collectors.groupingBy(Student::getStatus, Collectors.toList()));

		//then sort groups by minimum id in each of them
		List<Student> sorted = studlistGrouped.entrySet().stream()
		        .sorted(Comparator.comparing(e -> e.getValue().stream().map(Student::getId).min(Comparator.naturalOrder()).orElse(0)))
		        //and also sort each group before collecting them in one list
		        .flatMap(e -> e.getValue().stream().sorted(Comparator.comparing(Student::getId))).collect(Collectors.toList());
		System.out.println("sorted --> "+sorted);	
		
		List<Student> sortedListFirst = students.stream()
		.sorted(Comparator.comparing(Student::getStatus)
				.thenComparing(Student::getId))
		.collect(Collectors.toList());
		
		System.out.println("sortedListFirst 1-->"+sortedListFirst);
		sortedListFirst = sortedListFirst.stream().sorted(Comparator.comparing(Student::getStatus))
				.collect(Collectors.toList());
				System.out.println("sortedListFirst 2-->"+sortedListFirst);
		//Map<Status, List<Student>> groupByName = sortedListFirst.stream()
		//.collect(Collectors.groupingBy(Student::getStatus));
		//System.out.println("groupByName 1-->"+groupByName);
		//.collect(Collectors.groupingBy(Student::getLast, Collectors.toList()));
		//System.out.println("groupByName 1-->"+groupByName.get(Status.SCD));
		//System.out.println("groupByName 2-->"+groupByName.get(Status.RLS));
		//System.out.println("groupByName 3-->"+groupByName.get(Status.HLD));
		
		
	
		//List<Student> sortedGroupBy = new LinkedList();
		//sortedGroupBy.addAll((groupByName.get(Status.RLS)));
		//sortedGroupBy.addAll((groupByName.get(Status.SCD)));
		//sortedGroupBy.addAll((groupByName.get(Status.HLD)));
		//System.out.println("sortedGroupBy -->"+sortedGroupBy);
		
		
		
		Map<Integer, List<Status>> collect = 
				students.stream()
			           .collect(Collectors.groupingBy(
			               Student::getId,
			               Collectors.mapping(Student::getStatus, Collectors.toList()))
			           );
		System.out.println("collect -->"+collect);
		
		students.stream().collect(
			     Collectors.groupingBy(
			         Student::getStatus));
			         //() -> new EnumMap<Status, Integer>(Status.class),
			         //Collectors.summingInt(Student::getId)));
		
	}
	
	

}

class Tuple {
	BlogPostType type;
	String author;
}

class BlogPost {
	String title;
	String author;
	BlogPostType type;
	int likes;
}



/*
 * class Record {
 * 
 * public Record(String status, int priority) { this.status=status;
 * this.priority=priority; } String status;
 * 
 * int priority;
 * 
 * public int getPriority() { return priority; }
 * 
 * public String getStatus() { return status; } }
 */

enum BlogPostType {
	NEWS, REVIEW, GUIDE
}
