package io.smsc.repository.user;

import io.smsc.model.User;
import io.smsc.AbstractTest;
import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WithMockUser(username = "Admin", roles = {"ADMIN"})
public class UserRestTest extends AbstractTest {

    @Test
    public void testGetSingleUser() throws Exception {
        mockMvc.perform(get("/rest/repository/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is("user")))
                .andExpect(jsonPath("$.firstname", is("userName")))
                .andExpect(jsonPath("$.surname", is("userSurname")))
                .andExpect(jsonPath("$.email", is("user@gmail.com")))
                .andExpect(jsonPath("$.active", is(true)))
                .andExpect(jsonPath("$.blocked", is(false)));
    }

    @Test
    public void testUserNotFound() throws Exception {
        mockMvc.perform(get("/rest/repository/users/999")
                .contentType("application/json;charset=UTF-8"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/rest/repository/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.users", hasSize(2)))
                .andExpect(jsonPath("$._embedded.users[0].username", is("user")))
                .andExpect(jsonPath("$._embedded.users[0].firstname", is("userName")))
                .andExpect(jsonPath("$._embedded.users[0].surname", is("userSurname")))
                .andExpect(jsonPath("$._embedded.users[0].email", is("user@gmail.com")))
                .andExpect(jsonPath("$._embedded.users[0].active", is(true)))
                .andExpect(jsonPath("$._embedded.users[0].blocked", is(false)))
                .andExpect(jsonPath("$._embedded.users[1].username", is("admin")))
                .andExpect(jsonPath("$._embedded.users[1].firstname", is("adminName")))
                .andExpect(jsonPath("$._embedded.users[1].surname", is("adminSurname")))
                .andExpect(jsonPath("$._embedded.users[1].email", is("admin@gmail.com")))
                .andExpect(jsonPath("$._embedded.users[1].active", is(true)))
                .andExpect(jsonPath("$._embedded.users[1].blocked", is(false)));
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setUsername("Old Johnny");
        user.setFirstname("John");
        user.setSurname("Forrester");
        user.setEmail("john@gmail.com");
        user.setActive(true);
        user.setBlocked(false);
        String userJson = json(user);
        // json is ignoring password
        userJson = userJson.substring(0, userJson.length() - 1).concat(", \"password\" : \"john123456\" \r\n }");
        this.mockMvc.perform(post("/rest/repository/users")
                .contentType("application/json;charset=UTF-8")
                .content(userJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/rest/repository/users/1"));
        mockMvc.perform(get("/rest/repository/users/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUsername("Old Johnny");
        user.setFirstname("John");
        user.setSurname("Forrester");
        user.setEmail("john@gmail.com");
        user.setActive(false);
        user.setBlocked(true);
        String userJson = json(user);
        // json is ignoring password
        userJson = userJson.substring(0, userJson.length() - 1).concat(", \"password\" : \"john123456\" \r\n }");
        mockMvc.perform(put("/rest/repository/users/1")
                .contentType("application/json;charset=UTF-8")
                .content(userJson))
                .andExpect(status().isOk());
        mockMvc.perform(get("/rest/repository/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is("Old Johnny")))
                .andExpect(jsonPath("$.firstname", is("John")))
                .andExpect(jsonPath("$.surname", is("Forrester")))
                .andExpect(jsonPath("$.email", is("john@gmail.com")))
                .andExpect(jsonPath("$.active", is(false)))
                .andExpect(jsonPath("$.blocked", is(true)));
    }
}
