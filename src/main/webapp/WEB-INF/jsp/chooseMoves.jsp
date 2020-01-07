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
<title>PokeBattle: Choose Moves</title>
</head>
<body class="grey lighten-3">
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="js/materialize.min.js" />"></script>
	<script>
		$(document).ready(function() {
			$('select').material_select();
		});
	</script>
	<h1 align="center">
		<span class="blue-text text-darken-2">Choose Your Moves!</span>
	</h1>
	<form:form method="POST" action="/chooseMoves"
		modelAttribute="moveForm">
		<div class="row">
			<div class="col s6">
				<label>${pokeChoices.poke1}</label>
				<form:select path="poke1Move" items="${p1Moves}" />
			</div>
			<div class="col s6">
				<td>Pokemon you are fighting: ${enemyName}</td>
			</div>
		</div>
		<div class="row">
			<div class="col s6">
				<label>${pokeChoices.poke2}</label>
				<form:select path="poke2Move" items="${p2Moves}" />
			</div>
		</div>
		<div class="row">
			<div class="col s6">
				<label>${pokeChoices.poke3}</label>
				<form:select path="poke3Move" items="${p3Moves}" />
			</div>
		</div>
		<div class="row">
			<div class="col s6">
				<label>${pokeChoices.poke4}</label>
				<form:select path="poke4Move" items="${p4Moves}" />
			</div>
		</div>
		<div class="row">
			<div class="col s6">
				<label>${pokeChoices.poke5}</label>
				<form:select path="poke5Move" items="${p5Moves}" />
			</div>

		</div>
		<div class="row">
			<div class="col s6">
				<label>${pokeChoices.poke6}</label>
				<form:select path="poke6Move" items="${p6Moves}" />
			</div>
		</div>
		<div class="row">
			<button class="btn waves-effect waves-light btn-large" type="submit"
				name="action"
				style="margin-left: auto; margin-right: auto; display: block; margin-top: 8%; margin-bottom: 0%">
				Submit Pokémon Moves!<i class="material-icons right">send</i>
			</button>
		</div>
	</form:form>
</body>
</html>