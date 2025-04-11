package se.lexicon.DAO;

import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;

public interface CourseDAO {

    public Course save(Course course);
    public ArrayList<Course> findByName(String name);
    public Course findById(int id);
    public ArrayList<Course> findByDate(LocalDate date);
    public ArrayList<Course> findAll();
    public boolean delete(Course course);
}
