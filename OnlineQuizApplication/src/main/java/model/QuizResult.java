package model;

import java.util.Date;

public class QuizResult {
    private int id;
    private int userId;
    private int quizId;
    private int score;
    private Date dateTaken;

	public QuizResult(int id, int userId, int quizId, int score, Date dateTaken) {
		super();
		this.id = id;
		this.userId = userId;
		this.quizId = quizId;
		this.score = score;
		this.dateTaken = dateTaken;
	}
	public QuizResult(int userId, int quizId, int score, Date dateTaken) {
		super();
		this.userId = userId;
		this.quizId = quizId;
		this.score = score;
		this.dateTaken = dateTaken;
	}
	public QuizResult(int id, int userId, int quizId, int score) {
		super();
		this.id = id;
		this.userId = userId;
		this.quizId = quizId;
		this.score = score;
	}
	public QuizResult(int userId, int quizId, int score) {
		super();
		this.userId = userId;
		this.quizId = quizId;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getDateTaken() {
		return dateTaken;
	}
	public void setDateTaken(Date dateTaken) {
		this.dateTaken = dateTaken;
	}
	@Override
	public String toString() {
		return "QuizResult [id=" + id + ", userId=" + userId + ", quizId=" + quizId + ", score=" + score
				+ ", dateTaken=" + dateTaken + "]";
	}
}
