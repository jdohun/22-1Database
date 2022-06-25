package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ItemService;

public class OrderController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userPhoneNumber = (String)req.getSession().getAttribute("userPhoneNumber");
		
		ItemService service = ItemService.getInstance();
		int result = service.order(userPhoneNumber);
		
		if(result == 1) {
			System.out.println(userPhoneNumber + " : 주문완료");
			HttpUtil.forward(req, resp, "./goHome.do");
		}
	}
}
