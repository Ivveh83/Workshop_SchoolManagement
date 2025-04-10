package se.lexicon.DAO;

import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;

public class CourseDaoImpl {

    private ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Course save(Course course) {
        course.setId();
        courses.add(course);
        return course;
    }

    public Course findByName(String name) {
        for (Course course : courses){
            if (course.getCourseName().equals(name)) return course;
        }
        return null;
    }

    public Course findById(int id) {
        for (Course course : courses){
            if (course.getId() == id) return course;
        }
        return null;
    }

    public Course findByDate(LocalDate date){
        for (Course course : courses){
            if (course.getStartDate() == date) return course;
        }
        return null;
    }

    public ArrayList<Course> findAll() {
        return getCourses();
    }

    public boolean delete(Course course) {
        if (courses.remove(course)) return true;
        return false;
    }
}
