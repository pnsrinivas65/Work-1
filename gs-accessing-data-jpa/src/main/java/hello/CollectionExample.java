package hello;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class CollectionExample {

	
	public static void main(String s[]) {
		Collection<String> list = new ArrayList<String>();
		
		list.add("ABC");
		list.add("AZC");
		list.add("CBC");
		list.add("CBG");
		list.add("DEF");
		list.add("ZFC");
		
		//list.stream().filter(ll -> list.forEach(action);
		       // .noneMatch(v -> comparator.compare(v,value)<0));
		
		Collection<Product> products = new ArrayList<Product>();
		Product apple = new Product("Apple", ProductType.APPLE, new BigDecimal(10));
		Product ban = new Product("Apple", ProductType.BANANA, new BigDecimal(100));
		Product pear = new Product("Apple", ProductType.PEAR, new BigDecimal(200));
		Product apple2 = new Product("Apple", ProductType.APPLE, new BigDecimal(300));
		
		products.add(apple);
		products.add(ban);
		products.add(pear);
		products.add(apple2);
		
		String test = "INIT";
		
		JobDto dto1 = getDto("INIT", QueueName.QBATCH);
		JobDto dto2 = getDto("CHKHOLDAY", QueueName.QBATCH);
		JobDto dto3 = getDto("SUPR003", QueueName.CBATCH);
		JobDto dto4 = getDto("AIMREV25", QueueName.DEFAULT);
		JobDto dto5 = getDto("AIMREV25", QueueName.DEFAULT);
		JobDto dto6 = getDto("RAINCHK", QueueName.QBATCH);
		JobDto dto7 = getDto("TAXEXPEMT", QueueName.NBATCH);
		JobDto dto8 = getDto("EXPEMT", QueueName.NBATCH);
		
		//List<Product> filterSortedProdycts = 
			//    products.stream()
			  //          .filter(p -> p.getType().toString().compareTo(test)>=0)  
			    //        .sorted(Comparator.comparing(Product::getPrice)) 
			      //      .collect(Collectors.toList());
		Collection<JobDto> jobs = new ArrayList<JobDto>();
		jobs.add(dto1);
		jobs.add(dto2);
		jobs.add(dto3);
		jobs.add(dto4);
		jobs.add(dto5);
		jobs.add(dto6);
		jobs.add(dto7);
		jobs.add(dto8);
		
		List<JobDto> filterSortedJobs = 
				jobs.stream()
			            .filter(p -> p.getName().toString().compareTo(test)>=0)  
			            .sorted(Comparator.comparing(JobDto::getName)) 
			            .collect(Collectors.toList());
		/*
		 * jobs = jobs.stream().sorted(Comparator.comparing(JobDto::getName)
		 * .thenComparing(JobDto::getPriority)) .collect(Collectors.toList());
		 */
		//System.out.println("filterSortedProdycts --> "+filterSortedProdycts+"apple -->"+apple.getType().toString().charAt(0));
	
		filterSortedJobs.forEach(System.out::println);
		
		//Arrays.stream(QueueName.values()).forEach(QueueName::name);
		List<QueueDto> queueDtos = new ArrayList<>();
		Arrays.stream(QueueName.values()).forEachOrdered(queueName ->queueDtos.add(getQueueDto(queueName)));
        System.out.println("queueDtos --> "+queueDtos);
	
	}
	
	private static QueueDto getQueueDto(QueueName name) {
        QueueDto dto = new QueueDto(name);
        return dto;
    }

	
	private static JobDto getDto(String jobName, QueueName queuename ) {
		JobDto dto = new JobDto(jobName, queuename);
		return dto;
	}
	
	
}
