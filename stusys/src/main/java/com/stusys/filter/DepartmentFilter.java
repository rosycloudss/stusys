package com.stusys.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.stusys.bean.Department;
import com.stusys.service.DepartmentService;
import com.stusys.service.impl.DepartmentAndMajorServiceImpl;

/**
 * 
 * @author LIWEI
 * @time 2018年12月3日上午11:15:13
 * @description:检测session中是否含有院系信息，如果没有则查找院系信息，并存放在session中
 */
@WebFilter("/*")
public class DepartmentFilter implements Filter {
	public DepartmentFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		List<Department> deptList = (List<Department>) session.getAttribute("deptList");
		if (deptList == null) {
			DepartmentService deptService = new DepartmentAndMajorServiceImpl();
			deptList = deptService.queryDepartByParamenters(null, null);
			session.setAttribute("deptList", deptList);
		}
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
