package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MembershipService;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form의 input으로 받은 value, name으로 식별함
		String userPhoneNumber = req.getParameter("userPhoneNumber");
		
		String path = null;		// 서비스가 끝나면 되돌아 갈 url
		boolean result = false;	// 서비스의 성공 여부
		path = "index.jsp"; 	// 추후 수정
		
		MembershipService service = MembershipService.getInstance(); // 미리 생성해 놓은 service로부터 객체를 받아와서 서비스 실행
		result = service.login(userPhoneNumber);
		if(result) {
			HttpSession session = req.getSession();
			session.setAttribute("userPhoneNumber", userPhoneNumber);
		}
		else {	
			req.setAttribute("result", "가입하지 않은 전화번호 입니다.");
		}
		
		HttpUtil.forward(req, resp, path);
	}
}
