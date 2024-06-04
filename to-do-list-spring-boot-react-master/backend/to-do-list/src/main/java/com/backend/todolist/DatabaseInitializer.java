import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:./data/todo.db";
        
        String sql = "CREATE TABLE IF NOT EXISTS todos (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " title TEXT NOT NULL,\n"
                + " description TEXT,\n"
                + " completed BOOLEAN NOT NULL CHECK (completed IN (0, 1))\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Database has been initialized.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
