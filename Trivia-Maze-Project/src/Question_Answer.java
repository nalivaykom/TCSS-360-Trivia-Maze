import java.util.Random;

public class Question_Answer {

	private static String[] questions = new String[3];
	private static String[] questionType = new String[3];
	private static String[] answer = new String[3];
	int temp;
	
	Question_Answer() {
		questions[0] = "What is 3 + 3";
		questions[1] = "What is 4 + 3? \na: 4 \nb: 5 \nc: 6 \nd: 7";
		questions[2] = "The sky is blue";
		questionType[0] = "Short Answer";
		questionType[1] = "abcd";
		questionType[2] = "T/F";
		answer[0] = "6";
		answer[1] = "d";
		answer[2] = "true";
      
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
		return questions[temp];
	}
	
	String getQuestionType() {
		return questionType[temp];
	}
	
	String getAnswer() {
		return answer[temp];
	}
	
}
