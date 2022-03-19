package sql;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

/**
 * This class creates the question database.
 * 
 * @author Bao Nguyen
 * @version Winter 2022
 */
public class QuestionDatabase {
	
    public static void main(String[] args) {
		SQLiteDataSource ds = null;
		String insertQueries[] = new String[51];
	
	    //establish connection (creates db file if it does not exist :-)
	    try {
	        ds = new SQLiteDataSource();
	        ds.setUrl("jdbc:sqlite:questions.db");
	    } catch ( Exception e ) {
	        e.printStackTrace();
	        System.exit(0);
	    }
	    
	    // drop question table if already created
	    String dropQuery = "DROP TABLE IF EXISTS questions";
	    
	    // create question table
	    String createQuery = "CREATE TABLE IF NOT EXISTS questions ( " +
	    		"ID INTEGER NOT NULL, " +
	            "QUESTION TEXT NOT NULL, " +
	            "ANSWER TEXT NOT NULL, " +
	            "TYPE TEXT NOT NULL, " +
	            "PRIMARY KEY (ID) )";
	    
	    String insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is the highest number of pets that can be stored in the Menagerie of a player-owned house', '52', 'Short Answer' )";
	    insertQueries[0] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'How many teleport spells are in the standard mage book? \na: 10 \nb: 15 \nc: 17 \nd: 12', 'b', 'abcd' )";
	    insertQueries[1] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'More expensive armour is always better then cheaper armour sets', 'false', 'T/F' )";
	    insertQueries[2] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What level is vorkath after the Dragon Slayer 2 quest?', '732', 'Short Answer' )";
	    insertQueries[3] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is city is the Grand Exchange in? \na: Ardougne \nb: Lunar aisle \nc: Falador \nd: Varrock', 'd', 'abcd' )";
	    insertQueries[4] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'There exists a combat level 2,000 boss in the OSRS code', 'true', 'T/F' )";
	    insertQueries[5] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'How much xp do you get for cooking a shark', '210', 'Short Answer' )";
	    insertQueries[6] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What item increases odds of getting a bird nest while cutting a tree? \na: Strung Rabbit foot \nb: Woodcutting Cape \nc: Dragon Axe \nd: Ring of Wealth', 'a', 'abcd' )";
	    insertQueries[7] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'How can you get 3rd age armour? \na: Random drop from corporeal beast \nb: Going to Runefest \nc: Cluescroll Reward \nd: Killing the King Black Dragon', 'c', 'abcd' )";
	    insertQueries[8] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What programming language is the OSRS source code?', 'Java', 'Short Answer' )";
	    insertQueries[9] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is the most amount of gold pieces a single player can posses? \na: As much as they earn \nb: Trick question, there arent any gold pieces \nc: 2,147,483,647 \nd: 2,147,483,746', 'c', 'abcd' )";
	    insertQueries[10] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'The 3rd age pick axe has been sold for more than max cash', 'true', 'T/F' )";
	    insertQueries[11] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What level is correlated with half of the xp required to reach level 99 in a single stat?', '92', 'Short Answer' )";
	    insertQueries[12] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What game mechanic does the TzKal-Zuk challenge require that players master? \na: Tick manipulation  \nb: Agility tactics \nc: XP Waste \nd: Banking quickly', 'a', 'abcd' )";
	    insertQueries[13] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'You can get a Pernix Cowl by spending 200 castle wars tickets?', 'false', 'T/F' )";
	    insertQueries[14] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What Runescape tool allows you to record in game video?\na: Elysian Sigil \nb: Orb of Oculus \nc: Rune of Recording \nd: Rotten potatoe', 'b', 'abcd' )";
	    insertQueries[15] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'which item was a developer tool disguised as an in game item after the farming update?\na: Shovel \nb: Rotten Potatoe \nc: Rotten Tomatoe \nd: Boots of Farming', 'b', 'abcd' )";
	    insertQueries[16] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'Which quest features an unobtainable Bow-Sword?\na: Sins of the Father \nb: Devious Minds \nc: Dragon Slayer \nd: Dragon Slayer 2', 'b', 'abcd' )";
	    insertQueries[17] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'The enchanted ruby bolt spec can heal a player for 25% of damage dealt.', 'false', 'T/F' )";
	    insertQueries[18] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'Dragon implings require the highest hunter level to capture of all the implings.', 'false', 'T/F' )";
	    insertQueries[19] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'Which of the following is not one of the four mage training arena chambers?\na: Alchemy \nb: Graveyard \nc: Spells \nd: Enchanting', 'c', 'abcd' )";
	    insertQueries[20] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'Jagex is based out of which country?\na: Unites States \nb: United Kingdom \nc: Canada \nd: Netherlands', 'b', 'abcd' )";
	    insertQueries[21] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is the rarest pet by drop rate?\na: Blood Hound \nb: Hell Pup \nc: The Heron \nd: Kraken', 'c', 'abcd' )";
	    insertQueries[22] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'During the covid Pandemic Jagex added a special FaceMask item.', 'false', 'T/F' )";
	    insertQueries[23] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'Cerburus can only be killed when assigned by a slayer master.', 'true', 'T/F' )";
	    insertQueries[24] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What percent of damage does a protection prayer protect a player from in PVP?\na: 20% \nb: 40% \nc: 60% \nd: 80%', 'b', 'abcd' )";
	    insertQueries[25] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What percent of damage does a protection prayer protect a player from in PVM agianst non-boss monsters?\na: 20% \nb: 40% \nc: 60% \nd: 100%', 'd', 'abcd' )";
	    insertQueries[26] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'How many vorkath kills does it take to get the vorkath pet?\na: 1 \nb: 5000 \nc: 3000 \nd: It''s never garunteed', 'd', 'abcd' )";
	    insertQueries[27] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is the highest agility requirement for an agility shortcut?', '92', 'Short Answer' )";
	    insertQueries[28] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'How many castle wars tickets does a Faithful Shield cost?', '200', 'Short Answer' )";
	    insertQueries[29] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'Which of the following is not a set of the Strong and Expensive barrows armour?\na: Full Torags \nb: Full Guthans \nc: Full Dherocks \nd: Full Karils', 'c', 'abcd' )";
	    insertQueries[30] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is the max combat level of a player?', '126.1', 'Short Answer' )";
	    insertQueries[31] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What method of prayer training provides the most garunteed xp per bone?\na: Ectofuncus \nb: Gilded Alter \nc: Chaos Alter \nd: Bury Bone in ground', 'a', 'abcd' )";
	    insertQueries[32] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is the minimum fishing level needed to complete the morytania Elite Diary?', '91', 'Short Answer' )";
	    insertQueries[33] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'Which of the following items would a player least likely have\na: 3rd Age Pick Axe \nb: Twisted Bow \nc: Elysian Spirit Shield \nd: Burnt Oomlie wrap', 'd', 'abcd' )";
	    insertQueries[34] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'How many steel dragons reside in the soul wars slayer dungeon?', '3', 'Short Answer' )";
	    insertQueries[35] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is the most amount of hp a single item can heal a player?', '64', 'Short Answer' )";
	    insertQueries[36] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'How much hp can Rainbow Fish heal?', '11', 'Short Answer' )";
	    insertQueries[37] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is the highest crush defense bonus that can be achieved?', '469', 'Short Answer' )";
	    insertQueries[38] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'Who is the second youngest of the Barrows brothers?\na: Verac \nb: Ahrim \nc: Torag \nd: Dharok', 'c', 'abcd' )";
	    insertQueries[39] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'Many players opt to grow flowers in the middle of a PVP fight.', 'true', 'T/F' )";
	    insertQueries[40] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is TzTokJads combat level?', '702', 'Short Answer' )";
	    insertQueries[41] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What combat level is TzKal-Zuk?', '1400', 'Short Answer' )";
	    insertQueries[42] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What thieving level do you need to complete Desert Treasure?', '53', 'Short Answer' )";
	    insertQueries[43] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is the exact number of coins you need to pay Saniboch to gain one time access to the brimhaven dungeon?', '875', 'Short Answer' )";
	    insertQueries[44] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What is the difference between the max total level in OSRS and RS3?', '621', 'Short Answer' )";
	    insertQueries[45] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'What was the original name of runescape?\na: DeviousMud \n: RuneScape Classic \nc: RuneScape \nd: Old School Runescape', 'a', 'abcd' )";
	    insertQueries[46] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'How many Alchemist Pizzazz points are required to unlock Bones To Peaches spell', '300', 'Short Answer' )";
	    insertQueries[47] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'In what year did the Falador Massacre occur?', '2006', 'Short Answer' )";
	    insertQueries[48] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'How many fairy ring teleports are there?', '46', 'Short Answer' )";
	    insertQueries[49] = insertQuery;

	    insertQuery = "INSERT INTO questions ( QUESTION, ANSWER, TYPE ) VALUES ( 'How many fairy ring codes are there?', '64', 'Short Answer' )";
	    insertQueries[50] = insertQuery;
	    
	    
	    try ( Connection conn = ds.getConnection();
			  Statement stmt = conn.createStatement(); ){
	    	  stmt.executeUpdate( dropQuery );
	    	  stmt.executeUpdate( createQuery );
	          
	          for (int i = 0; i < insertQueries.length; i++) {
		          stmt.executeUpdate( insertQueries[i] );
	          }
	    } catch ( SQLException e ) {
	          e.printStackTrace();
	          System.exit( 0 );
	    }
	    
	    
    }

}
    

