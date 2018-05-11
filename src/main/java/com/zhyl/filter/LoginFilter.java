package com.zhyl.filter;

import com.zhyl.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 获取request,response,session对象
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();

		// 获取用户请求的URI
		String path = servletRequest.getRequestURI();

		// 获取session中用户名信息
		User user = (User) session.getAttribute("user_login");
		if(user!=null)
			chain.doFilter(request, response);

		// 判断是否为登陆界面，如果是登陆界面则放行，否则进行用户信息检查
		if(path.indexOf("/login.jsp") >-1 || path.contains("userLogin")) {
			chain.doFilter(request, response);
		}else if(!path.contains(".jsp")&&(path.contains(".css")||path.contains(".js")||path.contains(".ttf")||path.contains(".ico")||path.contains("Mobile"))) {
			chain.doFilter(request, response);
		}else {
			if(user == null) {
				servletResponse.sendRedirect("/AfterSaleService/pages/login.jsp");
				return;
			}
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
