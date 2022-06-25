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
			System.out.println("MembershipDAO-close pstmt:" + e);
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("MembershipDAO-close con:" + e);
		}
	}
	
	// DB 연결 해제	
	private void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("MembershipDAO-close rs:" + e);
		}
	}

	// 로그인
	public MembershipVO login(String phoneNumeber) {
		MembershipVO Membership = null;
		Connection con = connect();
		String sql = "select * from Membership where phoneNumeber=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phoneNumeber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Membership = new MembershipVO();
				Membership.setPhoneNumber(rs.getString(1));
				Membership.setMemberName(rs.getString(2));
				Membership.setBirth(rs.getString(3));
				Membership.setMileage(rs.getInt("Mileage"));
				
				System.out.println("MembershipDAO-login: success");
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
		return Membership;
	}
}
