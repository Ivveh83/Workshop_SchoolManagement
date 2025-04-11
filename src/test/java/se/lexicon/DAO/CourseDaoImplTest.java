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

        Course course = new Course("Syslöjd", LocalDate.now(), 10);
        course.setId();

        CourseDaoImpl courseDao = new CourseDaoImpl();
        Course course1 = courseDao.save(course);

        Assertions.assertEquals(course, course1);
    }

    @Test
    void findByNameTest() {
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("Syslöjd", LocalDate.now(), 10);
        courses.add(course);
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.save(course);
        ArrayList<Course> arrayList = courseDao.findByName("Syslöjd");

        Assertions.assertEquals(courses, arrayList);
    }

    @Test
    void findByDateTest() {
        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("Syslöjd", LocalDate.now(), 10);
        courses.add(course);
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.save(course);
        ArrayList<Course> arrayList = courseDao.findByDate(LocalDate.now());

        Assertions.assertEquals(courses, arrayList);
    }

    @Test
    void findByIdTest() {
        Course course = new Course("Syslöjd", LocalDate.now(), 10);
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.save(course);
        Course course1 = courseDao.findById(5);

        Assertions.assertEquals(course, course1);
    }

}