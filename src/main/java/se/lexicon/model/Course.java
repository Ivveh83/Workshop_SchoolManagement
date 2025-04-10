package se.lexicon.model;

import se.lexicon.sequencers.CourseSequencer;

import java.time.LocalDate;
import java.util.ArrayList;

public class Course {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
//        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = CourseSequencer.nextId();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = this.students;
    }

    public void register(Student student){
        students.add(student);
    }

    public void unregister(Student student){
        students.remove(student);
    }
}
