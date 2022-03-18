package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

public class DoorDatabase {
	
    public static void main(String[] args) {
		SQLiteDataSource ds = null;
	
	    //establish connection (creates db file if it does not exist :-)
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

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
        	int rv = stmt.executeUpdate( dropQuery );
        	rv = stmt.executeUpdate( createQuery );
	        System.out.println( "executeUpdate() returned " + rv );
	        
        	for (int i = 0; i < 81; i++) {
        		rv = stmt.executeUpdate( insertQuery );
        	}
            
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
        
        
        //now query the database table for all its contents and display the results
        System.out.println( "Selecting all rows from test table" );
        String selectQuery = "SELECT * FROM doors";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            //walk through each 'row' of results, grab data by column/field name
            // and print it
            while ( rs.next() ) {
                String doorNumb = rs.getString( "ID" );
                String isLocked = rs.getString( "ISLOCKED" );

                System.out.println( "Info: Door number = " + doorNumb +
                    ", locked = " + isLocked );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }
}

