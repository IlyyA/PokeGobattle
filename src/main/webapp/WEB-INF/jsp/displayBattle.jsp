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
<title>PokeBattle</title>
</head>
<body class="grey lighten-3">
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="<c:url value="js/materialize.min.js" />"></script>
	<h1 align="center">
		<span class="blue-text text-darken-2">Battle Complete!</span>
	</h1>
	<div class="row">
		<div class="col s12">
		
			<div class="card blue lighten-1 z-depth-5">
				<div class="card-content white-text">
					<div class="row">
						<span class="blue accent-2">${pokeChoices.poke1}</span> used
						${moveForm.poke1Move} on <span class="red accent-2">${pokeChoices.pokeEnemy}</span>
						and did ${poke1Damage}! <span class="black">(STAB
							${poke1STAB})</span>
					</div>
					<div class="row">
						<span class="blue accent-2">${pokeChoices.poke2}</span> used
						${moveForm.poke2Move} on <span class="red accent-2">${pokeChoices.pokeEnemy}</span>
						and did ${poke2Damage}! <span class="black">(STAB
							${poke2STAB})</span>
					</div>
					<div class="row">
						<span class="blue accent-2">${pokeChoices.poke3}</span> used
						${moveForm.poke3Move} on <span class="red accent-2">${pokeChoices.pokeEnemy}</span>
						and did ${poke3Damage}! <span class="black">(STAB
							${poke3STAB})</span>
					</div>
					<div class="row">
						<span class="blue accent-2">${pokeChoices.poke4}</span> used
						${moveForm.poke4Move} on <span class="red accent-2">${pokeChoices.pokeEnemy}</span>
						and did ${poke4Damage}! <span class="black">(STAB
							${poke4STAB})</span>
					</div>
					<div class="row">
						<span class="blue accent-2">${pokeChoices.poke5}</span> used
						${moveForm.poke5Move} on <span class="red accent-2">${pokeChoices.pokeEnemy}</span>
						and did ${poke5Damage}! <span class="black">(STAB
							${poke5STAB})</span>
					</div>
					<div class="row">
						<span class="blue accent-2">${pokeChoices.poke6}</span> used
						${moveForm.poke6Move} on <span class="red accent-2">${pokeChoices.pokeEnemy}</span>
						and did ${poke6Damage}! <span class="black">(STAB
							${poke6STAB})</span>
					</div>
				</div>
			</div>
			<p>*STAB refers to Same Type Attack Bonus Modifier</p>
		</div>
			<form:form method="GET" action="/choosePokemon">
		<button class="btn waves-effect waves-light btn-large" type="submit"
			name="action" style="margin-left:auto;margin-right:auto;display:block;margin-top:22%;margin-bottom:0%">
			Fight again!<i class="material-icons right">send</i>
		</button>
	</form:form>
	</div>


</body>
</html>