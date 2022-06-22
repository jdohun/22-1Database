package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MembershipVO;

public class MembershipDAO {
	// DAO 객체가 여러개 생성되어 관리되지 못하는 상황이 없도록
	// 한 개만 미리 만들어 놓고 getInstance()를 통해 사용할 수 있도록 함
	
	// 자기 자신을 객체로 생성
	private static MembershipDAO dao = new MembershipDAO();
	
	// 디폴트 생성자 접근 제한
	private MembershipDAO() {};
	
	// 객체 반환
	public static MembershipDAO getInstance() {
		return dao;
	}
	
	// DB 연결
	private Connection connect() {
		Connection con = null;
		String url = "jdbc:mysql://localhost/cafe?characterEncoding=UTF-8&&Timezone=UTC";
		String user = "root";
		String passwd = "test1324";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException e) {
			System.out.println("MembershipDAO-connect:ClassNotFound " + e);
		} catch (SQLException e) {
			System.out.println("MembershipDAO-connect:SQL " + e);
		}
		
		return con;
	}
	
	// DB 연결 해제
	private void close(PreparedStatement pstmt, Connection con) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("UserDAO-close pstmt:" + e);
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("UserDAO-close con:" + e);
		}
	}
	
	// DB 연결 해제	
	private void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("UserDAO-close rs:" + e);
		}
	}

	public MembershipVO login(String phoneNumeber, String pwd) {
		MembershipVO user = null;
		Connection con = connect();
		String sql = "select * from Membership where phoneNumeber=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneNumeber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new MembershipVO();
				
				user.setMileage(rs.getInt("Mileage"));
			}			
		} catch (SQLException e) {
			System.out.println("MembershipDAO-login: " + e);
		} finally {
			try {
				if(rs.next()) {
					close(rs, pstmt, con);
				}
				else {
					close(pstmt, con);
				}
			} catch (SQLException e) {
				System.out.println("MembershipDAO-login close: " + e);
			}
		}
		return user;
	}
}
