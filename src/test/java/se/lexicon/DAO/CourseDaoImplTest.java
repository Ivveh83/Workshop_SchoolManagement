package se.lexicon.DAO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseDaoImplTest {

    @Test
    void save() {
        /*course.setId();
        courses.add(course);
        return course;*/
        Course course = new Course("Syslöjd", LocalDate.now(), 10);
        course.setId();

        CourseDaoImpl courseDao = new CourseDaoImpl();
        Course course1 = courseDao.save(course);

        Assertions.assertEquals(course, course1);
    }

    /*public Course findByName(String name) {
        for (Course course : courses){
            if (course.getCourseName().equals(name)) return course;
        }
        return null;
    }*/
    @Test
    void findByNameTest() {
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("Syslöjd", LocalDate.now(), 10);
        courses.add(course);
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> arrayList = courseDao.findByName("Syslöjd");

        Assertions.assertEquals(courses, arrayList);
    }

}