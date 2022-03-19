package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

/**
 * This class creates the door database.
 * 
 * @author Bao Nguyen
 * @version Winter 2022
 */
public class DoorDatabase {
	
    public static void main(String[] args) {
		SQLiteDataSource ds = null;
	
	    // establish connection (creates db file if it does not exist :-)
	    try {
	        ds = new SQLiteDataSource();
	        ds.setUrl("jdbc:sqlite:doors.db");
	    } catch ( Exception e ) {
	        e.printStackTrace();
	        System.exit(0);
	    }
	
	    // drop player table if already created
	    String dropQuery = "DROP TABLE IF EXISTS doors";
	    
	    // create player table
	    String createQuery = "CREATE TABLE IF NOT EXISTS doors ( " +
	            "ID INTEGER NOT NULL, "
	            + "ISLOCKED INT NOT NULL, "
	            + "PRIMARY KEY (ID) )";

        
        String insertQuery = "INSERT INTO doors ( ISLOCKED ) VALUES ( 0 )";
        
        String selectQuery = "SELECT * FROM doors";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
        	
        	stmt.executeUpdate( dropQuery );
        	stmt.executeUpdate( createQuery );
	        
        	for (int i = 0; i < 81; i++) {
        		stmt.executeUpdate( insertQuery );
        	}
            
            stmt.executeQuery(selectQuery);
            
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }
}

