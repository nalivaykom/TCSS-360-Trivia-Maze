import java.util.Random;

public class Question_Answer {

	private static String[] questions = new String[51];
	private static String[] questionType = new String[51];
	private static String[] answer = new String[51];
	int temp;
	
	Question_Answer() {
		questionType[0] = "Short Answer";
		questions[0] = "What is the highest number of pets that can be stored in the Menagerie of a player-owned house";
		answer[0] = "52";
		
		questionType[1] = "abcd";
		questions[1] = "how many teleport spells are in the standard mage book?"
				+ " \na: 10 \nb: 15 \nc: 17 \nd: 12";
		answer[1] = "b";
		
		questionType[2] = "T/F";
		questions[2] = "More expensive armour is always better then cheaper armour sets";
		answer[2] = "false";
		
		questionType[3] = "Short Answer";
		questions[3] = "What level is vorkath after the Dragon Slayer 2 quest?";
		answer[3] = "732";
		
		questionType[4] = "abcd";
		questions[4] = "What is city is the Grand Exchange in?"
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
		questions[12] = "What level is correlated with half of the xp required to reach level 99 in a single stat?";
		answer[12] = "92";
		
		questionType[13] = "abcd";
		questions[13] = "What game mechanic does the TzKal-Zuk challenge require that players master? "
				+ "\na: Tick manipulation  \nb: Agility tactics \nc: XP Waste \nd: Banking quickly";
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
      
		questionType[22] = "abcd";
		questions[22] = "What is the rarest pet by drop rate?"
				+ "\na: Blood Hound \nb: Hell Pup \nc: The Heron \nd: Kraken";
		answer[22] = "c";
		
		questionType[23] = "T/F";
		questions[23] = "During the covid Pandemic Jagex added a special FaceMask item.";
		answer[23] = "false";
		
		questionType[24] = "T/F";
		questions[24] = "Cerburus can only be killed when assigned by a slayer master.";
		answer[24] = "true";
		
		questionType[25] = "abcd";
		questions[25] = "What percent of damage does a protection prayer protect a player from in PVP?"
				+ "\na: 20% \nb: 40% \nc: 60% \nd: 80%";
		answer[25] = "b";
		
		questionType[26] = "abcd";
		questions[26] = "What percent of damage does a protection prayer protect a player from in PVM agianst "
				+ "non-boss monsters?"
				+ "\na: 20% \nb: 40% \nc: 60% \nd: 100%";
		answer[26] = "d";
		
		questionType[27] = "abcd";
		questions[27] = "How many vorkath kills does it take to get the vorkath pet?"
				+ "\na: 1 \nb: 5000 \nc: 3000 \nd: It's never garunteed";
		answer[27] = "d";
		
		questionType[28] = "Short Answer";
		questions[28] = "What is the highest agility requirement for an agility shortcut?";
		answer[28] = "92";
		
		questionType[29] = "Short Answer";
		questions[29] = "How many castle wars tickets does a Faithful Shield cost?";
		answer[29] = "200";
		
		questionType[30] = "abcd";
		questions[30] = "Which of the following is not a set of the Strong and Expensive barrows armour?"
				+ "\na: Full Torags \nb: Full Guthans \nc: Full Dherocks \nd: Full Karils";
		answer[30] = "c";
		
		questionType[31] = "Short Answer";
		questions[31] = "What is the max combat level of a player?";
		answer[31] = "126.1";
		
		questionType[32] = "abcd";
		questions[32] = "What method of prayer training provides the most garunteed xp per bone?"
				+ "\na: Ectofuncus \nb: Gilded Alter \nc: Chaos Alter \nd: Bury Bone in ground";
		answer[32] = "a";
		
		questionType[33] = "Short Answer";
		questions[33] = "What is the minimum fishing level needed to complete the morytania Elite Diary?";
		answer[33] = "91";
		
		questionType[34] = "abcd"; 
		questions[34] = "Which of the following items would a player least likely have"
				+ "\na: 3rd Age Pick Axe \nb: Twisted Bow \nc: Elysian Spirit Shield /nd: Burnt Oomlie wrap";
		answer[34] = "d";
		
		questionType[35] = "Short Answer";
		questions[35] = "How many steel dragons reside in the soul wars slayer dungeon?";
		answer[35] = "3";
		
		questionType[36] = "Short Answer";
		questions[36] = "What is the most amount of hp a single item can heal a player?";
		answer[36] = "64";
		
		questionType[37] = "Short Answer";
		questions[37] = "How much hp can Rainbow Fish heal?";
		answer[37] = "11";
		
		questionType[38] = "Short Answer";
		questions[38] = "What is the highest crush defense bonus that can be achieved?";
		answer[38] = "469";
		
		questionType[39] = "abcd";
		questions[39] = "Who is the second youngest of the Barrows brothers?"
				+ "\na: Verac \nb: Ahrim \nc: Torag \nd: Dharok";
		answer[39] = "c";
		
		questionType[40] = "T/F";
		questions[40] = "Many players opt to grow flowers in the middle of a PVP fight.";
		answer[40] = "true";
		
		questionType[41] = "Short Answer";
		questions[41] = "What is TzTokJads combat level?";
		answer[41] = "702";
		
		questionType[42] = "Short Answer";
		questions[42] = "What combat level is TzKal-Zuk?";
		answer[42] = "1400";
		
		questionType[43] = "Short Answer";
		questions[43] = "What thieving level do you need to complete Desert Treasure?";
		answer[43] = "53";
		
		questionType[44] = "Short Answer";
		questions[44] = "What is the exact number of coins you need to pay Saniboch "
				+ "to gain one time access to the brimhaven dungeon?";
		answer[44] = "875";
		
		questionType[45] = "Short Answer";
		questions[45] = "What is the difference between the max total level in OSRS and RS3?";
		answer[45] = "621";
		
		questionType[46] = "abcd";
		questions[46] = "What was the original name of runescape?"
				+ "\na: DeviousMud \n: RuneScape Classic \nc: RuneScape \nd: Old School Runescape";
		answer[46] = "a";
		
		questionType[47] = "Short Answer";
		questions[47] = "How many Alchemist Pizzazz points are required to unlock Bones To Peaches spell";
		answer[47] = "300";
		
		questionType[48] = "Short Answer";
		questions[48] = "In what year did the Falador Massacre occur?";
		answer[48] = "2006";
		
		questionType[49] = "Short Answer";
		questions[49] = "How many fairy ring teleports are there?";
		answer[49] = "46";
		
		questionType[50] = "Short Answer";
		questions[50] = "How many fairy ring codes are there?";
		answer[50] = "64";
		
		Random r = new Random();
		temp = r.nextInt(51); //creates an int between 0-35
		
		
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
