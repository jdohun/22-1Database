package service;

import java.util.ArrayList;

import dao.CafeMenuDAO;
import vo.CafeMenuVO;

public class ItemService {
	// 미리 생성한 DAO 객체를 받아옴
	private CafeMenuDAO dao = CafeMenuDAO.getInstance();
	
	// service 객체가 여러개 생성되어 관리되지 못하는 상황이 없도록
	// 한 개만 미리 만들어 놓고 getInstance()를 통해 사용할 수 있도록 함 
	private static ItemService service = new ItemService();
	
	// 디폴트 생성자 접근 제한
	private ItemService() {};
	
	public static ItemService getInstance() {
		return service;
	}
	
	// 모든 메뉴 가져오기
	public ArrayList<CafeMenuVO> getCafeMenus() {
		ArrayList<CafeMenuVO> List = dao.getCafeMenus(); 
		return List;
	}

}
