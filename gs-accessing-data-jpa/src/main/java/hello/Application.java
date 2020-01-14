package hello;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			
			
			ForkJoinPool forkJoinPool = new ForkJoinPool(2);
			long time = System.nanoTime();
			
			Object values = forkJoinPool.submit(() ->
			    //parallel task here, for example
			    IntStream.range(1, 100).parallel().filter(PrimesPrint::isPrime).boxed().collect(Collectors.toList())
			    //.collect(toList())
			).get();
			System.out.println(" time took -->"+(System.nanoTime()-time));
			log.info("values -->"+values);
			
			/*
			 * while(true) { System.out.println("Test"); Thread.sleep(1000); }
			 */
			/*
			 * 
			 * // save a couple of customers repository.save(new Customer("Jack", "Bauer"));
			 * repository.save(new Customer("Chloe", "O'Brian")); repository.save(new
			 * Customer("Kim", "Bauer")); repository.save(new Customer("David", "Palmer"));
			 * repository.save(new Customer("Michelle", "Dessler")); for (int i = 0; i <=
			 * 99; i++) { repository.save(new Customer("Naga Srinivas" + i, "Pothula" + i));
			 * }
			 * 
			 * 
			 * 
			 * // fetch all customers log.info("Customers found with findAll():");
			 * log.info("-------------------------------"); for (Customer customer :
			 * repository.findAll()) { log.info(customer.toString()); } log.info("");
			 * 
			 * // fetch an individual customer by ID
			 * repository.findById(1L).ifPresent(customer -> {
			 * log.info("Customer found with findById(1L):");
			 * log.info("--------------------------------"); log.info(customer.toString());
			 * log.info(""); });
			 * 
			 * // fetch customers by last name
			 * log.info("Customer found with findByLastName('Bauer'):");
			 * log.info("--------------------------------------------");
			 * repository.findByLastName("Bauer").forEach(bauer -> {
			 * log.info(bauer.toString()); }); List<Customer> customers =
			 * repository.findByLastNameLike("Pothula%", null); int offset = 0; int
			 * BATCH_SIZE = 10; for (Customer customerslist : customers) {
			 * System.out.println("customerslist -->" + customerslist);
			 * 
			 * }
			 * 
			 * 
			 * 
			 * List<Customer> customersListdowhile; int loopCounter = 1; do {
			 * System.out.println("offset -->" + offset); Pageable pageable = new
			 * PageRequest(offset, BATCH_SIZE); customersListdowhile =
			 * repository.findByLastNameLike("Pothula%", pageable); for (int i = 0; i <
			 * customersListdowhile.size(); i++) { Customer insideForLoop =
			 * customersListdowhile.get(i); System.out.println("insideForLoop -->" +
			 * insideForLoop.getFirstName()); repository.delete(insideForLoop); } //offset
			 * += BATCH_SIZE; System.out.println("loopCounter -->" + loopCounter +
			 * "<-- Size -->" + customersListdowhile.size()); loopCounter++;
			 * 
			 * } while (customersListdowhile.size() == BATCH_SIZE);
			 * 
			 * // for (Customer bauer : repository.findByLastName("Bauer")) { //
			 * log.info(bauer.toString()); // } log.info(""); customersListdowhile =
			 * repository.findByLastNameLike("Bauer%", null);
			 * System.out.println("customersListdowhile -->"+customersListdowhile);
			 * List<Customer>nagasrinivas90 = customersListdowhile.stream(). filter(customer
			 * -> "Jack".equals(customer.getFirstName())). collect(Collectors.toList());
			 * 
			 * System.out.println("Collection Stream result -->"+nagasrinivas90);
			 */
			/*
			 * List<Customer> holidays = holidayDtos.stream() .filter(h ->
			 * StringUtils.isNotBlank(h.getHolidayDate())) .map(h -> { Holiday holiday = new
			 * Holiday(); holiday.setStoreClosedDate(LocalDate.parse(h.getHolidayDate(),
			 * DATE_FORMATTER_YYMMDD)); holiday.setReasonDescription(h.getHolidayReason());
			 * return holiday; }).collect(Collectors.toList());
			 */
		};
		
		
	}

	

	

}
