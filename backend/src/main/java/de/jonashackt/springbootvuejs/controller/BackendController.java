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
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sun.misc.FormattedFloatingDecimal;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);
    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    @Autowired
    private UserRepository userRepository;
    private final int counter = 1;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path     = "/user",
                    produces = "application/json",
                    method   = RequestMethod.GET)
    public ResponseEntity<?> query(@RequestParam(required = false, value = "fn") String first_name,
                                   @RequestParam(required = false, value = "ln") String last_name,
                                   @RequestParam(required = false, value = "id") long id) {

        User user = new User (id, first_name, last_name);

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
    @RequestMapping(path     = "/post/{id}",
                    method   = RequestMethod.POST,
                    consumes = {"application/json;charset=UTF-8"},
                    headers  = {"content-type=application/json;charset=UTF-8"})
    public ResponseEntity<?> add_user(@PathVariable("id") long id,
                                      @RequestBody Formular request) throws Exception {

        Formular form = new Formular (request.firstName, request.lastName, id);

        User new_user = new User(id, form.firstName, form.lastName);

        System.out.println("resieved json: " + new_user.getFirstName() + ", " + new_user.getLastName() + ", " + new_user.getId());

        if (request == null){
            System.out.println("Error: request is empty!");
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                       "/user").buildAndExpand(new_user.getId()).toUri();

        return   new ResponseEntity("Resieved a new user", new HttpHeaders(), HttpStatus.OK);
                 //ResponseEntity.created(location).build();
    }

    @RequestMapping(path     = "/format/{id}",
                    method   = RequestMethod.POST,
                    consumes = {"application/x-www-form-urlencoded",
                                MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<?> authenticate(@PathVariable("id") long id,
                                          @RequestBody MultiValueMap<String, String> request) throws Exception {

        System.out.println("resieved x-www: " + request.get("familienname") + ", " + request.get("vorname-meines-kindes")+ ", " + id);

        if(request == null) {
            System.out.println("Error: request is empty!");
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity("Resieved a new user", new HttpHeaders(), HttpStatus.OK);
    }

}
