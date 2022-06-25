package controller;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	// url에 맞는 controller를 배치
	HashMap<String, Controller> List = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		List = new HashMap<String, Controller>();
		
		// delete Cart
		List.put("/goHome.do", new GoHomeController());
		
		// membership
		List.put("/login.do", new LoginController());
		
		// show
		List.put("/showMenu.do", new ShowMenuController());
		List.put("/menuInfo.do", new MenuInfoController());
		List.put("/showCart.do", new ShowCartController());
		
		// cart & order
		List.put("/addToCart.do", new AddToCartController());
		List.put("/order.do", new OrderController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		Controller subController = List.get(path);
		subController.execute(req, resp);
	}
}