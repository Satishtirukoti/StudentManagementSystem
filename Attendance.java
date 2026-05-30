public class Attendance {
    private int id;
    private int studentId;
    private String date;
    private String status; // PRESENT or ABSENT

    public Attendance(int studentId, String date, String status) {
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }

    public Attendance(int id, int studentId, String date, String status) {
        this.id = id;
        this.studentId = studentId;
        this.date = date;
        this.status = status;
    }

    public int getId() { return id; }
    public int getStudentId() { return studentId; }
    public String getDate() { return date; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("| %-5d | %-12d | %-12s | %-10s |", id, studentId, date, status);
    }
}
