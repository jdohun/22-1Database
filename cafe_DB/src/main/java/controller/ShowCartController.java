package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ItemService;
import vo.CartVO;

public class ShowCartController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ItemService service = ItemService.getInstance();
		
		ArrayList<CartVO> List = service.getCart();
		
		req.setAttribute("List", List);
		
		HttpUtil.forward(req, resp, "./cart.jsp");
	}
}
