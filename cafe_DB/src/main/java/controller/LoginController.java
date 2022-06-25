package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MembershipService;
import vo.MembershipVO;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// form의 input으로 받은 value, name으로 식별함
		String userPhoneNumber = (String)req.getParameter("userPhoneNumber");
		
		String path = "choice.jsp";	// 서비스가 끝나면 되돌아 갈 url
			
		MembershipService service = MembershipService.getInstance(); // 미리 생성해 놓은 service로부터 객체를 받아와서 서비스 실행
		MembershipVO user = service.login(userPhoneNumber);
		if(user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect(path);
		}
		else {	
			req.setAttribute("result", "가입하지 않은 전화번호 입니다.");
			HttpUtil.forward(req, resp, path);
		}
	}
}
