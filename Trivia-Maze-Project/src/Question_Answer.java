import java.util.Random;

public class Question_Answer {

	private static String[] questions = new String[3];
	private static String[] questionType = new String[3];
	private static String[] answer = new String[3];
	int temp;
	
	Question_Answer() {
		questions[0] = "what is 3 + 3";
		questions[1] = "pick 7 \na: 4 \nb: 5 \nc: 6 \nd: 7";
		questions[2] = "is the sky blue?";
		questionType[0] = "Short Answer";
		questionType[1] = "abcd";
		questionType[2] = "T/F";
		answer[0] = "6";
		answer[1] = "d";
		answer[2] = "true";
        //temp = (int)(Math.random() * 2);
		//temp = (Math.random() <= 0.5) ? 0 : 2;
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
