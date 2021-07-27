package com.ugur.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ugur.dao.DepartmentDAO;
import com.ugur.dao.DepartmentDAOImpl;
import com.ugur.model.Department;

@WebServlet("/departmentController")
public class DepartmentController extends HttpServlet{

	private static String LIST = "/department.jsp";
	private static String UPDATE = "/departmentUpdate.jsp";
	
	private DepartmentDAO departmentService;
	private Department department;
	
	public DepartmentController() {

		super();
		
		departmentService = new DepartmentDAOImpl();
		department = departmentService.insertDepartment("IT");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String forward = "";
		String action = req.getParameter("action");
		if(action==null) {
			
			List<Department> allDepartments = departmentService.findAllDepartments();
			req.setAttribute("allDepartments", allDepartments);
			forward=LIST;
		}
		else if(action.equals("insert")) {
			forward = LIST;
		}
		else if(action.equals("delete")) {
			int id = Integer.parseInt(req.getParameter("departmentId"));
			departmentService.deleteDepartment(id);
			forward = LIST;
			
			req.setAttribute("allDepartments", departmentService.findAllDepartments());
		}
		
		else if(action.equals("update")) {
			forward = UPDATE;
			int id = Integer.parseInt(req.getParameter("departmentId"));
			req.setAttribute("department", departmentService.findDepartment(id));
			
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(forward);
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String departmentId = req.getParameter("id");
		String departmentName = req.getParameter("name");
		
		if(departmentId==null) {
			departmentService.insertDepartment(departmentName);
		}
		else {
			int id = Integer.parseInt(departmentId);
			departmentService.updateDepartment(id, departmentName);
		}
		
		List<Department> departmentList = departmentService.findAllDepartments();
		req.setAttribute("allDepartments", departmentList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(LIST);
		dispatcher.forward(req, resp);
	}
}
