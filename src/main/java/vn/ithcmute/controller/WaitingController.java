package vn.ithcmute.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.ithcmute.model.UserModel;
@SuppressWarnings("serial")
@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("acc") != null) {
			UserModel u=(UserModel) session.getAttribute("acc");
			req.setAttribute("username", u.getUname());
			if(u.getIsAd()==1){
				resp.sendRedirect(req.getContextPath()+"/admin/dashboard");
			} else if (u.getIsSel()==1){
				resp.sendRedirect(req.getContextPath()+"/home");
			} else {
				resp.sendRedirect(req.getContextPath()+"/home");
			}
		}else {
			resp.sendRedirect(req.getContextPath()+"/login");
		}
	}
}