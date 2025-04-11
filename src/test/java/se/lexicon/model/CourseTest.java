package se.lexicon.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void testCreateCourse() {
        // expected result
        int id = 0;
        String courseName = "Syslöjd";
        LocalDate startDate = LocalDate.now();
        int weekDuration = 10;


        Course course = new Course("Syslöjd", LocalDate.now(), 10);

        Assertions.assertEquals(id, course.getId());
        Assertions.assertEquals(courseName, course.getCourseName());
        Assertions.assertEquals(startDate, course.getStartDate());
        Assertions.assertEquals(weekDuration, course.getWeekDuration());

    }
}