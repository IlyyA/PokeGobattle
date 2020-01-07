<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Choose Pokémon</title>
</head>
<body class="light-blue lighten-5">
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="js/materialize.min.js" />"></script>
	<h1 align="center">
		<span class="blue-text text-darken-2">Choose Your Pokémon!</span>
	</h1>
	<div class="row">
		<form:form class="col s12" method="POST" action="/choosePokemon"
			modelAttribute="pokeChoices">
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Pikachu" id="poke1" path="poke1" type="text"
						aria-required="true" required="true" />
					<form:errors path="poke1" cssClass="error" />
					<label for="poke1">Choose your first Pokémon</label>
				</div>
				<div class="input-field col s6">
					<form:input placeholder="Raichu" id="pokeEnemy" path="pokeEnemy"
						type="text" aria-required="true" required="true" />
					<form:errors path="pokeEnemy" cssClass="error" />
					<label for="pokeEnemy">Choose the Pokémon you will face
						against</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Charmander" id="poke2" path="poke2" type="text"
						aria-required="true" required="true" />
					<form:errors path="poke2" cssClass="error" element="div"/>
					<label for="poke2">Choose your second Pokémon</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Bulbasaur" id="poke3" path="poke3" type="text"
						aria-required="true" required="true" />
					<form:errors path="poke3" cssClass="error" />
					<label for="poke3">Choose your third Pokémon</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Squirtle" id="poke4" path="poke4" type="text"
						aria-required="true" required="true" />
					<form:errors path="poke4" cssClass="error" />
					<label for="poke4">Choose your fourth Pokémon</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Jynx" id="poke5" path="poke5" type="text"
						aria-required="true" required="true" />
					<form:errors path="poke5" cssClass="error" />
					<label for="poke5">Choose your fifth Pokémon</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<form:input placeholder="Meowth" id="poke6" path="poke6" type="text"
						aria-required="true" required="true" />
					<form:errors path="poke6" cssClass="error" />
					<label for="poke6">Choose your final Pokémon!</label>
				</div>
			</div>
			<div class="row">
				<button class="btn waves-effect waves-light btn-large" type="submit"
					name="action"
					style="margin-left: auto; margin-right: auto; display: block; margin-top: 8%; margin-bottom: 0%">
					Submit Pokémon!<i class="material-icons right">send</i>
				</button>
			</div>
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
