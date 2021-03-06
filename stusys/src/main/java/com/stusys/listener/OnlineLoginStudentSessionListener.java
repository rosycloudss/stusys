package com.stusys.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.stusys.bean.Student;

@WebListener
public class OnlineLoginStudentSessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * 
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSessionAttributeListener.super.attributeAdded(event);

	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		HttpSessionAttributeListener.super.attributeRemoved(event);
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		HttpSessionAttributeListener.super.attributeReplaced(event);
	}

	public void sessionCreated(HttpSessionEvent se) {
		HttpSessionListener.super.sessionCreated(se);
	}

	/**
	 * 当会话结束后，将退出的student从servletContext中移除
	 */
	@SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSessionListener.super.sessionDestroyed(se);
		HttpSession session = se.getSession();
		ServletContext servletContext = session.getServletContext();
		List<Student> onlineStudentList = (ArrayList<Student>) servletContext.getAttribute("onlineStudentList");
		Student onlineStudent = (Student) session.getAttribute("student");
		if (onlineStudentList != null && onlineStudent != null) {
			onlineStudentList.remove(onlineStudent);
			System.out.println("退出 登录");
		}
	}

}
