<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
 <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
 <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.2/css/jquery.dataTables.css">
 <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 <script type="text/javascript" src="//cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
 <script type="text/javascript" class="init">
	$(document).ready(function() {
	    $('#votos').dataTable({
	    	  "info":     false,
	    	  "paging":   false,
	    	  "oLanguage": {
	    	         "sSearch": "Filtrar resultados:"
	    	       },
	    	  "order": [[ 1, "desc" ]]
	    });
    });
 </script>
</head>
<body>
<br/>
<div class="container">
 <p style="text-align:center">
   <img src="${pageContext.request.contextPath}/resources/judcon2014br.png" alt="logo" width="556"/>
 </p>
 <a class="alert alert-success" href="${pageContext.request.contextPath}/">Resultado dos votos - vote novamente! </a>
 <br/>
 <table id="votos" class="display" cellspacing="0" width="100%">
  <thead>
   <tr>
	<th>Filme</th>
	<th>Votos</th>
   </tr>
  </thead>
  <tbody>
   <c:forEach items="${votos}" var="voto">
	<tr>
	 <td>${voto.filme}</td>
	 <td>${voto.totalDeVotos}</td>
	</tr>
   </c:forEach>
  </tbody>
 </table>
 <br/>
 <p style="text-align:center">
   <img src="${pageContext.request.contextPath}/resources/PoweredMongoDB.png" alt="logo" width="129"/>
 </p>
</div>
</body>
</html>