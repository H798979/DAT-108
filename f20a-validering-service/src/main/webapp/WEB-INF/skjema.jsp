<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="simple.css">
<title>Gyldig brukernavn</title>
</head>
<body>
	<p style="color:red;">${feilmelding}</p>
	<form action="sjekkBrukernavn" method="get">
		Brukernavn: <input type="text" name="brukernavn"> 
		<input type="submit" value="Sjekk!">
	</form>
</body>
</html>