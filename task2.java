import java.util.*;

public class StudentGradebook {
    static class Student {
        String name;
        String id;
        Map<String, Integer> grades;

        Student(String name, String id) {
            this.name = name;
            this.id = id;
            this.grades = new HashMap<>();
        }

        void addGrade(String subject, int grade) {
            grades.put(subject, grade);
        }

        double calculateAverage() {
            if (grades.isEmpty()) return 0;
            return grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
        }

        void displayGrades() {
            System.out.println("Grades for " + name + " (ID: " + id + "):");
            grades.forEach((subject, grade) -> System.out.println(subject + ": " + grade));
            System.out.println("Average: " + calculateAverage());
        }
    }

    private static final Map<String, Student> students = new HashMap<>();

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        students.put(id, new Student(name, id));
        System.out.println("Student added successfully.");
    }

    private static void addGrade() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = students.get(id);

        if (student != null) {
            System.out.print("Enter subject: ");
            String subject = scanner.nextLine();
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            student.addGrade(subject, grade);
            System.out.println("Grade added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayStudentGrades() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = students.get(id);

        if (student != null) {
            student.displayGrades();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        if (students.remove(id) != null) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Student Gradebook System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Display Student Grades");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    displayStudentGrades();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
