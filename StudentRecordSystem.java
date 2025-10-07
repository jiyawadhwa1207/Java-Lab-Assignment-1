import java.util.ArrayList;
import java.util.Scanner;

// Base Class
class Person {

    String name;

    Person() {
        this.name = "";
    }

    Person(String name) {
        this.name = name;
    }
}

class Student extends Person {

    int rollNo;
    String course;
    double marks;
    char grade;

    Student() {
        super();
        this.rollNo = 0;
        this.course = "";
        this.marks = 0.0;
        this.grade = 'F';
    }

    Student(int rollNo, String name, String course, double marks) {
        super(name);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    void inputDetails(Scanner sc) {
        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks (0-100): ");
        marks = sc.nextDouble();

        while (marks < 0 || marks > 100) {
            System.out.print("Invalid Marks! Enter again (0-100): ");
            marks = sc.nextDouble();
        }

        calculateGrade();
    }

    void calculateGrade() {
        if (marks >= 85) {
            grade = 'A';
        } else if (marks >= 70) {
            grade = 'B';
        } else if (marks >= 50) {
            grade = 'C';
        } else {
            grade = 'D';
        }
    }

    void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("------------------------");
    }
}

public class StudentRecordSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s = new Student();
                    s.inputDetails(sc);
                    students.add(s);
                    System.out.println("Student Added Successfully!\n");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.\n");
                    } else {
                        System.out.println("===== Student Records =====");
                        for (Student st : students) {
                            st.displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 3);

        sc.close();
    }
}