package io.smsc.repository.customerUser;

import io.smsc.AbstractTest;
import io.smsc.model.CustomerUser;
import io.smsc.model.User;
import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser(username = "Admin", roles = {"ADMIN"})
public class CustomerUserRestTest extends AbstractTest {

    @Test
    public void testGetSingleCustomerUser() throws Exception {
        mockMvc.perform(get("/rest/repository/customer-users/1"))
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
        mockMvc.perform(get("/rest/repository/customer-users/999")
                .contentType("application/json;charset=UTF-8"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/rest/repository/customer-users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.customer-users", hasSize(2)))
                .andExpect(jsonPath("$._embedded.customer-users[0].username", is("user")))
                .andExpect(jsonPath("$._embedded.customer-users[0].firstname", is("userName")))
                .andExpect(jsonPath("$._embedded.customer-users[0].surname", is("userSurname")))
                .andExpect(jsonPath("$._embedded.customer-users[0].email", is("user@gmail.com")))
                .andExpect(jsonPath("$._embedded.customer-users[0].active", is(true)))
                .andExpect(jsonPath("$._embedded.customer-users[0].blocked", is(false)))
                .andExpect(jsonPath("$._embedded.customer-users[1].username", is("admin")))
                .andExpect(jsonPath("$._embedded.customer-users[1].firstname", is("adminName")))
                .andExpect(jsonPath("$._embedded.customer-users[1].surname", is("adminSurname")))
                .andExpect(jsonPath("$._embedded.customer-users[1].email", is("admin@gmail.com")))
                .andExpect(jsonPath("$._embedded.customer-users[1].active", is(true)))
                .andExpect(jsonPath("$._embedded.customer-users[1].blocked", is(false)));
    }

    @Test
    public void testCreateUser() throws Exception {
        CustomerUser customerUser = new CustomerUser();
        customerUser.setUsername("Old Johnny");
        customerUser.setFirstname("John");
        customerUser.setSurname("Forrester");
        customerUser.setEmail("john@gmail.com");
        customerUser.setActive(true);
        customerUser.setBlocked(false);
        String customerUserJson = json(customerUser);
        // json is ignoring inserting password and customer through setter
        customerUserJson = customerUserJson.substring(0, customerUserJson.length() - 1).concat(", \"password\" : \"john123456\", \"customer\" : \"rest/repository/customers/40000\" \r\n }");
        this.mockMvc.perform(post("/rest/repository/users")
                .contentType("application/json;charset=UTF-8")
                .content(customerUserJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/rest/repository/customer-users/1"));
        mockMvc.perform(get("/rest/repository/customer-users/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateUser() throws Exception {
        CustomerUser customerUser = new CustomerUser();
        customerUser.setId(1L);
        customerUser.setUsername("Old Johnny");
        customerUser.setFirstname("John");
        customerUser.setSurname("Forrester");
        customerUser.setEmail("john@gmail.com");
        customerUser.setActive(false);
        customerUser.setBlocked(true);
        String customerUserJson = json(customerUser);
        // json is ignoring password
        customerUserJson = customerUserJson.substring(0, customerUserJson.length() - 1).concat(", \"password\" : \"john123456\" \r\n }");
        mockMvc.perform(put("/rest/repository/customer-users/1")
                .contentType("application/json;charset=UTF-8")
                .content(customerUserJson))
                .andExpect(status().isOk());
        mockMvc.perform(get("/rest/repository/customer-users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is("Old Johnny")))
                .andExpect(jsonPath("$.firstname", is("John")))
                .andExpect(jsonPath("$.surname", is("Forrester")))
                .andExpect(jsonPath("$.email", is("john@gmail.com")))
                .andExpect(jsonPath("$.active", is(false)))
                .andExpect(jsonPath("$.blocked", is(true)));
    }
}
