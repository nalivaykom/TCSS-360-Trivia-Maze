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
	
	    // drop player table if already created
	    String dropQuery = "DROP TABLE IF EXISTS players";
	    
	    // create player table
	    String createQuery = "CREATE TABLE IF NOT EXISTS players ( " +
	            "NAME TEXT NOT NULL, "
	            + "ROW INT NOT NULL, "
	            + "COLUMN INT NOT NULL )";

        // String query1 = "INSERT INTO players ( NAME, ID ) VALUES ( 'Joe', 1 )";
        String query1 = "INSERT INTO players ( NAME, ROW, COLUMN ) VALUES ('Joe', 0, 0)";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
        	int rv = stmt.executeUpdate( dropQuery );
        	rv = stmt.executeUpdate( createQuery );
	        System.out.println( "executeUpdate() returned " + rv );
            rv = stmt.executeUpdate( query1 );
            System.out.println( "1st executeUpdate() returned " + rv ); 
//            rv = stmt.executeUpdate( query2 );
//            System.out.println( "2nd executeUpdate() returned " + rv );
            
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
        
        
        //now query the database table for all its contents and display the results
        System.out.println( "Selecting all rows from test table" );
        String selectQuery = "SELECT * FROM players";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            //walk through each 'row' of results, grab data by column/field name
            // and print it
            while ( rs.next() ) {
                String name = rs.getString( "NAME" );
                String row = rs.getString( "ROW" );
                String column = rs.getString( "COLUMN" );

                System.out.println( "Info: Player's name = " + name +
                    ", row = " + row + ", column = " + column );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }
    
}