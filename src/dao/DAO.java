package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.QuestionDTO;
import dto.RecordDTO;
import dto.StudentDTO;
import dto.SubjectDTO;
import dto.TestDTO;

public class DAO {
	private Connection conn = null;
	private String url = "jdbc:mysql://localhost:3306/newdb?serverTimezon=UTC";
	private String user = "root";
	private String password = "1235";

	protected Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection con, PreparedStatement pstmt) {
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// SELECT QUERY
	public ArrayList<SubjectDTO> getSubjectData() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();

		ArrayList<SubjectDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM SubjectTbl";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SubjectDTO dto = new SubjectDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	
	public ArrayList<TestDTO> getAllTestData(int studentNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();

		ArrayList<TestDTO> arr = new ArrayList<>();
		String sql = "SELECT * FROM TestTbl WHERE studentNo=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, studentNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TestDTO dto = new TestDTO();
				dto.setTestNo(rs.getInt(1));
				dto.setStudent(getStudentData(rs.getInt(2)));
				dto.setSubject(getSubjectData(rs.getInt(3)));
				dto.setScore(rs.getInt(4));
				dto.setEndTime(rs.getString(5));
				dto.setTakeTime(rs.getInt(6));
				arr.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con,pstmt,rs);
		}
		return arr;
	}
	
	// SELECT QUERY
	public SubjectDTO getSubjectData(int subjectNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();
		SubjectDTO dto = null;
		String sql = "SELECT * FROM SubjectTbl where subjectNo = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, subjectNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new SubjectDTO(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5),
						rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return dto;
	}

	// SELECT QUERY
	public ArrayList<SubjectDTO> getSubjectData(String subjectname, String subjectGrade, String subjectType,
			String pubYear) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();

		ArrayList<SubjectDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM SubjectTbl";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SubjectDTO dto = new SubjectDTO(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5), 
						rs.getInt(6));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<QuestionDTO> getQuestionDataWithSubject(SubjectDTO subject) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();

		ArrayList<QuestionDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM QuestionTbl WHERE subjectNo=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, subject.getSubjectNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QuestionDTO dto = new QuestionDTO();
				dto.setSubject(subject);
				dto.setQuestionNo(rs.getInt(3));
				dto.setCategory(rs.getString(4));
				dto.setTitle(rs.getString(5));
				dto.setReference(rs.getString(6));
				dto.setContent(rs.getString(7));
				dto.setExplain(rs.getString(8));
				dto.setAnsNo(rs.getInt(9));
				dto.setSelect1(rs.getString(10));
				dto.setSelect2(rs.getString(11));
				dto.setSelect3(rs.getString(12));
				dto.setSelect4(rs.getString(13));
				dto.setKeyword(rs.getString(14));
				dto.setCorrectRate(rs.getDouble(15));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	public QuestionDTO getQuestionData(int questionid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();
		QuestionDTO dto = new QuestionDTO();
		String sql = "SELECT * FROM QuestionTbl WHERE questionid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, questionid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setSubject(getSubjectData(rs.getInt(2)));
				dto.setQuestionNo(rs.getInt(3));
				dto.setCategory(rs.getString(4));
				dto.setTitle(rs.getString(5));
				dto.setReference(rs.getString(6));
				dto.setContent(rs.getString(7));
				dto.setExplain(rs.getString(8));
				dto.setAnsNo(rs.getInt(9));
				dto.setSelect1(rs.getString(10));
				dto.setSelect2(rs.getString(11));
				dto.setSelect3(rs.getString(12));
				dto.setSelect4(rs.getString(13));
				dto.setKeyword(rs.getString(14));
				dto.setCorrectRate(rs.getDouble(15));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return dto;
	}

	public StudentDTO getStudentData(int studentNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDTO dto = new StudentDTO();
		con = getConnection();

		String sql = "SELECT * FROM StudentTbl WHERE studentNo=? AND unsubdate is null";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, studentNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setStudentNo(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPwd(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setBirthday(rs.getString(5));
				dto.setPhone(rs.getString(6));
				dto.setEmail(rs.getString(7));
				dto.setAddress(rs.getString(8));
				dto.setDisposeDate(rs.getInt(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return dto;
	}

	public ArrayList<TestDTO> getTestDataWithStudentNo(int studentNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();

		ArrayList<TestDTO> arr = new ArrayList<>();
		String sql = "SELECT * FROM TestTbl WHERE studentNo=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, studentNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				TestDTO dto = new TestDTO();
				dto.setTestNo(rs.getInt(1));
				dto.setStudent(getStudentData(rs.getInt(2)));
				dto.setSubject(getSubjectData(rs.getInt(3)));
				dto.setScore(rs.getInt(4));
				dto.setEndTime(rs.getString(5));
				dto.setTakeTime(rs.getInt(6));
				arr.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return arr;
	}

	public TestDTO getTestData(int testNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();

		TestDTO dto = new TestDTO();
		String sql = "SELECT * FROM Testtbl WHERE testNo=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, testNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setTestNo(rs.getInt(2));
				dto.setStudent(getStudentData(rs.getInt(3)));
				dto.setSubject(getSubjectData(rs.getInt(4)));
				dto.setScore(rs.getInt(5));
				dto.setTakeTime(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return dto;
	}

	/* (int 학생넘버, int 과목넘버) 전부 선택시 파라미터 0 */
	public ArrayList<RecordDTO> getRecordData(int studentNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();

		ArrayList<RecordDTO> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM RecordTbl ";
			pstmt = con.prepareStatement(sql);
			if (studentNo != 0) {
				sql += "where studentNo = ?";
				pstmt.setInt(1, studentNo);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RecordDTO dto = new RecordDTO();
				dto.setStudent(getStudentData(rs.getInt(2)));
				dto.setTest(getTestData(rs.getInt(3)));
				dto.setQuestion(getQuestionData(rs.getInt(4)));
				dto.setAnswer(rs.getInt(5));
				dto.setCategory(rs.getString(6));
				dto.setKeyword(rs.getString(7));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	// INSERT QUERY
	public void addRecordData(ArrayList<RecordDTO> arr) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();

		String sql = "INSERT INTO RecordTbl ";
		sql += "SET StudentNo=?, TestNo=?, QuestionNo=?, Answer=?, Category=?, Keyword=?";
		try {
			pstmt = con.prepareStatement(sql);
			for (RecordDTO dto : arr) {
				pstmt.setInt(1, dto.getStudent().getStudentNo());
				pstmt.setInt(2, dto.getTest().getTestNo());
				pstmt.setInt(3, dto.getQuestion().getQuestionNo());
				pstmt.setInt(4, dto.getAnswer());
				pstmt.setString(5, dto.getCategory());
				pstmt.setString(6, dto.getKeyword());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

	public void addTestData(TestDTO test) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();

		String sql = "INSERT INTO Testtbl ";
		sql += "SET StudentNo=?, SubjectNo=?, score=?, endtime=now(), taketime=?";
		// int studentNo, int subjectNo, score rate, int takeTime
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, test.getStudent().getStudentNo());
			pstmt.setInt(2, test.getSubject().getSubjectNo());
			pstmt.setInt(3, test.getScore());
			pstmt.setInt(4, test.getTakeTime());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

	// 관리자가 입력한거 SubjectDTO 에 setter 후 이 메서드 실행
	public void addSubjectData(SubjectDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();

		String sql = "INSERT INTO SubjectTbl ";
		sql += "SET SubjectNo=?, SubjectName=?, subjectGrade=?, SubjectType=?, PubYear=?, TestTime=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getSubjectName());
			pstmt.setString(2, dto.getSubjectGrade());
			pstmt.setString(3, dto.getSubjectType());
			pstmt.setString(4, dto.getPubYear());
			pstmt.setInt(5, dto.getTestTime());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}

	public void addQuestionData(QuestionDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();

		String sql = "INSERT INTO QuestionTbl ";
		sql += "SET QuestionNo=?, Category=?, Title=?, Reference=?, Content=?, Explain=?, AnsNo=?, Select1=?, Select2=?, Select3=?, Select4=?, Keyword=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getQuestionNo());
			pstmt.setString(2, dto.getCategory());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getReference());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getExplain());
			pstmt.setInt(7, dto.getAnsNo());
			pstmt.setString(8, dto.getSelect1());
			pstmt.setString(9, dto.getSelect2());
			pstmt.setString(10, dto.getSelect3());
			pstmt.setString(11, dto.getSelect4());
			pstmt.setString(12, dto.getKeyword());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}
	public void updateCorrectRate(QuestionDTO question, double correctrate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();
		String sql = "update questiontbl set correctrate = ? where questionno = ? and subjectno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, correctrate);
			pstmt.setInt(2, question.getQuestionNo());
			pstmt.setInt(3, question.getSubject().getSubjectNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}
	public double getCorrectRate(RecordDTO record) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();
		double rate = 0;
		try {
				String sql = "select count(case when r.answer = q.ansno then 1 end)/count(*)*100"
				+ "	from recordtbl r, testtbl t, questiontbl q"
				+ "	where q.questionno = r.questionno"
				+ "	and q.subjectno = t.subjectno"
				+ "	and r.testno = t.testno"
				+ "	and q.subjectno = ?"
				+ "	and q.questionno = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, record.getTest().getSubject().getSubjectNo());
				pstmt.setInt(2, record.getQuestion().getQuestionNo());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					rate = rs.getDouble(1);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
		return rate;
	}

}
