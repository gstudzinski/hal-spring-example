package org.gst.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserTraversonIntegrationTests {

    @LocalServerPort
    private int port;

    @Test
    public void should_find_update_link_and_call_update_url() throws Exception {
        // given
        Traverson traverson = new Traverson(new URI("http://localhost:" + this.port + "/users/1"), MediaTypes.HAL_JSON);

        // when
        String newName = traverson.follow("update").toObject("$.name");

        // then
        assertThat(newName).isEqualTo("newName");
    }
}