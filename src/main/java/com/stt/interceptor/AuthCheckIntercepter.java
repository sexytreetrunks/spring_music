package com.stt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.stt.domain.AuthVO;

public class AuthCheckIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession();
		if(session!=null) {
			AuthVO user = (AuthVO) session.getAttribute("user");
			if(user!=null)
				return true;
		}
		res.sendRedirect(req.getContextPath()+"/login");
		return false;
	}
}
