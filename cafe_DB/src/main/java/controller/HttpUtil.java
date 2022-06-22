package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HttpUtil {
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path) {
		RequestDispatcher rd = req.getRequestDispatcher(path);
		try {
			rd.forward(req, resp);
		} catch (Exception e) {
			System.out.print("forward 오류:" + e);
		}
	}
}