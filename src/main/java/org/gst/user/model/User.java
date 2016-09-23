package org.gst.user.model;

public class User  {
    private final Long id;
    private String name;
    private Role role;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void updateName(String newName) {
        this.name = newName;
    }
}
