<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<c:choose>
 <c:when test="${vista == 'AltaUsuario'}">
 	Alta de Usuarios<br><br>
    Correo Usuario:<br><input type="text" id="pi_correo" name="pi_correo" pattern="^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$" title="Ingrese un correo electrónico válido!" maxlength="50" required="true"><br><br/>
    <div style="float: right;marging-left:300px;display:none">
    Usuarios registrados:<br><select id="idUsuariosRegistrados" onchange="modificaUsuario()"/>
	</div>
    Password:<br><input type="password" id="pi_password" name="pi_correo"  pattern="[A-Za-z0-9 ]+" title="Solo letras y números" maxlength="30" required="true"><br><br/>
    Confirm Password:<br><input type="password" id="passwordConfirm" name="passwordConfirm" required="true" pattern="[A-Za-z0-9 ]+" title="Solo letras y números" maxlength="30" required="true"><br><br/>
    id Pais:<br><select name="idPais" id="idPais" onchange="listaEstados();"  ></select><br><br/>
    id Estado:<br><select name="pi_idEstado" id="pi_idEstado" onchange="listaDeCiudades();" required="true"></select><br><br/>
    id Ciudad:<br><select name="pi_idCiudad" id="pi_idCiudad" required="true"></select><br><br/>
    Telefono:<br><input type="text" id="telefono" name="telefono" pattern="[0-9 ]+" title="capture número de teléfono ejemplo: 5559609145" maxlength="25" required="true"> <br><br/>
    <input type="submit" >
    <script type="text/javascript">
    listaPaises();
	listaEstados();
	listaDeCiudades();
	listaClientes('idUsuariosRegistrados');
</script>
 </c:when>
 <c:when test="${vista == 'AltaDispositivo'}">
  
    Alta de Dispositivos:
    
    <br><br>Numero de Serie:<br/><input id="pi_numeroSerie" name="pi_numeroSerie" required="true" pattern="[A-Za-z0-9 ]+" title="Solo letras y números" maxlength="50"><br><br/>
    <div style="float: right;marging-left:300px;">
    Usuarios registrados:<br><select id="idDispositivosRegistrados" onchange="modificaDispositivo()"/>
	</div>
    Descripcion:<br/><input id="pi_descripcion" name="pi_descripcion" required="true" pattern="[A-Za-z0-9 ]+" title="Solo letras y números" maxlength="50"><br><br/>
    Fecha de Fabricacion:<br/><input name="pi_fechaFabricacion" id="pi_fechaFabricacion" required="true" maxlength="15"/><br><br/>
    Id contrato:<br/><input name="pi_contrato" id="pi_contrato" required="true" pattern="[A-Za-z0-9 ]+" title="Solo letras y números" maxlength="30"/><br><br/>
    Id Status:<br/><select name="pi_idStatus" id="pi_idStatus" required="true"><option value="1">Activo</option><option value="0">Inactivo</option></select><br><br>
    <input type="submit" >
     <script>
  $(function() {
    $( "#pi_fechaFabricacion" ).datepicker({ dateFormat: "yy-mm-dd" });
  });
  listaDispositivo('idDispositivosRegistrados');
  
  </script>
    
 </c:when>
 <c:when test="${vista == 'AltaEstado'}">
    ALta de Estados:
    
    id Estado:<input id="pi_id" name="pi_id"><br/>
    Nombre:<input name="pi_nombre" name="pi_nombre" required="true"><br/>
    id Pais:<select name="pi_idPais" id="pi_idPais"><option value="1" required="true">México</option></select><br/>
  	id Status:<select name="pi_idStatus" id="pi_idStatus"><option value="1" required="true">Activo</option><option value="2">Inactivo</option></select><br/>
    id Usuario Modifico:<input id="pi_usuarioModifico" name="pi_usuarioModifico" required="true"/><br/>
    <input type="submit" onClick="insertaEstado()">
    
 </c:when>
 <c:when test="${vista == 'AltaPais'}">
    
    <script type='text/javascript' src='../js/administrador.js'></script>
    
    ALta de Paises:
    
    id Pais:<input id="pi_id" name="pi_id" required="true"><br/>
    Nombre:<input name="pi_nombre" name="pi_nombre" required="true"><br/>
    id Status:<select name="pi_idStatus" id="pi_idStatus" required="true"><option value="1">Activo</option><option value="2">Inactivo</option></select><br/>
    id Usuario Modifico:<input id="pi_usuarioModifico" name="pi_usuarioModifico" required="true"/><br/>
    <input type="submit" onClick="insertaPais()">   
 </c:when>
 <c:when test="${vista == 'vistaRegDispositivoUsuario'}">
    Asociacion de Dispositvio con Usuario 
    <br><br>
<!-- 	<input type="hidden" id="pi_id" name="pi_id"> -->
	id Usuario:<br>
    <select name="usuarioSeleccionado" id="usuarioSeleccionado" required="true"></select><br>
    <br>id Dispositivo:<br> 
    <select name = "dispositivoSleccionado"  id="dispositivoSleccionado" required="true"></select>
    <br/>
    <br/>
    id Chip:<br> 
    <select name = "chipSleccionado"  id="chipSleccionado" required="true"></select>
    <br/>
    <br/>
    Tiempo de Actualización:<br>
    <input name = "pi_tiempoActualizacion"  id="pi_tiempoActualizacion" required="true" pattern="[0-9 ]+" title="Solo números" maxlength="3"/>
    <br/>
    <br/>
    Alias de Dispositivo:<br>
    <input name = "pi_aliasDisp"  id="pi_aliasDisp" required="true" pattern="[A-Za-z0-9 ]+" title="Solo letras y números" maxlength="50"/>
    <br/>
    <br/>
    Id Status:<br/><select name="pi_idStatus" id="pi_idStatus" required="true"><option value="1">Activo</option><option value="0">Inactivo</option></select><br><br>
    <input type="submit" >
    <script type="text/javascript">
		listaDispositivo('dispositivoSleccionado');
		listaClientes('usuarioSeleccionado');
		listaChips('chipSleccionado');
	</script>
 </c:when> 
 
 
 <c:when test="${vista == 'AltaChip'}">
    Registro de Chips 
    <br><br>Número de Serie:<br/><input id="pi_numeroSerie" name="pi_numeroSerie" required="true" pattern="[A-Za-z0-9 ]+" title="Solo letras y números" maxlength="50"><br><br/>
    <div style="float: right;marging-left:300px;">
    Chips registrados:<br><select id="idChipsRegistrados" onchange="modificaChip()"/>
	</div>
    Descripcion:<br/><input name="pi_descripcion" id="pi_descripcion" required="true" pattern="[A-Za-z0-9 ]+" title="Solo letras y números" maxlength="50"><br><br/>
    id Compañia Telefonica:<br/><select name="pi_idTelefonica" id="pi_idTelefonica" required="true" maxlength="3"></select><br><br/>
   
   	Número de Teléfono:<br/><input name="pi_numeroTelefonico" id="pi_numeroTelefonico" required="true" pattern="[0-9 ]+" title="Solo números" maxlength="30"><br><br/>
   
    Fecha de fabricación:<br/><input name="pi_fechaFabricacion" id="pi_fechaFabricacion" required="true" maxlength="20"><br><br/>
    Fecha de registro:<br/><input name="pi_fechaRegistro" id="pi_fechaRegistro" required="true" maxlength="20"><br><br/>
  	Status:<br/><select name="pi_idStatus" id="pi_idStatus" required="true"><option value="1">Activo</option><option value="2">Inactivo</option></select><br><br/>

    <input type="submit" >
    <script type="text/javascript">
    $(function() {
        $( "#pi_fechaFabricacion" ).datepicker({ dateFormat: "yy-mm-dd" });
        $( "#pi_fechaRegistro" ).datepicker({ dateFormat: "yy-mm-dd" });
      });
    listaTelefonicas();
    listaChips('idChipsRegistrados');
	</script>
	
 </c:when>
 
 <c:when test="${vista == 'AltaTelefonica'}">
    Registro de Compañia Telefonica
    <br><br>
    <input type="hidden" id="pi_id" name="pi_id">
    Nombre:<br/><input id="pi_nombre" name="pi_nombre" required="true" pattern="[A-Za-z0-9 ]+" title="Solo letras y números" maxlength="50"><br/><br/>
    Descripcion:<br/><input name="pi_descripcion" id="pi_descripcion" required="true" pattern="[A-Za-z0-9 ]+" title="Solo letras y números" maxlength="50"><br/><br/>
  	idStatus:<br/> <select name="pi_idStatus" id="pi_idStatus" required="true"><option value="1">Activo</option><option value="2">Inactivo</option></select>
    <br/>
    <br/>
    <input type="submit" >
	
	
 </c:when>
 
 
 <c:otherwise>
 
 </c:otherwise>
</c:choose>
</html>