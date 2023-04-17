<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pacientes</title>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
		
		<ul class="navbar-nav">
			<li><a class="nav-link" href="<%= request.getContextPath()%>/list">Pacientes</a></li>l
		</ul>
	</nav>
	
	<br>
	
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${paciente != null }">
					<form action="update" method="post">
				</c:if>
				<c:if test="${paciente == null }">
					<form action="insert" method="post">
				</c:if>
				
				<caption>
					<h2>
						<c:if test="${paciente != null }">
							Editar paciente
						</c:if>
						<c:if test="${paciente == null }">
							Agregar nuevo paciente
						</c:if>
					</h2>
				</caption>
				
				
				<c:if test="${paciente != null }">
					<input type="hidden" name="id" value="<c:out value='${paciente.id }' />" />
				</c:if>
				
				
				<fieldset class="form-group">
					<label>Nombre de paciente</label> <input type="text" value="<c:out value='${usuario.nombre }' /> " class="form-control" name="nombre" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Nombre de paciente</label> <input type="text" value="<c:out value='${usuario.nombre }' /> " class="form-control" name="nombre" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Nombre de paciente</label> <input type="text" value="<c:out value='${usuario.nombre }' /> " class="form-control" name="nombre" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email de Usuario</label> <input type="text" value="<c:out value='${usuario.email }' /> " class="form-control" name="email" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Pais de Usuario</label> <input type="text" value="<c:out value='${usuario.pais }' /> " class="form-control" name="pais" required="required">
				</fieldset>
				
				<br>
				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		
		</div>
	</div>

</body>
</html>