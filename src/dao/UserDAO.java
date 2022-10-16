package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.StudentDTO;

public class UserDAO extends DAO {

	// INSERT QUERY
	public int addUserData(StudentDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();
		String sql = "INSERT INTO StudentTbl ";
		sql += "SET Id=?, Pwd=?, Name=?, Birthday=?, Phone=?, Email=?, Address=?, RegDate=now(), DisposeDate=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirthday());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getAddress());
			pstmt.setInt(8, dto.getDisposeDate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			close(con, pstmt);
		}
		return 1;
	}
	
	

	// SELECT QUERY
	public StudentDTO selectStudentData(String id, String Pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDTO dto = null;
		con = getConnection();

		String sql = "SELECT * FROM StudentTbl WHERE Id=? AND Pwd=? AND unsubdate is null";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, Pwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new StudentDTO();
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

	public String findUserID(String name, String birthday, String Email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();
		String id = null;

		String sql = "SELECT * FROM StudentTbl WHERE Name=? AND Birthday=? AND Email=? AND unsubdate is null";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, birthday);
			pstmt.setString(3, Email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				id = rs.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return id;
	}

	public String findUserPwd(String id, String name, String birthday, String Email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();
		String pwd = null;

		String sql = "SELECT * FROM StudentTbl WHERE Id=? AND Name=? AND birthday=? AND Email=? AND unsubdate is null";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, birthday);
			pstmt.setString(4, Email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pwd = rs.getString(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return pwd;
	}

	public String IdCheck(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = getConnection();
		String a = null;

		String sql = "SELECT * FROM StudentTbl WHERE Id=? AND unsubdate is null";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())
				a = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return a;
	}

	// UPDATE QUERY
	// 회원탈퇴시 id 값 null setting 후에 이 메서드 실행하면 될듯 아니면 deleteStudentData 사용
	public void updateStudentData(StudentDTO dto) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();

		String sql = "UPDATE StudentTbl SET Id=?, Pwd=?, Name=?, Birthday=?, Phone=?, Email=?, Address=? ";
		sql += "WHERE StudentNo=? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirthday());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getAddress());
			pstmt.setInt(8, dto.getStudentNo());
			pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
	}

	// DELETE QUERY
	public void deleteStudentData(int studentNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = getConnection();

		String sql = "DELETE StudentTbl WHERE StudentNo=?";
		String sql2 = "DELETE RecordTbl WHERE StudentNo=?";
		String sql3 = "DELETE TestTbl WHERE StudentNo=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, studentNo);
			pstmt.executeQuery();

			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, studentNo);
			pstmt.executeQuery();

			pstmt = con.prepareStatement(sql3);
			pstmt.setInt(1, studentNo);
			pstmt.executeQuery();

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 정보수정
	public int unsubStudent(StudentDTO dto, String setSql) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = getConnection();

		String sql = "update studenttbl set " + setSql + " where studentNo=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getStudentNo());
			result = pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateStudentData(StudentDTO dto, String setSql) {
		int result = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		con = getConnection();
		String sql = "update studenttbl set " + setSql + " where studentNo = ?";
		System.out.println(sql);

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getStudentNo());
			result = pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
