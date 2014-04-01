<!--header.ftl-->
<!DOCTYPE html>
<html>
<head>
<title> Invoice model - ${message}</title>
</head>
<body style=" margin: auto;"> 
<table  style="background-color:#F5FFFA ; border-collapse: collapse; color:#808080; width:100%; height:50px " >
<tr>
<td width="25%"><img src="stbr.gif" alt="logo" width="100%"></img></td>
<td valign="middle"><h1>invoice</h1></td>
</tr>
</table>

<br></br><br></br>
<br></br><br></br>

<#if container??>
  <div ="${container}">
<#else>
  <div ="default">
</#if>
<table border="0" width="90%" style="color:#808080">
<tr>
<td  width="60%"><h2>Company Name</h2></td>
<td>Bill No : <strong> FAC-2915</strong></td>
</tr>
<tr>
<td  width="60%"><strong>Other name </strong></td>
<td></td>
</tr>
<tr>
<td  width="60%"><strong>Adress</strong></td>
<td></td>
</tr>
<tr>
<td width="60%"><strong>Telephone number</strong></td>
<td></td>
</tr>
<tr>
<td width="60%">Fax : .</td>
<td>Date de Facturation : <strong>  17-07-2013 10:52</strong> 
</td>
</tr>
<tr>
<td width="60%">Email : <strong>emailadress@site.domain</strong></td>
<td>Nom du Client : <strong>${custname}</strong></td>
</tr>
<tr>
<td width="60%">No Contribuable : <strong>.</strong></td>
<td>Nom du Vendeur :<strong> ${selname}</strong></td>
</tr>
</table>

<br/><br/><br></br>

<table border="1" width="100%"  cellpadding:4px; cellspacing:5px; color:#808080; style="border-collapse: collapse; background-color:#F5FFFA " >
<tr>
<th width="15%" align="center" valign="middle" bgcolor="#E5E5E5">Reference</th>
<th width="15%" align="center" valign="middle" bgcolor="#E5E5E5">Designation</th>
<th width="15%" align="center" valign="middle" bgcolor="#E5E5E5">Quantité</th>
<th width="15%" align="center" valign="middle" bgcolor="#E5E5E5">Prix unitaire</th>
<th width="15%" align="center" valign="middle" bgcolor="#E5E5E5">Montant</th>
<th width="15%" align="center" valign="middle" bgcolor="#E5E5E5">TVA</th>
</tr>

<#list systems as system>
<tr>
<td>${system.getRef()}</td>
<td>${system.getDesign()}</td>
<td>${system.getQte()}</td>
<td>${system.getPrixu()}</td>
<td>${system.getMontHT()}</td>
<td>${system.getTVA()}</td>
</tr>
</#list>


</table>


<br/><br/><br></br>

<table width="100%">
<tr>
<td valign="middle" width="60%" style=" color:#808080 " > <strong>  Paiement à 15 jours dès reception de la facture</strong>  </td>

<td style="margin-left: 5px; color:#808080 ">

Montant total HT : <strong>  ${" ${montHT} €"}</strong>  <br></br>
Montant total TVA : <strong>  ${montTVA} €</strong>  <br></br>
Montant total TTC :<strong>  ${montTTC} €</strong>  <br></br>
(-)Acompte : <strong>  0.00€</strong>  <br></br>
<strong>  Net à payer  : ${montTTC} €</strong> <br></br>
</td>
</tr>
</table>

<br></br><br></br>
<br></br><br></br>

<table width="100%" style="padding:5px; border:1px dashed blue ; background-color:#F5FFFA; color:#808080 ">
<tr>
<td>

Cordonnées bancaires :<br></br>
banque :<strong> XXXXXXXXX </strong>   Guichet : <strong>  XXXXXXXXXXXX</strong>  <br></br>
compte :<strong>   XXXXXXXXXXXXXX </strong>     cle :<strong>   XXXX</strong>  <br></br>

</td>
<td valign="middle"><strong>  Penalités en cas de retard : 1.5 fois le taux de l'interet en vigueur</strong> </td>
</tr>
</table>
</div>

<!--footer.ftl-->
</body>
</html> 

