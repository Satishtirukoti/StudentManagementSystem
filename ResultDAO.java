import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO {

    public boolean addResult(Result result) {
        String sql = "INSERT INTO results (student_id, subject, marks, grade) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, result.getStudentId());
            ps.setString(2, result.getSubject());
            ps.setInt(3, result.getMarks());
            ps.setString(4, result.getGrade());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding result: " + e.getMessage());
            return false;
        }
    }

    public List<Result> getResultsByStudent(int studentId) {
        List<Result> list = new ArrayList<>();
        String sql = "SELECT * FROM results WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Result(
                    rs.getInt("id"),
                    rs.getInt("student_id"),
                    rs.getString("subject"),
                    rs.getInt("marks"),
                    rs.getString("grade")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching results: " + e.getMessage());
        }
        return list;
    }
}
