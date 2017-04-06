package com.kingbbode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingbbode.model.Student;
import com.kingbbode.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by YG-MAC on 2017. 3. 28..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AttitudeTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void 학생을_가져와라() throws Exception {
        List<Student> students = studentRepository.findAll();
        assertThat(students.get(0).getName(), is("권용근"));
        assertThat(students.get(1).getName(), is("강홍구"));
        assertThat(students.get(2).getName(), is("김영재"));
    }

    @Test
    public void JACKSON_ObjectMapper_테스트() throws Exception {
        Student student = objectMapper.readValue("{\"name\":\"류광현\"}", Student.class);
        assertThat(student.getName(), is("류광현"));
    }

    @Test
    public void FREEMARKER_테스트() throws Exception {
        ResponseEntity<String> entity = this.testRestTemplate.getForEntity("/",
                String.class);
        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.getBody().contains("권용근"), is(true));
        assertThat(entity.getBody().contains("강홍구"), is(true));
        assertThat(entity.getBody().contains("김영재"), is(true));
    }
}
