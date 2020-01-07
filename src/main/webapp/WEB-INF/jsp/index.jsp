<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="<c:url value="css/materialize.min.css" />"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>PokeBattle</title>
</head>
<body class="grey lighten-3">
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="js/materialize.min.js" />"></script>
				<h1 align="center"><span class="blue-text text-darken-2">PokeBattle: A Java WebApp</span></h1>
	<div align="center" style="width:100%;height:100%;position:absolute;vertical-align:middle;text-align:center;">
	<form:form method="GET" action="/choosePokemon">
		<button class="btn waves-effect waves-light btn-large" type="submit"
			name="action" style="margin-left:auto;margin-right:auto;display:block;margin-top:22%;margin-bottom:0%">
			Get Started <i class="material-icons right">send</i>
		</button>
	</form:form>
	</div>
</body>
</html>
<%-- 
		$.ajax({
			success: function(data){
				$('input.autocomplete').autocomplete({
					source: poke,
					limit: 20
				});
			}
		});
				$('input.autocomplete').autocomplete({
			source: poke,
			limit: 20
		});
		
			<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
		
			<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<link rel="stylesheet"
		href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
--%>
