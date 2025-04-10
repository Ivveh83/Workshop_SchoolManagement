package se.lexicon.DAO;

import se.lexicon.model.Student;

import java.util.ArrayList;

public interface StudentDAO {

    public Student save(Student student);
    public Student findByEmail(String email);
    public Student findByName(String name);
    public Student findById(int id);
    public ArrayList<Student> findAll();
    public boolean delete(Student student);

}
