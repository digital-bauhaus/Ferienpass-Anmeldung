package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.domain.User;
import de.jonashackt.springbootvuejs.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;



@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/all/users")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    List<User> showAllUsers() {
        LOG.info("GET called on /all resource");
        return userRepository.findAllUsers();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path     = "/user",
                    produces = "application/json",
                    method   = RequestMethod.GET)
    public ResponseEntity<?> query(@RequestParam(required = false, value = "fn") String first_name,
                                   @RequestParam(required = false, value = "ln") String last_name) {

        User user = new User (first_name, last_name);

        Response response = new Response("200_OK", user);

        return new ResponseEntity(response, new HttpHeaders(), HttpStatus.OK);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path     = "/empty",
                    produces = "application/json",
                    method   = RequestMethod.GET)
    public ResponseEntity<?> simple() {

        User user = new User();
        Response response = new Response("200_OK", user);
        return new ResponseEntity(response, new HttpHeaders(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(path     = "/post",
                    method   = RequestMethod.POST,
                    consumes = {"application/json;charset=UTF-8"},
                    headers  = {"content-type=application/json;charset=UTF-8"})
    public ResponseEntity<?> add_user(@RequestBody Formular request) throws Exception {

        Formular form = new Formular (request.firstName, request.lastName);

        User new_user = new User(form.firstName, form.lastName);

        System.out.println("resieved json: " + new_user.getFirstName() + ", " + new_user.getLastName());

        if (request == null){
            System.out.println("Error: request is empty!");
            return ResponseEntity.noContent().build();
        }

        userRepository.save(new_user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                       "/user").buildAndExpand(new_user.getId()).toUri();

        return   new ResponseEntity("Resieved a new user", new HttpHeaders(), HttpStatus.OK);
                 //ResponseEntity.created(location).build();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(path     = "/register",
                    method   = RequestMethod.POST,
                    consumes = {
                        MediaType.APPLICATION_FORM_URLENCODED_VALUE,
                        MediaType.APPLICATION_JSON_VALUE
                    })
    public ResponseEntity<?> register(@RequestBody Map<String, Object> request) throws Exception {

        System.out.println("recieved: " + request.get("familienname") + ", " + request.get("vorname-meines-kindes"));

        if (request == null) {
            System.out.println("Error: request is empty!");
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity("Resieved a new user", new HttpHeaders(), HttpStatus.OK);
    }

}
