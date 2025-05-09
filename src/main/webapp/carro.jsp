<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="layout/header.jsp"/>

<style>
    /* Selecciona todas las celdas (td) que sean la tercera en su fila */
    table td:nth-child(3),table td:nth-child(4),table td:nth-child(5) {
      text-align: right;
    }
    table th:nth-child(3),table th:nth-child(4),table th:nth-child(5) {
      text-align: right;
    }
</style>
        
<c:choose>
    <%--
    <c:when test="${sessionScope.carro == null || sessionScope.carro.items.isEmpty()}">
    --%>
    <c:when test="${carro.items.isEmpty()}">
        <div class="alert alert-warning">No hay productos en el carro de compras</div>
    </c:when>
    <c:otherwise>
        <form name="formCarro" action="${pageContext.request.contextPath}/carro/actualizar" method="post">

            <table class="table table-striped table-hover">
                <thead class="thead-dark">
                    <tr>
                        <th>id</th>
                        <th>nombre</th>
                        <th>precio</th>
                        <th>cantidad</th>
                        <th>total</th>
                        <th>borrar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${carro.items}" var="item" >
                        <tr>
                            <td>${item.producto.id}
                                <input type="hidden" name="id_producto" value="${item.producto.id}"/></td>
                            <td>${item.producto.nombre}</td>
                            <td>${item.producto.precio}</td>
                            <td><input type="text" size="4" name="cant_1" class="form-control text-end"
                                       value="${item.cantidad}"/></td>
                            <td>${item.importe}</td>
                            <td><input type="checkbox" name="delete_producto" class="form-checkbox"
                                       value="${item.producto.id}"/></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Total:</td>
                        <td>${carro.total}</td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            <a href="javascript:document.formCarro.submit()"
            class="btn btn-primary w-100">Guardar cambios</a>

        </form>
    </c:otherwise>
</c:choose>
<div class="my-2">
    <a class="btn btn-success" href="${pageContext.request.contextPath}/productos">Seguir comprando</a>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/index.jsp">Volver</a></p>
</div>
        
<jsp:include page="layout/footer.jsp"/>
