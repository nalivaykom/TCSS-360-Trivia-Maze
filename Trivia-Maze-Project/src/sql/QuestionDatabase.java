package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

public class QuestionDatabase {
    public static void main(String[] args) {
		SQLiteDataSource ds = null;
	
	    //establish connection (creates db file if it does not exist :-)
	    try {
	        ds = new SQLiteDataSource();
	        ds.setUrl("jdbc:sqlite:questions.db");
	    } catch ( Exception e ) {
	        e.printStackTrace();
	        System.exit(0);
	    }
	
	    // create question table
	    String query = "CREATE TABLE IF NOT EXISTS questions ( " +
	            "QUESTION TEXT NOT NULL, " +
	            "ANSWER TEXT NOT NULL, " +
	            "POINT INT NOT NULL )";
	    try ( Connection conn = ds.getConnection();
	            Statement stmt = conn.createStatement(); ) {
	          int rv = stmt.executeUpdate( query );
	          System.out.println( "executeUpdate() returned " + rv );
	    } catch ( SQLException e ) {
	          e.printStackTrace();
	          System.exit( 0 );
	    }
	    System.out.println( "Created questions table successfully" );
	      
	    //next insert two rows of data
	    System.out.println( "Attempting to insert two questions into the table" );

	    String query1 = "INSERT INTO questions ( QUESTION, ANSWER, POINT ) VALUES ( 'A sculpture of this heavyweight's fist was donated to the city of Detroit by Sports Illustrated', "
	    				+ "'Joe Louis', 400 )";
	    String query2 = "INSERT INTO questions ( QUESTION, ANSWER, POINT ) VALUES ( 'Last name of the circus man P.T. Barnum teamed up with in 1881', "
	    				+ "'Bailey', 300 )";
	    
	    try ( Connection conn = ds.getConnection();
	          Statement stmt = conn.createStatement(); ) {
	          int rv = stmt.executeUpdate( query1 );
	          System.out.println( "1st executeUpdate() returned " + rv );

	          rv = stmt.executeUpdate( query2 );
	          System.out.println( "2nd executeUpdate() returned " + rv );
	    } catch ( SQLException e ) {
	          e.printStackTrace();
	          System.exit( 0 );
	    }
	    
	    //Query the database table for all its contents and display the results
        System.out.println( "Selecting all rows from test table" );
        query = "SELECT * FROM questions";

        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            
            ResultSet rs = stmt.executeQuery(query);
            
            //walk through each 'row' of results, grab data by column/field name
            // and print it
            while ( rs.next() ) {
                String question = rs.getString( "QUESTION" );
                String answer = rs.getString( "ANSWER" );

                System.out.println( "Result: Question = " + question +
                    ", Answer = " + answer );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }
}
