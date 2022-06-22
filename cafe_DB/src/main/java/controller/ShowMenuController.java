package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ItemService;
import vo.CafeMenuVO;


public class ShowMenuController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "order.jsp";	// 서비스가 끝나면 되돌아 갈 url
		//boolean result = false;		// 서비스의 성공 여부

		ArrayList<CafeMenuVO> List = null;	// 카페 메뉴를 저장할 리스트
		//String prof = (String)req.getSession().getAttribute("id");
		List = ItemService.getInstance().getCafeMenus();
		
		req.setAttribute("List", List);
		HttpUtil.forward(req, resp, path);
	}
}
