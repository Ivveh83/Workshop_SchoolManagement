package se.lexicon;

import se.lexicon.DAO.CourseDaoImpl;
import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        ArrayList<Course> courses = new ArrayList<>();
        Course course = new Course("Syslöjd", LocalDate.now(), 10);
        courses.add(course);
        System.out.println(courses);
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.save(course);
        List<Course> arrayList = courseDao.findByName("Syslöjd");
        System.out.println("arrayList: " + arrayList);
        boolean bool = arrayList.add(course);
        System.out.println(bool);
        System.out.println(arrayList);
        for (Course course1 : arrayList){
            System.out.println(course1.getCourseName());
        }

    }

}
