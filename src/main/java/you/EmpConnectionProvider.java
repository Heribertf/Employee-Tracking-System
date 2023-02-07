package you;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmpConnectionProvider {
	private static Connection connection;

	public static Connection getConnection() {

		try {

			// Loading Driver Class
			Class.forName("com.mysql.jdbc.Driver");

			// Getting the Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ets", "root", "@Felimu1");

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());
			//e.printStackTrace();
			throw new RuntimeException("unhandled", e);
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			throw new RuntimeException("unhandled", e);
			//e.printStackTrace();
		}

		return connection;
	}
	
    //Creating universal method to query for retrieving information
    public static ResultSet getResultFromSqlQuery(String SqlQueryString) {
        //Creating Resultset object
        ResultSet rs = null;
        try {
            //Checking whether the connection is null or null
            if (connection == null) {
                getConnection();
            }
            //Querying the query
            rs = connection.createStatement().executeQuery(SqlQueryString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
}
