<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Update</title>

<script src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Employee</h1>
				<div class="col-md-4 col-md-offset-2">
				<a href="employeeController" class="btn btn-secondary" type="button">Employees</a>
				<a href="departmentController" class="btn btn-secondary" type="button">Departments</a>
			</div>
			</div>		
		</div>
	</section>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<form class="form-horizontal" action="employeeController"
							method="POST">
							<fieldset>

								<!-- Form Name -->
								<legend>Employee Update</legend>

								<!-- Text input-->
								<input name="id" type="hidden" value="${employee.id}">

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="name">Name</label>
									<div class="col-md-4">
										<input id="name" name="name" type="text" value="${employee.name}"
											class="form-control input-md">

									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="surname">Surname</label>
									<div class="col-md-4">
										<input id="surname" name="surname" type="text" value="${employee.surname}"
											class="form-control input-md">

									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="salary">Salary</label>
									<div class="col-md-4">
										<input id="salary" name="salary" type="number" value="${employee.salary}"
											class="form-control input-md"/>

									</div>
								</div>
								
									<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="surname">Title</label>
									<div class="col-md-4">
										<input id="title" name="title" type="text" value="${employee.title}"
											class="form-control input-md">

									</div>
								</div>

								

								<div class="form-group">
									<label class="col-md-4 control-label" for="department">Department</label> 
									<div class="col-md-4">
									<select class="form-control " id="department" name="department">
									<option><c:out value="${employee.department.name}" /></option>
										<c:forEach items="${allDepartments}" var="department">
											<option><c:out value="${department.name}" /></option>
										</c:forEach>
									</select>
									</div>
								</div>

								<!-- Button -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="add"></label>
									<div class="col-md-4">
										<input type="submit" class="btn btn-info" value="Update Employee">
									</div>
								</div>

							</fieldset>
						</form>
					</div>
					<div class="col-md-6">
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>