package se.lexicon;

import se.lexicon.DAO.CourseDaoImpl;
import se.lexicon.DAO.StudentDaoImpl;
import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    CourseDaoImpl courseDao;
    StudentDaoImpl studentDao;
    Scanner scanner = new Scanner(System.in);

    public App(){
        courseDao = new CourseDaoImpl();
        studentDao = new StudentDaoImpl();
    }

    public static void main(String[] args) {
//        ArrayList<Course> courses = new ArrayList<>();
//        Course course = new Course("Syslöjd", LocalDate.now(), 10);
//        courses.add(course);
//        System.out.println(courses);
////        CourseDaoImpl courseDao = new CourseDaoImpl();
//        app.courseDao.save(course);
//        List<Course> arrayList = app.courseDao.findByName("Syslöjd");
//        System.out.println("arrayList: " + arrayList);
//        boolean bool = arrayList.add(course);
//        System.out.println(bool);
//        System.out.println(arrayList);
//        for (Course course1 : arrayList){
//            System.out.println(course1.getCourseName());
//        }
        App app = new App();
        boolean isRunning = true;

        while (isRunning){
            int choice1 = app.makeChoiceFromGeneralMenu();
            switch (choice1){
                case 0 -> app.registerCourse();
                case 1 -> app.showAllCourses();
                case 2 -> {
                    int choice2 = app.makeChoiceFromShowSpecificCourseMenu();
                    switch (choice2){
                        case 0 -> app.showCourseById();
                        case 1 -> app.showCoursesByName();
                        case 2 -> app.showCoursesByDate();
                    }
                }
                case 8 -> {
                    isRunning = false;
                    app.closeScanner();
                }
            }
        }

    }
    private int makeChoiceFromGeneralMenu(){
        System.out.println("""
        0. Register Course
        1. Show All Courses
        2. Show Specific Courses
        3. Delete Course
        4. Register Student
        5. Show All Students
        6. Show Specific Student 
        7. Delete Student
        8. Exit
        """);
        System.out.print("Enter a number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private void registerCourse(){
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
        courseDao.save(course);
    }

    private void showAllCourses(){
        if (courseDao.findAll().isEmpty()){
            System.out.println("There are no registered Courses");
            return;
        }
        System.out.println("************************************ Courses found  **********************************");
        for (Course course : courseDao.findAll()){
            System.out.println(course);
            System.out.println("--------------------------------------------------------------------------------------");
        }
        System.out.println("**************************************************************************************");
    }

    private int makeChoiceFromShowSpecificCourseMenu(){
        System.out.println("*************** Find Course Menu ******************");
        System.out.println("""
                0. Search Course by Course ID
                1. Search Course(s) by Name
                2. Search Course(s) by Start Date""");
        System.out.println("***************************************************");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private void showCourseById(){
        System.out.print("Enter Course ID: ");
        System.out.println("************************************ Courses found  **********************************");
        System.out.println(courseDao.findById(scanner.nextInt()));
        System.out.println("**************************************************************************************");
    }

    private void showCoursesByName(){
        System.out.print("Enter Course Name: ");
        ArrayList<Course> courses = courseDao.findByName(scanner.nextLine());
        if (courses.isEmpty()){
            System.out.println("There are no registered Courses with that Name");
            return;
        }
        System.out.println("************************************ Courses found  **********************************");
        for (Course course : courses){
            System.out.println(course);
            System.out.println("--------------------------------------------------------------------------------------");
        }
        System.out.println("**************************************************************************************");
    }

    private void showCoursesByDate(){
        System.out.println("You will search by Start Date:");
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Month: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Day: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Course> courses = courseDao.findByDate(LocalDate.of(year, month, day));
        if (courses.isEmpty()){
            System.out.println("There are no registered Courses with that Name");
            return;
        }
        System.out.println("************************************ Courses found  **********************************");
        for (Course course : courses){
            System.out.println(course);
            System.out.println("--------------------------------------------------------------------------------------");
        }
        System.out.println("**************************************************************************************");
    }

    private void closeScanner(){
        scanner.close();
    }

}
