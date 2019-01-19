package com.stusys.servlet.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public final static String ADD = "a";//添加
	public final static String UPDATE = "u";//修改
	public final static String QUERY = "q";//查询
	public final static String DELETE = "d";//删除
	
	public String flagValue = null;//网址访问的标志，一般为 a,d,u,q
	
	public final String flag = "f";
	public PrintWriter out = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		out = response.getWriter();
		flagValue = request.getParameter(flag);//获取flag参数值
		switch (flagValue) {
		case ADD:
			add(request, response);
			break;
		case DELETE:
			delete(request, response);
			break;
		case UPDATE:
			update(request, response);
			break;
		case QUERY:
			query(request, response);
			break;
		default:
			break;
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	/**
	 *  添加
	 * @param request
	 * @param response
	 */
	public abstract void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException; 
	/**
	 * 删除
	 * @param request
	 * @param response
	 */
	public abstract void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException ;
	/**
	 * 修改
	 * @param request
	 * @param response
	 */
	public abstract void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException ;
	/**
	 * 查询
	 * @param request
	 * @param response
	 */
	public abstract void query(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException ;

	/**
	 * 返回提示信息的HTML
	 * 
	 * html 代码为 <html> <script> alert(msg); window.location.href=url </script>
	 * </html>
	 * 
	 * @param response
	 * @param msg
	 * @param url
	 * @throws IOException
	 */
	public void responseHtml(HttpServletResponse response, String msg, String url) throws IOException {
		PrintWriter out = response.getWriter();
		// 返回添加结果
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		out.println("<html>");
		out.println("<script>");
		out.println("alert('" + msg + "');");
		if (url != null) {
			out.println("window.location.href='" + url + "'");
		}
		out.println("</script>");
		out.println("</html>");
		out.flush();
	}

	/**
	 * 返回 json 结果
	 * 
	 * @param response
	 * @param json
	 * @param url
	 * @throws IOException
	 */
	public void responseJson(HttpServletResponse response, String json) throws IOException {
		response.setContentType("application/json;charset=utf-8");// 指定返回的格式为JSON格式
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(json); // 利用json返回删除结果
		out.flush();
	}

}
