package org.gst.user.model;

public class Role  {

    private final String privilege;

    public Role(String privilege) {
        this.privilege = privilege;
    }

    public String getPrivilege() {
        return privilege;
    }
}
