package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.domain.User;
import de.jonashackt.springbootvuejs.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
                          @RequestParam(required = false, value = "id") Integer id) {

        PrivUser user = new PrivUser (first_name, last_name, id);

        Response response = new Response("200_OK", user);

        return new ResponseEntity(response, new HttpHeaders(), HttpStatus.OK);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path     = "/empty",
                    produces = "application/json",
                    method   = RequestMethod.GET)
    public ResponseEntity<?> simple() {

        PrivUser user = new PrivUser();
        Response response = new Response("200_OK", user);
        return new ResponseEntity(response, new HttpHeaders(), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(path     = "/post/{id}",
                    method   = RequestMethod.POST,
                    consumes = {"application/json;charset=UTF-8"},
                    headers  = {"content-type=application/json;charset=UTF-8"})
    public ResponseEntity<?> add_user(@PathVariable("id") Integer id,
                                      @RequestBody PubUser request){

        PrivUser new_user = new PrivUser(request.firstname, request.lastname, id);

        System.out.println(new_user.getFirstName() +", "+ new_user.getLastName() +", "+ new_user.getId());

        if (request == null){
            System.out.println("Error: request is empty!");
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                       "/user").buildAndExpand(new_user.getId()).toUri();

        return   new ResponseEntity("Resieved a new user", new HttpHeaders(), HttpStatus.OK);
                 //ResponseEntity.created(location).build();
    }

    // @GetMapping(path="/user/{id}")
    // public @ResponseBody User getUserById(@PathVariable("id") long id) {
    //     return userRepository.findOne(id);
    // }

}
