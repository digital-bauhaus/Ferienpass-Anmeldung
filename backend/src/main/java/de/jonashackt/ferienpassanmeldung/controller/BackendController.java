package de.jonashackt.ferienpassanmeldung.controller;

import de.jonashackt.ferienpassanmeldung.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;



@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(path     = "/register",
                    method   = RequestMethod.POST,
                    consumes = {
                        MediaType.APPLICATION_FORM_URLENCODED_VALUE,
                        MediaType.APPLICATION_JSON_VALUE
                    })
    public String register(@RequestBody Map<String, Object> request) throws Exception {
        return "Recieved POST request to `/api/register`.";
    }

}
