package com.sof3021_assignment.demo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sof3021_assignment.demo.entities.Account;
@Component
public class AuthenInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Account account = (Account) request.getSession().getAttribute("userLogin");
		if (account == null) {
			response.sendRedirect("/sof3021_assignment/login");
			return false;
		} else if (account.getAdmin() != 1) {
			response.sendRedirect("/sof3021_assignment/admin/index");
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
