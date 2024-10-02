<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="../assets/menu.css" />
    <title>Editar Instrumento</title>
  </head>
  <body>
    <jsp:include page="menu.jsp"></jsp:include>
    Editar datos del registro:
    <br />
    <form action="ServletGuardarCambiosInstrumento" method="post">
      <label for="nombre">Nombre:</label
      ><input
        type="text"
        name="nombre"
        id="nombre"
        value="${instrumento.nombre }"
      /><br />
      <label for="tipo">Tipo:</label
      ><input
        type="text"
        name="tipo"
        id="tipo"
        value="${instrumento.tipo }"
      /><br />
      <label for="marca">Marca:</label
      ><input
        type="text"
        name="marca"
        id="marca"
        value="${instrumento.marca }"
      /><br />
      <label for="description">Descripcion:</label
      ><textarea name="description" id="description" rows="3" cols="12">
${instrumento.desc }</textarea
      ><br />

      <label for="gamma">Gamma:</label
      ><select name="gamma" id="gamma">
        <option value="Baja">Baja</option>
        <option value="Media">Media</option>
        <option value="Alta">Alta</option></select
      ><br />
      <label for="precio">Precio</label
      ><input
        type="number"
        name="precio"
        id="precio"
        step="any"
        min="0"
        value="${instrumento.precio }"
      /><br />
      <input type="hidden" name="id" value="${instrumento.id }" />
      <input type="submit" value="GUARDAR CAMBIOS" style="margin-top: 1rem" />
    </form>
  </body>
</html>
