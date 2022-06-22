package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ItemService;
import vo.CafeMenuVO;

public class GoHomeController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "index.jsp";		// 서비스가 끝나면 되돌아 갈 url
		//boolean result = false;		// 서비스의 성공 여부

		HttpUtil.forward(req, resp, path);
	}

}
