<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Webapp</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/productos">Productos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/carro/ver">Carro de compras (${carro.items.size()})</a>
        </li>
        <c:if test="${not empty sessionScope.username}">
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/usuario/listar">Usuarios</a>
            </li>
        </c:if>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/curso/listar">Cursos</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            ${not empty sessionScope.username? sessionScope.username: "Cuenta"}
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${not empty sessionScope.username? "logout": "login"}">
                ${not empty sessionScope.username? "Logout": "Login"}</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>