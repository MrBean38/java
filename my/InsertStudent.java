
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStudent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:ucanaccess://abc.accdb";

        String insertSQL =
            "INSERT INTO student ([Name], [Email], [Phone]) VALUES (?, ?, ?)";

        try (
            Connection con = DriverManager.getConnection(url);
            PreparedStatement ps = con.prepareStatement(insertSQL);
        ) {

            System.out.print("Enter number of students: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 1; i <= n; i++) {

                System.out.println("\nEnter details of Student " + i);

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Phone: ");
                String phone = sc.nextLine();

                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, phone);

                ps.executeUpdate();

                System.out.println("Student " + i + " inserted successfully!");
            }

            System.out.println("\nAll records inserted successfully.");

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");

        } finally {
            sc.close();
        }
    }
}
