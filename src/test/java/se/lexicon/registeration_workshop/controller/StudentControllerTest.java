package se.lexicon.registeration_workshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import se.lexicon.registeration_workshop.entity.Student;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;//u need to import it

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    private Student student;
    // private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        //objectMapper=new ObjectMapper();
        Student student = new Student();
        student.setFirstName("Aman");
        student.setLastName("A");
        student.setAge(25);
        student.setEmail("59pinkpanda@gmail.com");
        student.setGender("Female");
        student.setRegDate(LocalDateTime.of(2012, 01, 02, 03, 01, 00, 9));
        student.setPhoneNumber("0730922681");

    }

    @Test
    @DisplayName("Test1")
    public void test1_save_student_CREATED() throws Exception {
        String jsonMassage = "{\n" +
                "\"firstName\": \"Sara\",\n" +
                "        \"lastName\": \"Adam\",\n" +
                "        \"age\": 26,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"95pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"0730922633\",\n" +
                "        \"regDate\": \"2003-03-02T00:00:00\",\n" +
                "        \"status\": true\n" +
                "    }";


        // String studentJsonMessage= objectMapper.writeValueAsString(student);
        MvcResult mvcResult = mockMvc.perform(post("/api/student/")
                .content(jsonMassage)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        ).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(201, status);
    }

    @Test
    @DisplayName("Test2")
    public void test2_update_student() throws Exception {
        String jsonMassage = " {\n" +
                "\"firstName\": \"Aman\",\n" +
                "        \"lastName\": \"Adam\",\n" +
                "        \"age\": 25,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"22pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"07309222633\",\n" +
                "        \"regDate\": \"2003-03-02T00:00:00\",\n" +
                "        \"status\": true\n" +
                "    }";
        MvcResult mvcResult = mockMvc.perform(put("/api/student/")
                .content(jsonMassage)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        ).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);

    }
    @Test
    @DisplayName("Test3")
    public void test3_getAll_student() throws Exception {
        String jsonMassage=" {\n" +
                "        \"id\": \"1\",\n" +
                "        \"firstName\": \"Aman\",\n" +
                "        \"lastName\": \"A\",\n" +
                "        \"age\": 25,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"95pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"0730922681\",\n" +
                "        \"regDate\": \"2001-01-01T00:00:00\",\n" +
                "        \"status\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"68966fbf-414b-4372-9b3b-15e07074ab14\",\n" +
                "        \"firstName\": \"Sara\",\n" +
                "        \"lastName\": \"Adam\",\n" +
                "        \"age\": 26,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"95pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"0730922633\",\n" +
                "        \"regDate\": \"2003-03-02T00:00:00\",\n" +
                "        \"status\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"7451a4a5-af88-4719-99a7-809281dd878a\",\n" +
                "        \"firstName\": \"Sara12\",\n" +
                "        \"lastName\": \"Lars\",\n" +
                "        \"age\": 28,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"12pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"0730922623\",\n" +
                "        \"regDate\": \"2012-03-01T00:00:00\",\n" +
                "        \"status\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"7cc4026c-c3fd-4f78-8bfd-49f098252461\",\n" +
                "        \"firstName\": \"Aman\",\n" +
                "        \"lastName\": \"Adam\",\n" +
                "        \"age\": 25,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"22pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"07309222633\",\n" +
                "        \"regDate\": \"2003-03-02T00:00:00\",\n" +
                "        \"status\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"7dcb4a09-f406-40ef-9859-c897f545bafe\",\n" +
                "        \"firstName\": \"Aman\",\n" +
                "        \"lastName\": \"Adam\",\n" +
                "        \"age\": 25,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"22pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"07309222633\",\n" +
                "        \"regDate\": \"2003-03-02T00:00:00\",\n" +
                "        \"status\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"c0ac1a31-96f1-4882-91f6-c7878297a387\",\n" +
                "        \"firstName\": \"Sara12\",\n" +
                "        \"lastName\": \"Lars\",\n" +
                "        \"age\": 28,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"12pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"0730922623\",\n" +
                "        \"regDate\": \"2012-03-01T00:00:00\",\n" +
                "        \"status\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"c77f43f9-ebaa-4720-b186-84b57a4d9bae\",\n" +
                "        \"firstName\": \"Sara\",\n" +
                "        \"lastName\": \"Adam\",\n" +
                "        \"age\": 26,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"95pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"0730922633\",\n" +
                "        \"regDate\": \"2003-03-02T00:00:00\",\n" +
                "        \"status\": true\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"ce48fd4a-fb57-4efe-98f8-d2922ec035ec\",\n" +
                "        \"firstName\": \"Sara12\",\n" +
                "        \"lastName\": \"Lars\",\n" +
                "        \"age\": 28,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"12pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"0730922623\",\n" +
                "        \"regDate\": \"2012-03-01T00:00:00\",\n" +
                "        \"status\": false\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"d494d457-00d0-48f8-8631-2dac0292a924\",\n" +
                "        \"firstName\": \"Sara12\",\n" +
                "        \"lastName\": \"Lars\",\n" +
                "        \"age\": 28,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"email\": \"12pinkpanda@gmail.com\",\n" +
                "        \"phoneNumber\": \"0730922623\",\n" +
                "        \"regDate\": \"2012-03-01T00:00:00\",\n" +
                "        \"status\": false\n" +
                "    }";

        MvcResult mvcResult = mockMvc.perform(get("/api/student/")
                .content(jsonMassage)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        ).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
    }

}

