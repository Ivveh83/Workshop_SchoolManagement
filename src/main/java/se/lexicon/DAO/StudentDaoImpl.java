package se.lexicon.DAO;

import se.lexicon.model.Student;

import java.util.ArrayList;

public class StudentDaoImpl {

    private ArrayList<Student> students = new ArrayList<>();

    public Student save(Student student) {
        student.setId();
        students.add(student);
        return student;
    }

    public Student findByEmail(String email) {
        for (Student student : students){
            if (student.getEmail().equals(email)) return student;
        }
        return null;
    }

    public Student findByName(String name) {
        for (Student student : students){
            if (student.getName().equals(name)) return student;
        }
        return null;
    }

    public Student findById(int id) {
        for (Student student : students){
            if (student.getId() == id) return student;
        }
        return null;
    }

    public ArrayList<Student> findAll() {
        return students;
    }

    public boolean delete(Student student) {
        if (students.remove(student)) return true;
        return false;
    }
}
