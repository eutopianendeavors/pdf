<!--header.ftl-->
<!DOCTYPE html>
<html>
<head>
<title>Awards!</title>
</head>
<body style=" margin: auto;">
<h1>${awards[0].getStu_name()}</h1>
<h2>Financial Aid Awards:</h2>
<br></br><br></br>
<br></br><br></br>

<table border="1" width="100%"  cellpadding:4px; cellspacing:5px; color:#808080; style="border-collapse: collapse; background-color:#F5FFFA " >
<tr>
<th align="center" valign="middle" bgcolor="#E5E5E5">Award Year</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Plus Award</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Award Type</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Fall Offered</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Winter Offered</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Spring Offered</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Summer Offered</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Fall Accepted</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Winter Accepted</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Spring Accepted</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Summer Accepted</th>
<th align="center" valign="middle" bgcolor="#E5E5E5">Total Accepted</th>
</tr>
<#list awards as award>
<tr>
<td>${award.getAward_year()}</td>
<td>${award.getPlus_award()}</td>
<td>${award.getAward_name()}</td>
<td>${award.getFall_total()}</td>
<td>${award.getWinter_total()}</td>
<td>${award.getSpring_total()}</td>
<td>${award.getSummer_total()}</td>
<td>${award.getFall_award()}</td>
<td>${award.getWinter_award()}</td>
<td>${award.getSpring_award()}</td>
<td>${award.getSummer_award()}</td>
<td>${award.getYear_total()}</td>
</tr>
</#list>
</table>
</body>
</html> 

