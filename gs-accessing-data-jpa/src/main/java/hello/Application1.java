/*
 * package hello;
 * 
 * import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
 * import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
 * 
 * import java.util.Collections;
 * 
 * import org.springframework.boot.SpringApplication; import
 * org.springframework.boot.autoconfigure.SpringBootApplication; import
 * org.springframework.boot.autoconfigure.http.HttpMessageConverters; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.http.converter.HttpMessageConverter; import
 * org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
 * import org.springframework.web.bind.annotation.ControllerAdvice; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.servlet.mvc.method.annotation.
 * AbstractJsonpResponseBodyAdvice;
 * 
 * import com.fasterxml.jackson.annotation.JsonAutoDetect;
 * 
 * @RestController
 * 
 * @SpringBootApplication class Application1 {
 * 
 * @JsonAutoDetect(fieldVisibility = ANY) static class MyBean { String attr =
 * "demo"; }
 * 
 * @ControllerAdvice static class JsonpAdvice extends
 * AbstractJsonpResponseBodyAdvice { public JsonpAdvice() { super("callback"); }
 * }
 * 
 * @Bean public HttpMessageConverters customConverters() { return new
 * HttpMessageConverters(false, Collections.<HttpMessageConverter<?>
 * >singleton(new MappingJackson2HttpMessageConverter())); }
 * 
 * @RequestMapping MyBean demo() { return new MyBean(); }
 * 
 * @RequestMapping(produces = APPLICATION_JSON_VALUE) String demo2() { return
 * "demo2"; }
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(Application.class, args); } }
 */