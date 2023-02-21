// package ssf.day16lecture;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// import jakarta.json.Json;
// import jakarta.json.JsonArray;
// import jakarta.json.JsonObject;
// import jakarta.json.JsonObjectBuilder;

// @SpringBootApplication
// public class Day16lectureApplication implements CommandLineRunner {

// 	public static void main(String[] args) {
// 		SpringApplication.run(Day16lectureApplication.class, args);
// 	}


// 	@Override
// 	public void run(String ... args) {

// 		JsonObject json = Json.createObjectBuilder()
// 		.add("name", "fred")
// 		.add("email", "fred@gmail.com")
// 		.build();

// 		System.out.printf("++++ json: %s\n", json.toString());

// 		// JsonObjectBuilder jsonBuilder = Json.createObjectBuilder()

// 		// jsonBuilder.add("name", "fred").add("email", "fred@gmail.com");

// 		// JsonObject json = jsonBuilder.build();

// 		// JSON Array Example
// 		JsonArray array = Json.createArrayBuilder()
// 		.add(json)
// 		.add(json)
// 		.build();

// 		System.out.printf("++++ json: %s\n", json.toString());


// 		// JSON String Example
// 		String jsonStr = """
// 			{
// 				"orderId": 1234, "address": 10 Bedrock Ave",
// 				"lineItems": [
// 					{"name": "apple", "quantity": 10},
// 					{"name": "orange", "quantity": 20}
// 				]
// 			}
// 		""";
		
// 		sysout

// 		Reader reader =


// 	}







// }
