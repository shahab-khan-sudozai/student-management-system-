import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    // List to store student records
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        while (true) {
            // Display menu
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    displayAllStudents();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Method to add a new student
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student roll number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        students.add(new Student(name, rollNumber, grade));
        System.out.println("Student added successfully!");
    }

    // Method to view a student's details
    private static void viewStudent() {
        System.out.print("Enter student roll number: ");
        String rollNumber = scanner.nextLine();
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Method to update a student's details
    private static void updateStudent() {
        System.out.print("Enter student roll number to update: ");
        String rollNumber = scanner.nextLine();
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                System.out.print("Enter new name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter new grade: ");
                student.setGrade(scanner.nextDouble());
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Method to delete a student
    private static void deleteStudent() {
        System.out.print("Enter student roll number to delete: ");
        String rollNumber = scanner.nextLine();
        students.removeIf(student -> student.getRollNumber().equals(rollNumber));
        System.out.println("Student deleted successfully!");
    }

    // Method to search for a student
    private static void searchStudent() {
        System.out.print("Enter student name or roll number: ");
        String searchTerm = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(searchTerm) || student.getRollNumber().equals(searchTerm)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Method to display all students
    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available!");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
