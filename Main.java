import java.util.List;
import java.util.Scanner;

public class Main {
    static StudentDAO studentDAO = new StudentDAO();
    static AttendanceDAO attendanceDAO = new AttendanceDAO();
    static ResultDAO resultDAO = new ResultDAO();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    STUDENT MANAGEMENT SYSTEM         ║");
        System.out.println("║    Developed by Satish Kumar         ║");
        System.out.println("╚══════════════════════════════════════╝");

        while (true) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Student Management");
            System.out.println("2. Attendance Management");
            System.out.println("3. Results Management");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: studentMenu(); break;
                case 2: attendanceMenu(); break;
                case 3: resultMenu(); break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void studentMenu() {
        System.out.println("\n--- STUDENT MANAGEMENT ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: addStudent(); break;
            case 2: viewAllStudents(); break;
            case 3: searchStudent(); break;
            case 4: updateStudent(); break;
            case 5: deleteStudent(); break;
            default: System.out.println("Invalid choice!");
        }
    }

    static void addStudent() {
        sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Branch: "); String branch = sc.nextLine();
        System.out.print("Year: "); int year = sc.nextInt();
        System.out.print("CGPA: "); double cgpa = sc.nextDouble();

        Student s = new Student(name, email, branch, year, cgpa);
        if (studentDAO.addStudent(s))
            System.out.println("✅ Student added successfully!");
        else
            System.out.println("❌ Failed to add student.");
    }

    static void viewAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n| ID    | Name                 | Email                     | Branch | Year | CGPA  |");
        System.out.println("|-------|----------------------|---------------------------|--------|------|-------|");
        for (Student s : students) System.out.println(s);
    }

    static void searchStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        Student s = studentDAO.getStudentById(id);
        if (s != null) System.out.println("\n" + s);
        else System.out.println("Student not found.");
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("New Name: "); String name = sc.nextLine();
        System.out.print("New Email: "); String email = sc.nextLine();
        System.out.print("New Branch: "); String branch = sc.nextLine();
        System.out.print("New Year: "); int year = sc.nextInt();
        System.out.print("New CGPA: "); double cgpa = sc.nextDouble();

        Student s = new Student(id, name, email, branch, year, cgpa);
        if (studentDAO.updateStudent(s))
            System.out.println("✅ Student updated successfully!");
        else
            System.out.println("❌ Failed to update student.");
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        if (studentDAO.deleteStudent(id))
            System.out.println("✅ Student deleted successfully!");
        else
            System.out.println("❌ Failed to delete student.");
    }

    static void attendanceMenu() {
        System.out.println("\n--- ATTENDANCE MANAGEMENT ---");
        System.out.println("1. Mark Attendance");
        System.out.println("2. View Attendance by Student");
        System.out.println("3. View Attendance Percentage");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.print("Student ID: "); int sid = sc.nextInt(); sc.nextLine();
                System.out.print("Date (YYYY-MM-DD): "); String date = sc.nextLine();
                System.out.print("Status (PRESENT/ABSENT): "); String status = sc.nextLine().toUpperCase();
                Attendance a = new Attendance(sid, date, status);
                if (attendanceDAO.markAttendance(a))
                    System.out.println("✅ Attendance marked!");
                else System.out.println("❌ Failed.");
                break;
            case 2:
                System.out.print("Student ID: "); int id2 = sc.nextInt();
                List<Attendance> list = attendanceDAO.getAttendanceByStudent(id2);
                System.out.println("\n| ID    | Student ID   | Date         | Status     |");
                System.out.println("|-------|--------------|--------------|------------|");
                for (Attendance att : list) System.out.println(att);
                break;
            case 3:
                System.out.print("Student ID: "); int id3 = sc.nextInt();
                double pct = attendanceDAO.getAttendancePercentage(id3);
                System.out.printf("Attendance Percentage: %.2f%%%n", pct);
                break;
            default: System.out.println("Invalid choice!");
        }
    }

    static void resultMenu() {
        System.out.println("\n--- RESULTS MANAGEMENT ---");
        System.out.println("1. Add Result");
        System.out.println("2. View Results by Student");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.print("Student ID: "); int sid = sc.nextInt(); sc.nextLine();
                System.out.print("Subject: "); String subject = sc.nextLine();
                System.out.print("Marks (out of 100): "); int marks = sc.nextInt();
                Result r = new Result(sid, subject, marks);
                if (resultDAO.addResult(r))
                    System.out.println("✅ Result added! Grade: " + r.getGrade());
                else System.out.println("❌ Failed.");
                break;
            case 2:
                System.out.print("Student ID: "); int id2 = sc.nextInt();
                List<Result> results = resultDAO.getResultsByStudent(id2);
                System.out.println("\n| ID    | Student ID   | Subject              | Marks  | Grade |");
                System.out.println("|-------|--------------|----------------------|--------|-------|");
                for (Result res : results) System.out.println(res);
                break;
            default: System.out.println("Invalid choice!");
        }
    }
}
