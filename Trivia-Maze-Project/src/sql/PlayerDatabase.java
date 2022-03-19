package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

/**
 * This class creates the player database.
 * 
 * @author Bao Nguyen
 * @version Winter 2022
 */
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
	    
	    // insert into player table
        String insertQuery = "INSERT INTO players ( NAME, ROW, COLUMN ) VALUES ('Joe', 0, 0)";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            
        	stmt.executeUpdate( dropQuery );
        	stmt.executeUpdate( createQuery );
            stmt.executeUpdate( insertQuery );
            
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }
}

