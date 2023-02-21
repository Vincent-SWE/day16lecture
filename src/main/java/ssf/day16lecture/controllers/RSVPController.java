package ssf.day16lecture.controllers;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@RestController
@RequestMapping(path="/rsvp", produces = MediaType.APPLICATION_JSON_VALUE)
public class RSVPController {

    private Logger logger = Logger.getLogger(RSVPController.class.getName());


    // This below code is done at the last part just before lunch. My typing is incomplete. Go look at chuk's repo

    // application/json
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postAsJson(@RequestBody String payload) {

        logger.log(Level.INFO, "+++ payload %s".formatted(payload));

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject json = reader.readObject();

        String name = json.getString("name");
        boolean attending = json.getBoolean("attending");

        logger.log(Level.INFO
        , ">>> JSON name: %s, attending: %b".formatted(name, attending));

        json = Json.createObjectBuilder()
        .add("message", "Received %s RSVP".formatted(name))
        .add("attending", attending)
        .build();

 
        return ResponseEntity
        .status(201)
        .body(json.toString());
    }
    



    // Assume that we want to consume a standard form and then return JSON
    // application/x-www-form-urlencoded
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> postAsForm (@RequestBody MultiValueMap<String, String> form) {
        String name = form.getFirst("name");
        boolean attending = Boolean.parseBoolean(form.getFirst("attending"));

        logger.log(Level.INFO, ">>> name::%s, attending:%b".formatted(name,attending));

        // 201 Created
        // Content-Type: application/java
        //
        // {"status": "Received <name> RSVP"} sent

        JsonObject payload = Json.createObjectBuilder()
        .add("status", "Received %s RSVP".formatted(name))
        .add("attending", attending)
        .build();

        return ResponseEntity
        .status(201)
        .body(payload.toString());
    }

     
       








    // Ignore the below it was my attempat coding for 201 created
    // // Text/html
    // @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    // public ResponseEntity<String> attendance() {
    //     String status = (new Date()).toString();
    //     return ResponseEntity.status(201)
    //     .header("X-Generated-By", "Spring-Boot")
    //     .body("<h1>201: Received %s RSVP</h1>".formatted(name));




    
 
}
