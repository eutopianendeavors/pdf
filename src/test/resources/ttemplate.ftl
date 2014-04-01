
<!--header.ftl-->
<!DOCTYPE html>
<html>
<head>
<title> Facture Modele - ${message}</title>
</head>
<body> 
<br><br>
<hr>
<#if container??>
  <div ="${container}">
<#else>
  <div ="default">
</#if>
<table border="0" width="80%">
<tr>
<td width="50%" height="30%" >
<pre>
<big>
PHARMACIE GABRIEL
DR MOUAFO HILAIRE
BP 8361 DOUALA
Tel: 33415232 
Fax : .
Email : pharmgabriel@yahoo.fr
No Contribuable : .
</big>
</pre>
</td>
<td>
<pre>

Facture No :<big> FAC-2915</big><br>
Date de Facturation :<big> 17-07-2013 10:52</big><br>

Nom du Client : <big>HSIMO LELE FRANKLIN</big>

Nom du Vendeur : <big>manager manager</big><br>

</pre>
</td>
</tr>
<br>
</table>
<table wid><tr><td></td><td></td></tr></table>
<table >
<tr>
<th>index</th>
<td>
<ul>
<#list systems as system>
<li>${system_index + 1}.${system.getName()}</li>
</#list>
</ul>
</td>
</tr>
</table>
<h1>${exampleObject.getName()}</h1>

</div>

<!--footer.ftl-->
</body>
</html> 