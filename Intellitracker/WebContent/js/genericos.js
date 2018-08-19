var dataForm;

function vistaRegistroUsr(){

	$.ajax({
		  url: 'vistaRegistroUsr.go',
		  type : "POST",
		  data:{}
	}).done(function( json ) {
		result = json;
		 $("#idContenedor").html(result);
		 $("#idContenedor").attr('onsubmit','insertaUsuario();return false');
		 dataForm = document.getElementById('idContenedor');
	}).fail(function() {
		result = "";
	});
	
}

function vistaRegistroChip(){

	$.ajax({
		  url: 'vistaInsertaChip.go',
		  type : "POST",
		  data:{}
	}).done(function( json ) {
		result = json;
		 $("#idContenedor").html(result);
		 $("#idContenedor").attr('onsubmit','insertaChip();return false');
		 dataForm = document.getElementById('idContenedor');
	}).fail(function() {
		result = "";
	});
	
}

function vistaRegTelefonica(){
	$.ajax({
		  url: 'vistaRegistraTelefinica.go',
		  type : "POST",
		  data:{}
	}).done(function( json ) {
		result = json;
		 $("#idContenedor").html(result);
		 $("#idContenedor").attr('onsubmit','insertaCompaniaTelefonica();return false');
		 dataForm = document.getElementById('idContenedor');
	}).fail(function() {
		result = "";
	});
}

function vistaRegistroDispositivo(){
	$.ajax({
		  url: 'vistaRegistroDispositivo.go',
		  type : "POST",
		  data:{}
	}).done(function( json ) {
		result = json;
		 $("#idContenedor").html(result);
		 $("#idContenedor").attr('onsubmit','insertaDispositivo();return false');
		 dataForm = document.getElementById('idContenedor');
	}).fail(function() {
		result = "";
	});
}

function vistaRegDispositivoUsuario(){
	
	$.ajax({
		  url: 'vistaRegDispositivoUsuario.go',
		  type : "POST",
		  data:{}
	}).done(function( json ) {
		result = json;
		 $("#idContenedor").html(result);
		 $("#idContenedor").attr('onsubmit','relacionaDispositivoCliente();return false');
		 dataForm = document.getElementById('idContenedor');
	}).fail(function() {
		result = "";
	});
}

function listaDeCiudades()
{
	in_idEstado = $("#pi_idEstado").val();
	$.ajax({
		  url: 'listaCiudades.go',
		  type : "POST",
		  data:{ in_idEstado:in_idEstado
		  },
		  async:false,
		  dataType : "json"
	}).done(function( json ) {
		result = json;
		listaCiudadesResult = "";
		for(i=0;i<result.length;i++){
			listaCiudadesResult += "<option value='"+result[i].fiId+"'>"+result[i].ciudad+"</option>";
		}
		$("#pi_idCiudad").html(listaCiudadesResult);
	}).fail(function() {
		result = "";
	});
}

function listaEstados()
{
	in_idPais = $("#idPais").val();
	$.ajax({
		  url: 'listaEstados.go',
		  type : "POST",
		  data:{ in_idPais:in_idPais
		  },
		  async : false,
		  dataType : "json"
	}).done(function( json ) {
		result = json;
		listaEstadosResult = "";
		for(i=0;i<result.length;i++){
			listaEstadosResult += "<option value='"+result[i].pi_id+"'>"+result[i].pi_nombre+"</option>";
		}
		$("#pi_idEstado").html(listaEstadosResult);
		
	}).fail(function() {
		result = "";
	});
}

function listaPaises()
{
	$.ajax({
		  url: 'listaPaises.go',
		  type : "POST",
		  data:{
		  },
		  async:false,
		  dataType : "json"
	}).done(function( json ) {
		result = json;
		listaPaisesResult = "";
		for(i=0;i<result.length;i++){
			listaPaisesResult += "<option value='"+result[i].pi_id+"'>"+result[i].pi_nombre+"</option>";
		}
		$("#idPais").html(listaPaisesResult);
	}).fail(function() {
		result = "";
	});
}


function limpiaCampos()
{
	//document.getElementById("").reset();
	$("#idContenedor").get(0).reset()
}