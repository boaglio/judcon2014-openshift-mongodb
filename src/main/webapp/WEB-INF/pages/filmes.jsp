<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.2/css/jquery.dataTables.css">
<script	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" language="javascript" src="//cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" class="init">
	$(document).ready(function() {
	    $('#filmes').dataTable({
	    	  "info":     false,
	    	  "paging":   false,
	    	  "oLanguage": {
	    	         "sSearch": "Filtrar resultados:"
	    	       }
	    });
    });
</script>
</head>
<body>
<div class="container">
 <p style="text-align:center">
   <img src="${pageContext.request.contextPath}/resources/judcon2014br.png" alt="logo" width="556"/>
 </p>

 <a  class="btn btn-primary btn-lg"  href="javascript:history.back()">Voltar</a>

 <table id="filmes" class="display" cellspacing="0" width="100%">
  <thead>
   <tr>
	<th>Clique no filme para votar! </th>
   </tr>
  </thead>
  <tbody>
   <c:forEach items="${filmes}" var="filme">
	<tr>
	 <td><a href="votar?id=${filme.id}">${filme.titulo}</a></td>
	</tr>
   </c:forEach>
  </tbody>
 </table>
 <br/>
  <div class="alert alert-warning alert-dismissible" >Exibindo at&eacute; 100 resultados <span class="sr-only">Close</span></div>
 <a  class="btn btn-primary btn-lg"  href="javascript:history.back()">Voltar</a>
 <br/>
 <p style="text-align:center">
   <img src="${pageContext.request.contextPath}/resources/PoweredMongoDB.png" alt="logo" width="129"/>
 </p>
</div>
</body>
</html>