import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.sqlite.SQLiteDataSource;

public class Question_Answer {
    
	private static String myQuestion = new String();
	private static String myQuestionType = new String();
	private static String myAnswer = new String();
	private static int myTemp;
	Question_Answer() {
		
	}
	
	void generate() {
		Random r = new Random();
		myTemp = r.nextInt(51); 
		
		SQLiteDataSource ds = null;
		try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:questions.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }
		try ( Connection conn = ds.getConnection();
	        Statement stmt = conn.createStatement(); ){
	        String selectQuery = "SELECT * FROM questions WHERE ID=" + String.valueOf(myTemp);
	            
	        ResultSet rs = stmt.executeQuery(selectQuery);
	            
	        while ( rs.next() ) {
	          	myQuestion = rs.getString( "QUESTION" );
		        myAnswer = rs.getString( "ANSWER" );
		        myQuestionType = rs.getString("TYPE");
		    
                System.out.println( "Result: \nQuestion = " + myQuestion +
	                "\nAnswer = " + myAnswer );
	        }
	        
	    } catch ( SQLException e ) {
	          e.printStackTrace();
	          System.exit( 0 );
	    }
	}
	
	String getQuestion() {
		return myQuestion;
	}
	
	String getQuestionType() {
		return myQuestionType;
	}
	
	String getAnswer() {
		return myAnswer;
	}
	
}
