package dto;

public class SubjectDTO {
	private int subjectNo;
	private String subjectName;
	private String subjectGrade;
	private String subjectType;
	private String pubYear;
	private int testTime;
	
	public SubjectDTO(int subjectNo, String subjectName, String subjectGrade, String subjectType, String pubYear,
			int testTime) {
		this.subjectNo = subjectNo;
		this.subjectName = subjectName;
		this.subjectGrade = subjectGrade;
		this.subjectType = subjectType;
		this.pubYear = pubYear;
		this.testTime = testTime;
	}
	public int getSubjectNo() { return subjectNo; }
	public String getSubjectName() { return subjectName; }
	public String getSubjectGrade() { return subjectGrade; }
	public String getSubjectType() { return subjectType; }
	public int getTestTime() { return testTime; }
	public String getPubYear() { return pubYear; }
	
	public void setSubjectNo(int subjectNo) { this.subjectNo = subjectNo; }
	public void setSubjectName(String subjectName) { this.subjectName = subjectName; }
	public void setSubjectGrade(String subjectGrade) { this.subjectGrade = subjectGrade; }
	public void setSubjectType(String subjectType) { this.subjectType = subjectType; }
	public void setTestTime(int testTime) { this.testTime = testTime; }
	public void setPubYear(String getPubYear) { this.pubYear = getPubYear; }
	
	@Override
	public String toString(){
		String str = subjectName+" "+subjectGrade+" "+subjectType;
		return str;
	}
	
	public String testinfo() {
		String str = "본 시험의 과목은 "+subjectName+" "+subjectGrade+" "+subjectType+"이고 "+pubYear+"에 출제된 내용으로 이루어져 있습니다.";
		return str;
	}
}
