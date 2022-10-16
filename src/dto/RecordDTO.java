package dto;

public class RecordDTO {
	private StudentDTO student;
	private TestDTO test;
	private QuestionDTO question;
	private int answer;
	private String category;
	private String keyword;
	public RecordDTO() {}
	public RecordDTO(StudentDTO student, TestDTO test, QuestionDTO question, int answer, String category, String keyword) {
		this.student = student;
		this.test = test;
		this.question = question;
		this.answer = answer;
		this.category = category;
		this.keyword = keyword;
	}
	public StudentDTO getStudent() { return student; }
	public TestDTO getTest() { return test; }
	public QuestionDTO getQuestion() { return question; }
	public int getAnswer() { return answer; }
	public String getCategory() { return category; }
	public String getKeyword() { return keyword; }
	
	public void setStudent(StudentDTO student) { this.student = student; }
	public void setTest(TestDTO test) { this.test = test; }
	public void setQuestion(QuestionDTO question) { this.question = question; }
	public void setAnswer(int answer) { this.answer = answer; }
	public void setCategory(String category) { this.category = category; }
	public void setKeyword(String keyword) { this.keyword = keyword; }
	
	@Override
	public String toString() {
		return null;
	}
}
