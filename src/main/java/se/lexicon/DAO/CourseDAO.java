package se.lexicon.DAO;

import se.lexicon.model.Course;

import java.util.ArrayList;

public interface CourseDAO {

    public Course save(Course course);
    public Course findByEmail(String email);
    public Course findByName(String name);
    public Course findById(int id);
    public ArrayList<Course> findAll();
    public boolean delete(Course course);
}
