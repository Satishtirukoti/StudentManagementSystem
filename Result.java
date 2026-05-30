public class Result {
    private int id;
    private int studentId;
    private String subject;
    private int marks;
    private String grade;

    public Result(int studentId, String subject, int marks) {
        this.studentId = studentId;
        this.subject = subject;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    public Result(int id, int studentId, String subject, int marks, String grade) {
        this.id = id;
        this.studentId = studentId;
        this.subject = subject;
        this.marks = marks;
        this.grade = grade;
    }

    private String calculateGrade(int marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    public int getId() { return id; }
    public int getStudentId() { return studentId; }
    public String getSubject() { return subject; }
    public int getMarks() { return marks; }
    public String getGrade() { return grade; }

    @Override
    public String toString() {
        return String.format("| %-5d | %-12d | %-20s | %-6d | %-5s |",
                id, studentId, subject, marks, grade);
    }
}
