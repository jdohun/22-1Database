package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ItemService;
import vo.CafeMenuVO;
import vo.CafeOptionVO;

public class MenuInfoController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url ? 뒤에 붙은 파라미터 이름으로 변수 가져옴 
		String mNum = req.getParameter("mNum");
		
		ItemService service = ItemService.getInstance();
		
		CafeMenuVO menu = service.showItem(mNum);
		req.setAttribute("menu", menu);
		ArrayList<CafeOptionVO> List = service.getOptions();
		req.setAttribute("List", List);
		
		HttpUtil.forward(req, resp, "./menuInfo.jsp");
	}
}
