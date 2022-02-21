
public class Question_Answer {

	private static String[] questions = new String[2];
	private static String[] questionType = new String[2];
	private String answer = "6";
	
	Question_Answer() {
		questions[0] = "what is 3 + 3";
		questions[1] = "pick 7 \na: 4 \nb: 5 \nc: 6 \nd: 7";
		questionType[0] = "Short Answer";
		questionType[1] = "T/F";
	}
	
	String getQuestion() {
		return questions[0];
	}
	
	String getQuestionType() {
		return questionType[0];
	}
	
	String getAnswer() {
		return this.answer;
	}
	
}
