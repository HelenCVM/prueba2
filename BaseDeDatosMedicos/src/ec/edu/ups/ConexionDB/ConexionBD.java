package ec.edu.ups.ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
//conexion con la base de datos
	public static Connection getConnection() {
        try {
        	
        	Class.forName("org.hsqldb.jdbcDriver");  
        	Connection con = DriverManager.getConnection(  
                    "jdbc:hsqldb:file:db\\Helen", "HELENCV", "Hcompa*1997");  
            
        	//Class.forName("com.mysql.jdbc.Driver");
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname",
            //        "root", "dbpass");
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
