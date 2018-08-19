var arrayClientes;
var arrayDispositivo;
var arrayChips;

function  insertaUsuario()
{
	
	pi_correo= $("#pi_correo").val();
	pi_password= $("#pi_password").val();
	idPais= $("#idPais").val();
	pi_idEstado= $("#pi_idEstado").val();
	pi_idCiudad= $("#pi_idCiudad").val();
	telefono= $("#telefono").val();
	
	passwordConfirm = $("#passwordConfirm").val();
	if(pi_password != passwordConfirm){
		alert("Sus contraseñas deben ser iguales!");
	}
	else{
		$.ajax({
			  url: 'insertaUsuario.go',
			  type : "POST",
			  data:{
				  pi_correo:pi_correo,
				  pi_password:pi_password,
				  idPais:idPais,
				  pi_idEstado:pi_idEstado,
				  pi_idCiudad:pi_idCiudad,
				  telefono:telefono
			  },
			  dataType : "json"
		}).done(function( json ) {
			result = json;
			alert(result.descCode);
			if(result.idCode == 30000)
				{
					listaClientes('idUsuariosRegistrados');
					limpiaCampos();
				}
			
		}).fail(function() {
			result = "";
		});
	}
	
	
}

function  insertaDispositivo()
{

	pi_numeroSerie= $("#pi_numeroSerie").val();
	pi_descripcion= $("#pi_descripcion").val();
	pi_fechaFabricacion= $("#pi_fechaFabricacion").val();
	pi_contrato= $("#pi_contrato").val();
	pi_idStatus= $("#pi_idStatus").val();
	
	$.ajax({
				  url: 'insertaDispositivo.go',
				  type : "POST",
				  data:{
					  pi_numeroSerie:pi_numeroSerie,
					  pi_descripcion:pi_descripcion,
					  pi_fechaFabricacion:pi_fechaFabricacion,
					  pi_contrato:pi_contrato,
					  pi_idStatus:pi_idStatus
				  },
				  dataType : "json"
			}).done(function( json ) {
				result = json;
				alert(result.descCode);
				if(result.idCode == 30000){
					limpiaCampos();
					listaDispositivo('idDispositivosRegistrados');
				}
				
			}).fail(function() {
				result = "";
			});
}

function  insertaChip()
{
	pi_numeroSerie= $("#pi_numeroSerie").val();
	pi_descripcion= $("#pi_descripcion").val();
	pi_idTelefonica= $("#pi_idTelefonica").val();
	pi_fechaFabricacion= $("#pi_fechaFabricacion").val();
	pi_fechaRegistro= $("#pi_fechaRegistro").val();
	pi_idStatus= $("#pi_idStatus").val();
	pi_numeroTelefonico = $("#pi_numeroTelefonico").val();
	
	
	$.ajax({
				  url: 'insertaChip.go',
				  type : "POST",
				  data:{
					  pi_numeroSerie:pi_numeroSerie,
					  pi_descripcion:pi_descripcion,
					  pi_idTelefonica:pi_idTelefonica,
					  pi_fechaFabricacion:pi_fechaFabricacion,
					  pi_fechaRegistro:pi_fechaRegistro,
					  pi_numeroTelefonico:pi_numeroTelefonico,
					  pi_idStatus:	pi_idStatus
				  },
				  dataType : "json"
			}).done(function( json ) {
				result = json;
				alert(result.descCode);
				if(result.idCode == 30000)
					{
						limpiaCampos();
						listaChips('idChipsRegistrados');
					}
				
			}).fail(function() {
				result = "";
			});
}

function insertaCompaniaTelefonica(){
	
	
	pi_id = $("#pi_id").val();
	pi_nombre= $("#pi_nombre").val();
	pi_descripcion= $("#pi_descripcion").val();
	pi_idStatus= $("#pi_idStatus").val();
	
	
	$.ajax({
		  url: 'insertaTelefonia.go',
		  type : "POST",
		  data:{
			  pi_id:pi_id,
			  pi_nombre:pi_nombre,
			  pi_descripcion:pi_descripcion,
			  pi_idStatus:pi_idStatus
		  },
		  dataType : "json"
	}).done(function( json ) {
		result = json;
		alert(result.descCode);
		if(result.idCode == 30000)
		limpiaCampos();
	}).fail(function() {
		result = "";
	});
	
}
function  insertaEstado()
{
	pi_id= $("#pi_id").val();
	pi_nombre= $("#pi_nombre").val();
	pi_idPais= $("#pi_idPais").val();
	pi_idStatus= $("#pi_idStatus").val();
	pi_usuarioModifico= $("#pi_usuarioModifico").val();
	
	$.ajax({
				  url: 'insertaEstado.go',
				  type : "POST",
				  data:{
					  pi_id:pi_id,
					  pi_nombre:pi_nombre,
					  pi_idPais:pi_idPais,
					  pi_idStatus:pi_idStatus,
					  pi_usuarioModifico:pi_usuarioModifico
				  },
				  dataType : "json"
			}).done(function( json ) {
				result = json;
				alert(result.descCode);
			}).fail(function() {
				result = "";
			});
}

function  insertaPais()
{
	    
	pi_id= $("#pi_id").val();
	pi_nombre= $("#pi_nombre").val();
	pi_idStatus= $("#pi_idStatus").val();
	pi_usuarioModifico= $("#pi_usuarioModifico").val();
	
	$.ajax({
				  url: 'insertaPais.go',
				  type : "POST",
				  data:{
					  pi_id:pi_id,
					  pi_nombre:pi_nombre,
					  pi_idStatus:pi_idStatus,
					  pi_usuarioModifico:pi_usuarioModifico
				  },
				  dataType : "json"
			}).done(function( json ) {
				result = json;
				alert(result.descCode);
			}).fail(function() {
				result = "";
			});
}


function  relacionaDispositivoCliente()
{
	
	pi_idUsuario = $("#usuarioSeleccionado").val();
	dispositivo = $("#dispositivoSleccionado").val();
	chip = $("#chipSleccionado").val();
	pi_tiempoActualizacion = $("#pi_tiempoActualizacion").val();
	pi_idStatus = $("#pi_idStatus").val();
	pi_aliasDisp = $("#pi_aliasDisp").val();
	
	for (i=0;i<arrayDispositivo.length;i++){
		if(arrayDispositivo[i].fiIdDispositivo==dispositivo){
			//pi_id= arrayDispositivo[i].fiIdDispositivo;
			pi_numeroSerie =arrayDispositivo[i].pi_numeroSerie;
		}
	}
	pi_id=-1;
	for (i=0;i<arrayChips.length;i++){
		if(arrayChips[i].fiIdChip==chip){
			
			pi_serieChip = arrayChips[i].fcNumeroSerie;
			
		}
	}
		
	$.ajax({
				  url: 'relacionaDispositivoCliente.go',
				  type : "POST",
				  data:{
					  pi_id:pi_id,
					  pi_idUsuario:pi_idUsuario,
					  pi_numeroSerie:pi_numeroSerie,
					  pi_aliasDisp:pi_aliasDisp,
					  pi_tiempoActualizacion:pi_tiempoActualizacion,
					  pi_serieChip:pi_serieChip,
					  pi_idStatus:pi_idStatus
				  },
				  dataType : "json"
			}).done(function( json ) {
				result = json;
				alert(result.descCode);
				if(result.idCode == 30000)
				limpiaCampos();
			}).fail(function() {
				result = "";
			});
}
function  listaDispositivo(idDispositivo)
{	
	$.ajax({
				  url: 'listaDispositivos.go',
				  type : "POST",
				  data:{
				  },
				  dataType : "json"
			}).done(function( json ) {
				result = json;
				arrayDispositivo = result;
				listaDispositivos = "";
				for(i=0;i<result.length;i++){
					listaDispositivos += "<option value='"+result[i].fiIdDispositivo+"'>"+result[i].pi_descripcion+"</option>";
				}
				$("#"+idDispositivo).html(listaDispositivos);
			}).fail(function() {
				result = "";
			});
}

function  listaClientes(idSelectUsuarios)
{	
	$.ajax({
				  url: 'listaClientes.go',
				  type : "POST",
				  data:{
				  },
				  dataType : "json"
			}).done(function( json ) {
				result = json;
				arrayClientes=result;
				listaClientesResult = "";
				for(i=0;i<result.length;i++){
					listaClientesResult += "<option value='"+result[i].id_Cliente+"'>"+result[i].pi_correo+"</option>";
				}
				$("#"+idSelectUsuarios).html(listaClientesResult);
				
			}).fail(function() {
				result = "";
			});
}
function  listaTelefonicas()
{	
	$.ajax({
				  url: 'listaTelefonias.go',
				  type : "POST",
				  data:{
				  },
				  dataType : "json"
			}).done(function( json ) {
				result = json;
				listaTelefonicasResult = "";
				for(i=0;i<result.length;i++){
					listaTelefonicasResult += "<option value='"+result[i].fiId +"'>"+result[i].fcNombre +"</option>";
				}
				$("#pi_idTelefonica").html(listaTelefonicasResult);
				
			}).fail(function() {
				result = "";
			});
}

function  listaChips(chipSleccionado)
{	
	$.ajax({
				  url: 'listaChips.go',
				  type : "POST",
				  data:{
				  },
				  dataType : "json"
			}).done(function( json ) {
				result = json;
				arrayChips=result;
				listaChipsResult = "";
				for(i=0;i<result.length;i++){
					listaChipsResult += "<option value='"+result[i].fiIdChip +"'>"+result[i].fcDescripcion +"</option>";
				}
				$("#"+chipSleccionado).html(listaChipsResult);
				
			}).fail(function() {
				result = "";
			});

}

function modificaUsuario(){
	
	pi_idUsuarioModificar = $("#idUsuariosRegistrados").val();

	
	for (i=0;i<arrayClientes.length;i++){
		if(arrayClientes[i].id_Cliente==pi_idUsuarioModificar){
			
			$("#pi_correo").val(arrayClientes[i].pi_correo);
			$("#pi_password").val(arrayClientes[i].pi_password);
			$("#idPais").val(arrayClientes[i].idPais);
			$("#pi_idEstado").val(arrayClientes[i].pi_idEstado);
			$("#pi_idCiudad").val(arrayClientes[i].pi_idCiudad);
			$("#telefono").val(arrayClientes[i].telefono);
			
			
		}
	}
	
}

function modificaDispositivo(){
	
	dispositivo = $("#idDispositivosRegistrados").val();
	
	for (i=0;i<arrayDispositivo.length;i++){
		if(arrayDispositivo[i].fiIdDispositivo==dispositivo){
			$("#pi_numeroSerie").val(arrayDispositivo[i].pi_numeroSerie);
			$("#pi_descripcion").val(arrayDispositivo[i].pi_descripcion);
			$("#pi_fechaFabricacion").val(arrayDispositivo[i].pi_fechaFabricacion.substring(0,10));
			$("#pi_contrato").val(arrayDispositivo[i].pi_contrato);
			$("#pi_idStatus").val(arrayDispositivo[i].pi_idStatus=true?1:0);
			
		}
	}
	
}

function modificaChip(){
	
	chip = $("#idChipsRegistrados").val();
	
	for (i=0;i<arrayChips.length;i++){
		if(arrayChips[i].fiIdChip==chip){
			
			
			$("#pi_numeroSerie").val(arrayChips[i].fcNumeroSerie);
			$("#pi_descripcion").val(arrayChips[i].fcDescripcion);
			$("#pi_idTelefonica").val(arrayChips[i].fiIdTelefonica);
			$("#pi_numeroTelefonico").val(arrayChips[i].pi_numeroTelefonico);
			$("#pi_fechaFabricacion").val(arrayChips[i].fdfechaFabricacion.substring(0,10));
			$("#pi_fechaRegistro").val(arrayChips[i].fdFechaRegistro.substring(0,10));
			$("#pi_idStatus").val(arrayChips[i].fiIdStatus);
			
			
		}
	}
	
}