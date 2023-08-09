import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found:\n" + student);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public void displayAllStudents() {
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem managementSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Gather student details and add the student
                    System.out.print("Enter student name: ");
                    scanner.nextLine(); // Consume the newline character left by previous input
                    String name = scanner.nextLine();
            
                    System.out.print("Enter student roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()
            
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
            
                    Student newStudent = new Student(name, rollNumber, grade);
                    managementSystem.addStudent(newStudent);
                    break;
                case 2:
                    // Remove student by roll number
                    System.out.print("Enter student roll number to remove: ");
                    int rollNumberToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    managementSystem.removeStudent(rollNumberToRemove);
                    break;
                case 3:
                    // Search student by roll number
                    System.out.print("Enter student roll number to search: ");
                    int rollNumberToSearch = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    managementSystem.searchStudent(rollNumberToSearch);
                    break;
                case 4:
                    // Display all students
                    managementSystem.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
