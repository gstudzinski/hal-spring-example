package org.gst.user.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gst.user.model.Role;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


public class RoleResource extends ResourceSupport {
    @JsonProperty
    private final String privilege;

    private RoleResource(Role role) {
        this.privilege = role.getPrivilege();
    }

    public static RoleResource simpleRoleResource(Role role) {
        return new RoleResource(role);
    }

    public static RoleResource extendedRoleResource(Role role) {
        RoleResource roleResource = new RoleResource(role);
        roleResource.add(linkTo(methodOn(RoleController.class).description(role.getPrivilege())).withRel("description"));
        return roleResource;
    }
}
