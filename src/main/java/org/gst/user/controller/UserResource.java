package org.gst.user.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gst.base.HALResource;
import org.gst.user.model.User;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class UserResource extends HALResource {

    @JsonProperty
    private final Long id;
    @JsonProperty
    private final String name;

    private UserResource(User user) {
        id = user.getId();
        name = user.getName();
    }

    public static UserResource simpleUserResource(User user) {
        return new UserResource(user);
    }

    public static UserResource fullUserResource(User user) {
        UserResource userResource = new UserResource(user);
        userResource.embedResource("role", RoleResource.extendedRoleResource(user.getRole()));
        userResource.add(linkTo(methodOn(UserController.class).find(user.getId())).withSelfRel());
        userResource.add(linkTo(methodOn(UserController.class).update(user.getId(), "newName")).withRel("update"));
        return userResource;
    }



}
