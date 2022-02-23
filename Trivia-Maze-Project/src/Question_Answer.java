import java.util.Random;

public class Question_Answer {

	private static String[] questions = new String[2];
	private static String[] questionType = new String[2];
	private static String[] answer = new String[2];
	int temp;
	
	Question_Answer() {
		questions[0] = "what is 3 + 3";
		questions[1] = "pick 7 \na: 4 \nb: 5 \nc: 6 \nd: 7";
		questionType[0] = "Short Answer";
		questionType[1] = "T/F";
		answer[0] = "6";
		answer[1] = "d";
		temp = (Math.random() <= 0.5) ? 0 : 1;
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
