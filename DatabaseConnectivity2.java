
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectivity2 {
    
    public static void main(String []args)
    {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        
        try {
            // Step 1: To load and register Driver class.

            Class.forName("com.mysql.cj.jdbc.Driver");



            // Step 2: To establish the connection with database
            // url = protocol_name:db_engine_name://ip_addr:port_no/db_name

            String url="jdbc:mysql://localhost:3306/student";
            String user="root";
            String password="root123";
            connection = DriverManager.getConnection(url, user, password);

            //Step 3: Create a statement

            statement = connection.createStatement();

            //Step 4: Execute query and store result of it

            String query="SELECT * FROM STUDENTS";
            resultSet = statement.executeQuery(query);


            // Step 5: Proces the ResultSet object
            while(resultSet.next())
            {
                int sid=resultSet.getInt("sid");
                String name=resultSet.getString("name");
                String country=resultSet.getString("country");
                System.out.println("Sid :"+sid+"Name :"+name+"Country :"+country);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{

            // Step 6: Close all resources
            if(resultSet!=null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    
                    e.printStackTrace();
                }

            if(statement!=null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            if(connection!=null)
                try {
                    connection.close();
                } catch (SQLException e) {
                
                    e.printStackTrace();
                }

        }




    }
    
}
