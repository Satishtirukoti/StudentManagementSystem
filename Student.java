public class Student {
    private int id;
    private String name;
    private String email;
    private String branch;
    private int year;
    private double cgpa;

    // Constructor
    public Student(int id, String name, String email, String branch, int year, double cgpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.year = year;
        this.cgpa = cgpa;
    }

    public Student(String name, String email, String branch, int year, double cgpa) {
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.year = year;
        this.cgpa = cgpa;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }

    @Override
    public String toString() {
        return String.format("| %-5d | %-20s | %-25s | %-6s | %-4d | %-5.2f |",
                id, name, email, branch, year, cgpa);
    }
}
