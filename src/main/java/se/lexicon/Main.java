package se.lexicon;

import se.lexicon.DAO.CourseDaoImpl;
import se.lexicon.DAO.StudentDaoImpl;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        StudentDaoImpl studentDao = new StudentDaoImpl();
        Student registeredStudent = studentDao.save(new Student("Molgan","molgan@test.com",
                "Adress"));
        System.out.println(registeredStudent.getName());
        System.out.println(studentDao.findAll());
        System.out.println(studentDao.findByEmail("molgan@test.com").getName());
//        System.out.println(studentDao.delete(registeredStudent));
//        System.out.println(studentDao.delete(registeredStudent));

        CourseDaoImpl courseDao = new CourseDaoImpl();
//        Course course = new Course("Syslöjd", LocalDate.now(), 2, studentDao.findAll());
//        System.out.println(courseDao.save(course).getStartDate());

        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning){
            System.out.print("Enter a number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0 -> {
                    System.out.print("Enter name of course: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter a year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter a month: ");
                    int month = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter a day: ");
                    int day = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter number of weeks: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    Course course = new Course(name, LocalDate.of(year, month, day), duration);
                    System.out.println(course);
                }
                case 5 -> {
                    isRunning = false; scanner.close();
                }
            }
        }

    }
    private void registerCourse(){

    }
}