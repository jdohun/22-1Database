package service;

import dao.MembershipDAO;
import vo.MembershipVO;

public class MembershipService {
	// 미리 생성한 DAO 객체를 받아옴
	private MembershipDAO dao = MembershipDAO.getInstance();
	
	// service 객체가 여러개 생성되어 관리되지 못하는 상황이 없도록
	// 한 개만 미리 만들어 놓고 getInstance()를 통해 사용할 수 있도록 함 
	private static MembershipService service = new MembershipService();
	
	// 디폴트 생성자 접근 제한
	private MembershipService() {};
	
	public static MembershipService getInstance() {
		return service;
	}

	public MembershipVO login(String userPhoneNumber) {
		MembershipVO membership = service.login(userPhoneNumber);
		return membership;
	}
}