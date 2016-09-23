package org.gst.user.controller;

import org.gst.user.model.User;
import org.gst.user.repository.DummyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private DummyUserRepository dummyUserRepository;

    @RequestMapping(value = "/{id}", produces = {HAL_JSON_VALUE, APPLICATION_JSON_VALUE} )
    public HttpEntity<UserResource> find(@PathVariable("id") Long id) {
        User user = dummyUserRepository.findById(id);

        return new ResponseEntity<>(UserResource.fullUserResource(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/update", produces = {HAL_JSON_VALUE, APPLICATION_JSON_VALUE})
    public HttpEntity<UserResource> update(@PathVariable("id") Long id, @RequestParam(name = "newName") String newName) {
        User user = dummyUserRepository.update(id, newName);

        return new ResponseEntity<>(UserResource.fullUserResource(user), HttpStatus.OK);
    }


}
