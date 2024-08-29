package model;

public class Quiz {
    private int id;
    private String title;
    private String description;
	public Quiz() {
		super();
	}
	public Quiz(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public Quiz(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
}