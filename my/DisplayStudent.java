import java.sql.*;

public class DisplayStudent {

    public static void main(String[] args) {

        String url = "jdbc:ucanaccess://abc.accdb";

        try {
            Connection con = DriverManager.getConnection(url);

            String query = "SELECT Name, Email, Phone FROM student";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Name\t\tEmail\t\t\tPhone");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {

                String name = rs.getString("Name");
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");

                System.out.println(name + "\t" + email + "\t" + phone);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}