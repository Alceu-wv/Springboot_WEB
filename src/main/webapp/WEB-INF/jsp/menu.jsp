<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
        <svg xmlns="http://www.w3.org/2000/svg" width="60" height="45" fill="white" class="bi bi-award-fill" viewBox="0 0 16 16">
              <path d="m8 0 1.669.864 1.858.282.842 1.68 1.337 1.32L13.4 6l.306 1.854-1.337 1.32-.842 1.68-1.858.282L8 12l-1.669-.864-1.858-.282-.842-1.68-1.337-1.32L2.6 6l-.306-1.854 1.337-1.32.842-1.68L6.331.864 8 0z"/>
              <path d="M4 11.794V16l4-1 4 1v-4.206l-2.018.306L8 13.126 6.018 12.1 4 11.794z"/>
        </svg>
        <a class="navbar-brand active" href="/">App Times</a>
    </div>
      <ul class="nav navbar-nav">
          <li ><a href="/">Home</a></li>
      <c:if test="${not empty user}">
      	  <li><a href="/usuario/lista">Usuário</a></li>
      	  <li><a href="/dirigente/lista">Dirigentes</a></li>
      	  <li><a href="/tecnico/lista">Técnicos</a></li>
      	  <li><a href="/jogador/lista">Jogadores</a></li>
          <li><a href="/time/lista">Times</a></li>
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty user}">
	      <li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      <c:if test="${not empty user}">
      	  <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${user.nome}!!!</a></li>
      </c:if>
    </ul>
  </div>
</nav>