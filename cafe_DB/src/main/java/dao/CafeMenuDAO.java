package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.CafeMenuVO;

public class CafeMenuDAO {
	// DAO 객체가 여러개 생성되어 관리되지 못하는 상황이 없도록
	// 한 개만 미리 만들어 놓고 getInstance()를 통해 사용할 수 있도록 함
	
	// 자기 자신을 객체로 생성
	private static CafeMenuDAO dao = new CafeMenuDAO();
	
	// 디폴트 생성자 접근 제한
	private CafeMenuDAO() {};
	
	// 객체 반환
	public static CafeMenuDAO getInstance() {
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
			
			System.out.println("connect success");
			// 실패했으면 아래 에러가 떴겠지
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
			System.out.println("DB close 2");
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
			System.out.println("DB close 3");
		} catch (SQLException e) {
			System.out.println("UserDAO-close rs:" + e);
		}
	}

	public ArrayList<CafeMenuVO> getCafeMenus() {
		ArrayList<CafeMenuVO> List = new ArrayList<CafeMenuVO>();	// 카페 메뉴를 저장할 리스트
		Connection con = connect();									// DB 연결
		String sql = "select * from cafeMenus;";	// 실행할 SQL문
		PreparedStatement pstmt = null;				// 쿼리 실행 준비 장소
		ResultSet rs = null;						// 쿼리 결과를 받을 장소
		CafeMenuVO menu = null;						// 결과로부터 생성할 객체
		
		try {
			pstmt = con.prepareStatement(sql);	// 쿼리 준비
			rs = pstmt.executeQuery();			// 쿼리 실행
			System.out.println("getCafeMenus() executeQuery");
			
			int i = 0;
			while(rs.next()) {
				System.out.printf("getCafeMenus() : %d\n", i);
				menu = new CafeMenuVO();
				menu.setCategory(rs.getString("Category"));
				menu.setmName(rs.getString("mNum"));
				menu.setmName(rs.getString("mName"));
				menu.setmPrice(rs.getInt("mPrice"));
				List.add(menu);
				++i;
			}
			
		} catch (SQLException e) {
			System.out.println("ItemDAO showAll: " + e);
		} finally {
			if(rs != null) close(rs, pstmt, con);
			else close(pstmt, con);
		}
		
		return List;
	}
}
