package org.spring.springboot.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.Interceptor.TestInterceptor;
import org.springframework.core.annotation.Order;

/**
 * @Description: 过滤器
 * @author harry.zhang
 * @CreateDate: 2017年8月4日
 * @version 1.0
 */
@Order(1) // 表示执行过滤顺序，值越小，越先执行
@WebFilter(filterName = "testFilterFirst", urlPatterns = "/*")
public class TestFilterFirst implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(TestInterceptor.class);

	/**
	 * 封装，不需要过滤的list列表
	 */
	protected static List<Pattern> patterns = new ArrayList<Pattern>();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
		String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if (url.startsWith("/") && url.length() > 1) {
			url = url.substring(1);
		}

		logger.info("------TestFilterFirst---uri:"+url+"-------------------------------");
		if (isInclude(url)) {
			chain.doFilter(httpRequest, httpResponse);
			return;
		} else {
			HttpSession session = httpRequest.getSession();
			if (session.getAttribute("") != null) {
				// session存在
				chain.doFilter(httpRequest, httpResponse);
				return;
			} else {
				// session不存在 准备跳转失败
				/*
				 * RequestDispatcher dispatcher =
				 * request.getRequestDispatcher(path);
				 * dispatcher.forward(request, response);
				 */
				chain.doFilter(httpRequest, httpResponse);
				return;
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * 是否需要过滤
	 * 
	 * @param url
	 * @return
	 */
	private boolean isInclude(String url) {
		for (Pattern pattern : patterns) {
			Matcher matcher = pattern.matcher(url);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}

}
