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

}

