<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppTimes</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:set var="botao" value=""/>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	  <h2>Cadastro de Time</h2>
	  <form action="/time/incluir" method="post">

		  <div class="form-group">
			  <label>Nome do time:</label>
			  <input value="Peladeiros da Infnet" type="text" class="form-control" placeholder="Entre com o nome do time" name="nome">
		  </div>

		  <div class="form-group">
			  <c:if test="${not empty dirigentes}">
				  <label>Dirigente:</label>
				  <select class="form-control" name="dirigente">
					  <c:forEach var="d" items="${dirigentes}">
						  <option value="${d.id}">${d.nome}</option>
					  </c:forEach>
				  </select>
			  </c:if>
			  <c:if test="${empty dirigentes}">
				  <c:set var="botao" value="disabled"/>
				  <label>Dirigente: não existem registros cadastrados!!!</label>
			  </c:if>
		  </div>

		  <div class="form-group">
			  <c:if test="${not empty tecnicos}">
				  <label>Técnico:</label>
				  <select class="form-control" name="tecnico">
					  <c:forEach var="t" items="${tecnicos}">
						  <option value="${t.id}">${t.nome}</option>
					  </c:forEach>
				  </select>
			  </c:if>
			  <c:if test="${empty tecnicos}">
				  <c:set var="botao" value="disabled"/>
				  <label>Técnicos: não existem registros cadastrados!!!</label>
			  </c:if>
		  </div>

		  <div class="form-group">
			  <c:if test="${not empty jogadores}">
				  <label>Jogadores:</label>
				  <c:forEach var="j" items="${jogadores}">
					  <div class="form-check">
						  <label class="form-check-label">
							  <input name="jogadoresId" type="checkbox" checked="checked" value="${j.id}"> ${j.nome}
						  </label>
					  </div>
				  </c:forEach>
			  </c:if>
			  <c:if test="${empty jogadores}">
				  <c:set var="botao" value="disabled"/>
				  <label>Jogadores: não existem registros cadastrados!!!</label>
			  </c:if>
		  </div>

		  <button type="submit" ${botao} class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

</body>
</html>