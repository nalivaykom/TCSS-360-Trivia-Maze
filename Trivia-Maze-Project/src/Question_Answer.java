import java.util.Random;

public class Question_Answer {

	private static String[] questions = new String[22];
	private static String[] questionType = new String[22];
	private static String[] answer = new String[22];
	int temp;
	
	Question_Answer() {
		questionType[0] = "Short Answer";
		questions[0] = "What is 3 + 3";
		answer[0] = "6";
		
		questionType[1] = "abcd";
		questions[1] = "What is 4 + 3? \na: 4 \nb: 5 \nc: 6 \nd: 7";
		answer[1] = "d";
		
		questionType[2] = "T/F";
		questions[2] = "The sky is blue";
		answer[2] = "true";
		
		questionType[3] = "Short Answer";
		questions[3] = "What level is vorkath after the Dragon Slayer 2 quest?";
		answer[3] = "732";
		
		questionType[4] = "abcd";
		questions[4] = "What is city is the Grand Exchange closest to?"
				+ " \na: Ardougne \nb: Lunar aisle \nc: Falador \nd: Varrock";
		answer[4] = "d";
		
		questionType[5] = "T/F";
		questions[5] = "There exists a combat level 2,000 boss in the OSRS code";
		answer[5] = "true";
		
		questionType[6] = "Short Answer";
		questions[6] = "How much xp do you get for cooking a shark";
		answer[6] = "210";
		
		questionType[7] = "abcd";
		questions[7] = "What item increases odds of getting a bird nest while cutting a tree?"
				+ " \na: Strung Rabbit foot \nb: Woodcutting Cape \nc: Dragon Axe \nd: Ring of Wealth";
		answer[7] = "a";
		
		questionType[8] = "abcd";
		questions[8] = "How can you get 3rd age armour?"
				+ " \na: Random drop from corporeal beast \nb: Going to Runefest "
				+ "\nc: Cluescroll Reward \nd: Killing the King Black Dragon";
		answer[8] = "c";
		
		questionType[9] = "Short Answer";
		questions[9] = "What programming language is the OSRS source code?";
		answer[9] = "Java";
		
		questionType[10] = "abcd";
		questions[10] = "What is the most amount of gold pieces a single player can posses?"
				+ " \na: As much as they earn \nb: Trick question, there arent any gold pieces "
				+ "\nc: 2,147,483,647 \nd: 2,147,483,746";
		answer[10] = "c";
		
		questionType[11] = "T/F";
		questions[11] = "The 3rd age pick axe has been sold for more than max cash";
		answer[11] = "true";
		
		questionType[12] = "Short Answer";
		questions[12] = "What level is correlated with have half of the xp required to reach level 99 in a single stat?";
		answer[12] = "92";
		
		questionType[13] = "abcd";
		questions[13] = "What game mechanic does the tzuk challenge require that players master? "
				+ "\na: Game ticks  \nb: Agility tactics \nc: XP Waste \nd: Banking quickly";
		answer[13] = "a";
		
		questionType[14] = "T/F";
		questions[14] = "You can get a Pernix Cowl by spending 200 castle wars tickets?";
		answer[14] = "false";
		
		questionType[15] = "abcd";
		questions[15] = "What Runescape tool allows you to record in game video?"
				+ "\na: Elysian Sigil \nb: Orb of Oculus \nc: Rune of Recording \nd: Rotten potatoe";
		answer[15] = "b";
		
		questionType[16] = "abcd";
		questions[16] = "which item was a developer tool disguised as an in game item after the farming update?"
				+ "\na: Shovel \nb: Rotten Potatoe \nc: Rotten Tomatoe \nd: Boots of Farming";
		answer[16] = "b";
		
		questionType[17] = "abcd";
		questions[17] = "Which quest features an unobtainable Bow-Sword?"
				+ "\na: Sins of the Father \nb: Devious Minds \nc: Dragon Slayer \nd: Dragon Slayer 2";
		answer[17] = "b";
		
		questionType[18] = "T/F";
		questions[18] = "The enchanted ruby bolt spec can heal a player for 25% of damage dealt.";
		answer[18] = "false";
		
		questionType[19] = "T/F";
		questions[19] = "Dragon implings require the highest hunter level to capture of all the implings.";
		answer[19] = "false";
		
		questionType[20] = "abcd";
		questions[20] = "Which of the following is not one of the four mage training arena chambers?"
				+ "\na: Alchemy \nb: Graveyard \nc: Spells \nd: Enchanting";
		answer[20] = "c";
		
		questionType[21] = "abcd";
		questions[21] = "Jagex is based out of which country?"
				+ "\na: Unites States \nb: United Kingdom \nc: Canada \nd: Netherlands";
		answer[21] = "b";
      
		/*
		questionType[22] = "";
		questions[22] = "";
		answer[22] = "";
		*/
		
		Random r = new Random();
		temp = r.nextInt(22); //creates an int between 0-21
		
		
		/*
		double temp1 = Math.random();
		if (temp1 < 0.3333333) {
			temp = 0;
		} else if (temp1 < 0.6666666) {
			temp = 1;
		} else {
			temp = 2;
		}
		*/
	}
	
	String getQuestion() {
		return questions[temp];
	}
	
	String getQuestionType() {
		return questionType[temp];
	}
	
	String getAnswer() {
		return answer[temp];
	}
	
}
