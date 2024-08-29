package model;

import java.util.Arrays;

public class Question {
    private int id;
    private String questionText;
    private String[] options;
    private String correctAnswer;
    private int quizId;
	public Question() {
		super();
	}
	public Question(int id, String questionText, String[] options, String correctAnswer, int quizId) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.options = options;
		this.correctAnswer = correctAnswer;
		this.quizId = quizId;
	}
	public Question(String questionText, String[] options, String correctAnswer, int quizId) {
		super();
		this.questionText = questionText;
		this.options = options;
		this.correctAnswer = correctAnswer;
		this.quizId = quizId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", questionText=" + questionText + ", options=" + Arrays.toString(options)
				+ ", correctAnswer=" + correctAnswer + ", quizId=" + quizId + "]";
	}
}
