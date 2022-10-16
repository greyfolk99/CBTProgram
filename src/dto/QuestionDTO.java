package dto;

public class QuestionDTO {
	private SubjectDTO subject;
	private int questionNo;
	private String category;
	private	String title;
	private String reference;
	private String content;
	private String explain;
	private int ansNo;
	private String select1;
	private String select2;
	private String select3;
	private String select4;
	private String keyword;
	private double correctRate;
	
	public QuestionDTO() {}
	
	public SubjectDTO getSubject() { return subject; }
	public int getQuestionNo() { return questionNo; }
	public String getCategory() { return category; }
	public String getTitle() { return title; }
	public String getReference() { return reference; }
	public String getContent() { return content; }
	public String getExplain() { return explain; }
	public int getAnsNo() { return ansNo; }
	public String getSelect1() { return select1; }
	public String getSelect2() { return select2; }
	public String getSelect3() { return select3; }
	public String getSelect4() { return select4; }
	public String getKeyword() { return keyword; }
	public double getCorrectRate() { return correctRate; }
	
	public void setSubject (SubjectDTO subject) { this.subject = subject; }
	public void setQuestionNo (int questionNo) { this.questionNo = questionNo; }
	public void setCategory(String category) { this.category = category; }
	public void setTitle(String title) { this.title = title; }
	public void setReference(String reference) { this.reference = reference; }
	public void setContent(String content) { this.content = content; }
	public void setExplain(String explain) { this.explain = explain; }
	public void setAnsNo(int ansNo) { this.ansNo = ansNo; }
	public void setSelect1(String select1) { this.select1 = select1; }
	public void setSelect2(String select2) { this.select2 = select2; }
	public void setSelect3(String select3) { this.select3 = select3; }
	public void setSelect4(String select4) { this.select4 = select4; }
	public void setKeyword(String keyword) { this.keyword = keyword; }
	public void setCorrectRate(double correctRate) { this.correctRate = correctRate; }
	
	@Override
	public String toString() {
	return null;
	}
}
