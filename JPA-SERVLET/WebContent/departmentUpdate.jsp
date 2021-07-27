<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				
					<h1>Department</h1>
					
				</div>
				<div class="col-md-4 col-md-offset-2">
						<a href="employeeController" class="btn btn-secondary" type="button">Employees</a>
						<a href="departmentController" class="btn btn-secondary" type="button">Departments</a>
				</div>
			</div>
			
		</section>
		
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<form class="form-horizontal" action="departmentController" method="post">
							<fieldset>
								
								<legend>Department Update</legend>
								
								<input name="id" type="hidden" value=${department.id}">
								
								<div class="form-group">
									<label class="col-md-4 control-label fpr="name">Name</label>
									<div class="col-md-4">
										<input id="name" name="name" type="text" value="${department.name}"	class="form-control input-md">
									</div>
								
								</div>
								
								
								<div class="form-group">
									<label class="col-md-4 control label" for="add"></label>
									<div class="col-md-4">
										<input type="submit" class="btn btn-info" value="Update Department">
									
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