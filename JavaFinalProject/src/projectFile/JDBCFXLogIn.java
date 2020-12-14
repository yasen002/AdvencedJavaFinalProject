/*Author: Abudikeranmu Yasen      ID:1672199
 *Author: Amanuel Reda            ID:1659663
 *Date: 12/13/2020
 *Sponser: SMC 2020 Fall CS56 
 *File description: A JDBCFXLogIn class that extends a Utilities class for the purpuse of validates users log in credentials 
 */
package projectFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCFXLogIn extends Utilities{

    // Replace below database url, username and password with your actual database credentials

    private static final String DATABASE_URL = "jdbc:mysql://localhost:1527/projectFile?useSSL=false";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "admin";
    private static final String SELECT_QUERY = "SELECT * FROM Users WHERE userName = ? and password = ?";

    public boolean validate(String userName, String password) throws SQLException {
         boolean flag =false;
        //  Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
            .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            //Create a statement using connection 
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                flag = true;
            }


        } catch (SQLException e) {
            // print SQL exception information
            //printSQLException(e);//                      //explain
            return validateThroughFile(userName,password); // validation of a login from file 

        }
        return flag;
    }

public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
