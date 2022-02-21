package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

public class PlayerDatabase {
	
    public static void main(String[] args) {
		SQLiteDataSource ds = null;
	
	    //establish connection (creates db file if it does not exist :-)
	    try {
	        ds = new SQLiteDataSource();
	        ds.setUrl("jdbc:sqlite:players.db");
	    } catch ( Exception e ) {
	        e.printStackTrace();
	        System.exit(0);
	    }
	
	    // create question table
	    String query = "CREATE TABLE IF NOT EXISTS questions ( " +
	            "NAME TEXT NOT NULL, " +
	            "ID INT NOT NULL )";
	    try ( Connection conn = ds.getConnection();
	            Statement stmt = conn.createStatement(); ) {
	          int rv = stmt.executeUpdate( query );
	          System.out.println( "executeUpdate() returned " + rv );
	    } catch ( SQLException e ) {
	          e.printStackTrace();
	          System.exit( 0 );
	    }
	    System.out.println( "Created questions table successfully" );
	      
	    //next insert the player information
        System.out.println( "Attempting to insert two rows into questions table" );

        String query1 = "INSERT INTO questions ( NAME, ID ) VALUES ( 'Joe', 1 )";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            int rv = stmt.executeUpdate( query1 );
            System.out.println( "1st executeUpdate() returned " + rv );
            
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
        
        
        //now query the database table for all its contents and display the results
        System.out.println( "Selecting all rows from test table" );
        query = "SELECT * FROM questions";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            
            ResultSet rs = stmt.executeQuery(query);
            
            //walk through each 'row' of results, grab data by column/field name
            // and print it
            while ( rs.next() ) {
                String name = rs.getString( "NAME" );
                String id = rs.getString( "ID" );

                System.out.println( "Info: Player's name = " + name +
                    ", Id = " + id );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }
    
}