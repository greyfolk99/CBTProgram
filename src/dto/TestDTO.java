package dto;

public class TestDTO {
	private int testNo;
	private StudentDTO student;
	private SubjectDTO subject;
	private int score;
	private String endTime;
	private int takeTime;

	public TestDTO() {}
	public String getEndTime() {return endTime;}
	public void setEndTime(String endTime) {this.endTime = endTime;}
	public int getTestNo() {return testNo;}
	public StudentDTO getStudent() {return student;}
	public SubjectDTO getSubject() {return subject;}
	public int getScore() {return score;}
	public int getTakeTime() {return takeTime;}
	public void setTestNo(int testNo) {this.testNo = testNo;}
	public void setStudent(StudentDTO student) {this.student = student;}
	public void setSubject(SubjectDTO subject) {this.subject = subject;}
	public void setScore(int score) {this.score = score;}
	public void setTakeTime(int takeTime) {this.takeTime = takeTime;}
	public String toStringTestHistory() {
		return subject.getSubjectName() + subject.getSubjectGrade() + "/" + subject.getSubjectType() + "/"
				+ subject.getPubYear() + "/" + score + "점" + "/" + endTime;
	}
}
