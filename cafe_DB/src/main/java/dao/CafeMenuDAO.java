package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vo.CafeMenuVO;
import vo.CafeOptionVO;
import vo.CartVO;

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
			System.out.println("CafeMenuDAO-connect:ClassNotFound " + e);
		} catch (SQLException e) {
			System.out.println("CafeMenuDAO-connect:SQL " + e);
		}
		
		return con;
	}
	
	// DB 연결 해제
	private void close(PreparedStatement pstmt, Connection con) {
		try {
			pstmt.close();
			System.out.println("DB close 2");
		} catch (SQLException e) {
			System.out.println("CafeMenuDAO-close pstmt:" + e);
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("CafeMenuDAO-close con:" + e);
		}
	}
	
	// DB 연결 해제	
	private void close(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			rs.close();
			System.out.println("DB close 3");
		} catch (SQLException e) {
			System.out.println("CafeMenuDAO-close rs:" + e);
		}
	}
	
	// 메뉴 전체 불러오기
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
				menu.setmNum(rs.getString(2));
				menu.setmName(rs.getString("mName"));
				menu.setmPrice(rs.getInt("mPrice"));
				List.add(menu);
				++i;
			}
			
		} catch (SQLException e) {
			System.out.println("CafeMenuDAO getCafeMenus: " + e);
		} finally {
			if(rs != null) close(rs, pstmt, con);
			else close(pstmt, con);
		}
		
		return List;
	}

	// 메뉴 하나 불러오기
	public CafeMenuVO getCafeMenu(String mNum) {
		Connection con = connect();					// DB 연결
		String sql = "select * from cafeMenus where mNum=?;";	// 실행할 SQL문
		PreparedStatement pstmt = null;				// 쿼리 실행 준비 장소
		ResultSet rs = null;						// 쿼리 결과를 받을 장소
		CafeMenuVO menu = null;						// 결과로부터 생성할 객체
		
		try {
			pstmt = con.prepareStatement(sql);	// 쿼리 준비
			pstmt.setString(1, mNum);			// 1번째 ?에 mNum값을 입력
			rs = pstmt.executeQuery();			// 쿼리 실행
			System.out.println("getCafeMenu() executeQuery");

			if(rs.next()) {
				System.out.printf("getCafeMenu() mNum: %s\n", mNum);
				menu = new CafeMenuVO();
				menu.setCategory(rs.getString("Category"));
				menu.setmNum(rs.getString("mNum"));
				menu.setmName(rs.getString("mName"));
				menu.setmPrice(rs.getInt("mPrice"));
			}			
		} catch (SQLException e) {
			System.out.println("CafeMenuDAO getCafeMenu: " + e);
		} finally {
			if(rs != null) close(rs, pstmt, con);
			else close(pstmt, con);
		}
		return menu;
	}

	// 옵션 목록 가져오기
	public ArrayList<CafeOptionVO> getOptions() {
		ArrayList<CafeOptionVO> List = new ArrayList<CafeOptionVO>();	// 옵션들을 저장할 리스트
		Connection con = connect();									// DB 연결
		String sql = "select * from cafeOptions;";	// 실행할 SQL문
		PreparedStatement pstmt = null;				// 쿼리 실행 준비 장소
		ResultSet rs = null;						// 쿼리 결과를 받을 장소
		CafeOptionVO option = null;					// 결과로부터 생성할 객체
		
		try {
			pstmt = con.prepareStatement(sql);	// 쿼리 준비
			rs = pstmt.executeQuery();			// 쿼리 실행
			System.out.println("getOptions() executeQuery");
			
			int i = 0;
			while(rs.next()) {
				System.out.printf("getOptions() : %d\n", i);
				option = new CafeOptionVO();
				option.setOpNum(rs.getString("opNum"));
				option.setOpName(rs.getString("opName"));
				option.setOpPrice(rs.getInt("opPrice"));
				option.setRequired(rs.getString("required"));
				List.add(option);
				++i;
			}
			
		} catch (SQLException e) {
			System.out.println("CafeMenuDAO getOptions: " + e);
		} finally {
			if(rs != null) close(rs, pstmt, con);
			else close(pstmt, con);
		}
		
		return List;
	}

	public int insertCart(CartVO cart) {
		int result = 0;
		Connection con = connect();					// DB 연결
		String sql = "insert into cart values (?, ?, ? ,?);";	// 실행할 SQL문
		PreparedStatement pstmt = null;				// 쿼리 실행 준비 장소
		CartVO menu = cart;							// 장바구니에 넣을 객체
		
		try {
			pstmt = con.prepareStatement(sql);	// 쿼리 준비
			pstmt.setString(1, menu.getmNum());	// 1번째 ?에 mNum값을 입력
			pstmt.setString(2, menu.getcOptions());
			pstmt.setInt(3, menu.getcQuantity());
			pstmt.setInt(4, menu.getcPrice());
			result = pstmt.executeUpdate();			// 쿼리 실행
			System.out.println("updateCart() executeUpdate");

		} catch (SQLException e) {
			System.out.println("CafeMenuDAO updateCart: " + e);
		} finally {
			close(pstmt, con);
		}
		return result;
	}

	public ArrayList<CartVO> getCart() {
		ArrayList<CartVO> List = new ArrayList<CartVO>();	// 장바구니를 저장할 리스트
		Connection con = connect();					// DB 연결
		String sql = "select c.mNum, c.cOptions, c.cQuantity, c.cPrice, m.mName from cart c, cafeMenus m where c.mNum = m.mNum;";	// 실행할 SQL문
		PreparedStatement pstmt = null;				// 쿼리 실행 준비 장소
		ResultSet rs = null;						// 쿼리 결과를 받을 장소
		CartVO cartMenu = null;					// 결과로부터 생성할 객체
		
		try {
			pstmt = con.prepareStatement(sql);	// 쿼리 준비
			rs = pstmt.executeQuery();			// 쿼리 실행
			System.out.println("getCart() executeQuery");
			
			int i = 0;
			while(rs.next()) {
				System.out.printf("getCart() : %d\n", i);
				cartMenu = new CartVO();
				cartMenu.setmNum(rs.getString(1));
				cartMenu.setcOptions(rs.getString(2));
				cartMenu.setcQuantity(rs.getInt(3));
				cartMenu.setcPrice(rs.getInt(4));
				cartMenu.setmName(rs.getString(5));
				List.add(cartMenu);
				++i;
			}
			
		} catch (SQLException e) {
			System.out.println("CafeMenuDAO getCart: " + e);
		} finally {
			if(rs != null) close(rs, pstmt, con);
			else close(pstmt, con);
		}
		
		return List;
	}

	public int order(String userPhoneNumber) {
		ArrayList<CartVO> List = getCart();
		
		int resultH = 0;
		int resultD = 0;
		int result = 0;		// 전체 결과
		ResultSet rs;		// 개수 세는 쿼리의 결과를 담을 그릇
		int rsCount = 0;	// orderHistory 개수
		int totalPrice = 0; // 장바구니 전체 기격
		
		for(int i =0; i < List.size(); ++i) {
			totalPrice += List.get(i).getcPrice();
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");	// 주문번호에 넣을 날짜 포맷 설정
		Timestamp now = new Timestamp(System.currentTimeMillis());	// 현재시각 저장
		String simpleNow = format.format(now);						// 주문번호에 넣을 날짜
		String odNum = null; // 주문번호
		String stringCount;
		
		Connection con = connect();					// DB 연결
		String sql = "select count(*) from orderHistory;";	// 실행할 SQL문
		PreparedStatement pstmt = null;				// 쿼리 실행 준비 장소
		
		try {
			pstmt = con.prepareStatement(sql);	// 쿼리 준비
			rs = pstmt.executeQuery();			// 쿼리 실행
			System.out.println("order() countCart executeUpdate");
			
			if(rs.next()) {
				rsCount = Integer.parseInt(rs.getString(1));
				System.out.println("rsCount" + rsCount);
				++rsCount;
				System.out.println("++rsCount : "+ rsCount);
				
				stringCount = String.format("%04d", rsCount);
				odNum = simpleNow + "-" + stringCount;
			}
		} catch (SQLException e) {
			System.out.println("CafeMenuDAO order countCart : " + e);
		} finally {
			close(pstmt, con);
		}
		
		if(odNum == null) {
			System.out.println("CafeMenuDAO order odNum : error");
			return result;
		}
		
		resultH = orderHistory(odNum, userPhoneNumber, totalPrice, now);
		resultD = orderDetail(odNum, List);
		
		if(resultH == 1 && resultD == 1 ) {
			result = 1;
		}
		return result;
		
	}
	
	private int orderHistory(String odNum, String userPhoneNumber, int totalPrice, Timestamp now) {
		int result = 0;
		Connection con = connect();					// DB 연결
		String sql = "insert into orderHistory values (?, ?, ? ,?);";	// 실행할 SQL문
		PreparedStatement pstmt = null;				// 쿼리 실행 준비 장소
		
		try {
			pstmt = con.prepareStatement(sql);	// 쿼리 준비
			pstmt.setString(1, odNum);	// 1번째 ?에 odNum값을 입력
			pstmt.setString(2, userPhoneNumber);
			pstmt.setInt(3, totalPrice);
			pstmt.setTimestamp(4, now);
			result = pstmt.executeUpdate();			// 쿼리 실행
			System.out.println("orderHistory() executeUpdate");	
		} catch (SQLException e) {
			System.out.println("CafeMenuDAO orderHistory: " + e);
		} finally {
			close(pstmt, con);
		}
		return result;
	}

	public int orderDetail(String odNum, ArrayList<CartVO> list) {
		int result = 0;
		Connection con = connect();					// DB 연결
		String sql = "insert into orderDetail values (?, ?, ? ,?, ?);";	// 실행할 SQL문
		PreparedStatement pstmt = null;				// 쿼리 실행 준비 장소
		CartVO menu = null;							// 장바구니에 넣을 객체
		
		try {
			pstmt = con.prepareStatement(sql);	// 쿼리 준비
			pstmt.setString(1, odNum);	// 1번째 ?에 mNum값을 입력
			for(int i = 0; i < list.size(); ++i) {
				menu = list.get(i);
				pstmt.setString(2, menu.getmNum());
				pstmt.setString(3, menu.getcOptions());
				pstmt.setInt(4, menu.getcQuantity());
				pstmt.setInt(5, menu.getcPrice());
				result = pstmt.executeUpdate();			// 쿼리 실행
				System.out.println("orderDetail() executeUpdate");
			}

		} catch (SQLException e) {
			System.out.println("CafeMenuDAO orderDetail: " + e);
		} finally {
			close(pstmt, con);
		}
		return result;
	}
}
