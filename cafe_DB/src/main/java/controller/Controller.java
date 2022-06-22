package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
