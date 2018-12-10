package com.stusys.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class SemesterFilter
 */
@WebFilter("/*")
public class SemesterFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SemesterFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		List<String> semesterList = (List<String>) req.getSession().getAttribute("semesterList");
		if (semesterList == null) {
			semesterList = new ArrayList<String>();
			Date nowDate = new Date(System.currentTimeMillis());
			int year = nowDate.getYear() + 1900;
			int month = nowDate.getMonth() + 1;

			for (int i = 10; i > 0; i--) {
				if (i == 10) {
					if (month < 6) {
						semesterList.add((year - 1) + "-" + year + " 第二学期");
					} else {
						semesterList.add(year + "-" + (year + 1) + " 第一学期");
						semesterList.add((year - 1) + "-" + year + " 第二学期");
					}
				} else {
					semesterList.add(year + "-" + (year + 1) + " 第一学期");
					semesterList.add((year - 1) + "-" + year + " 第二学期");
				}
				year--;
			}
			req.getSession().setAttribute("semesterList", semesterList);
			req.getSession().setAttribute("currentSemester", semesterList.get(0));
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
