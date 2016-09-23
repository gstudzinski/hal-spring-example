package org.gst.user.repository;

import org.gst.user.model.Role;
import org.gst.user.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by gstudzinski on 9/23/2016.
 */
@Repository
public class DummyUserRepository {

    public User findById(Long id) {
        return createDummyUser();
    }

    private User createDummyUser() {
        User user = new User(1l, "Kowalski");
        user.setRole(new Role("READ_WRITE_PRIVILEGE"));
        return user;
    }

    public User update(Long id, String newName) {
        User user = findById(id);
        user.updateName(newName);
        return user;
    }
}
