package org.gst.user.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class RoleController {


    @RequestMapping(value = "/role/{privilege}", produces = {HAL_JSON_VALUE, APPLICATION_JSON_VALUE})
    public HttpEntity<String> description(
            @PathVariable(value = "privilege") String privilege) {

        if(privilege.equals("READ_WRITE_PRIVILEGE")) {
            return new ResponseEntity<>("Hello! You can read and write!!", HttpStatus.OK);
        }

        return new ResponseEntity<>("Error! Privilege not found", HttpStatus.NOT_FOUND);

    }
}
