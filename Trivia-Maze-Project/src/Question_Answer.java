import java.util.Random;

public class Question_Answer {

	private static String[] questions = new String[3];
	private static String[] questionType = new String[3];
	private static String[] answer = new String[3];
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
		
		questionType[4] = "Short Answer";
		questions[4] = "";
		answer[4] = "";
		
      
		double temp1 = Math.random();
		if (temp1 < 0.3333333) {
			temp = 0;
		} else if (temp1 < 0.6666666) {
			temp = 1;
		} else {
			temp = 2;
		}
	}
	
	String getQuestion() {
		System.out.println();
		return questions[temp];
	}
	
	String getQuestionType() {
		return questionType[temp];
	}
	
	String getAnswer() {
		return answer[temp];
	}
	
}
