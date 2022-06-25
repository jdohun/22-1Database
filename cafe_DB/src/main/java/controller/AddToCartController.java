package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ItemService;
import vo.CartVO;

public class AddToCartController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url ? 뒤에 붙은 파라미터 이름으로 변수 가져옴
		String menu = req.getParameter("menu");
		System.out.println(menu);
		String selectedOption = req.getParameter("selectedOption");
		System.out.println(selectedOption);
		int sumPrice = Integer.parseInt(req.getParameter("sumPrice"));
		System.out.println(sumPrice);
		
		CartVO cart = new CartVO();
		cart.setmNum(menu);
		cart.setcOptions(selectedOption);
		cart.setcQuantity(1);
		cart.setcPrice(sumPrice);
		
		ItemService service = ItemService.getInstance();
		int result = service.insertCart(cart);
		
		if(result == 1) {
			System.out.println("update success");
		}
		
		HttpUtil.forward(req, resp, "./close.jsp");
	}

}
