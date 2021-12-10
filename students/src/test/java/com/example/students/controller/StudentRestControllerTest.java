package com.example.students.controller;


import com.example.students.entity.Student;
import com.example.students.services.LectureServiceImpl;
import com.example.students.services.StudentServiceImpl;
import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(StudentRestController.class)
public class StudentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentServiceImpl studentService;

    @MockBean
    LectureServiceImpl lectureService;

    @Test
    public void testHello() throws Exception {
        this.mockMvc.perform(get("/MySpringBootWeb/hello"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testHello2() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/MySpringBootWeb/hello"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testResponseFromHello() throws Exception {
        this.mockMvc.perform(get("/MySpringBootWeb/hello"))
                .andExpect(content().string("Hello"));
    }




    @Test
    public void testValidationOfStudents() throws Exception {
        Student w1 = new Student(6L, "ahmet");
        Student w2 = new Student(7L, "mehmet");

        doReturn(Lists.newArrayList(w1, w2)).when(studentService).findAllStudents();
        mockMvc.perform(get("/MySpringBootWeb/students"))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }


    @Test
    public void testValuesFromStudents() throws Exception {
        Student w1 = new Student(6L, "ahmet");
        List<Student> allstudents = Arrays.asList(w1);

        Mockito.when(studentService.findAllStudents()).thenReturn(allstudents);

        mockMvc.perform(get("/MySpringBootWeb/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].studentName", Matchers.is("ahmet")));
    }



}

