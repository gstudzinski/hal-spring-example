package org.gst.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserMockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_have_user_data_links_and_embedded_values() throws Exception {
        // when
        ResultActions result = mockMvc.perform(get("/users/1"));

        // then
        result
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Kowalski"))
            .andExpect(jsonPath("$._links").isNotEmpty())
            .andExpect(jsonPath("$._embedded").isNotEmpty());
    }
}