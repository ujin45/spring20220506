<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
<title>Insert title here</title>
</head>
<body>

	<h1>${message }</h1>
	<h1>새 직원 입력</h1>
	<form action="${pageContext.request.contextPath }/ex14/sub06" method="post">
		FIRSTNAME : <input type="text" name="firstName" value="Y.J"/> <br />
		LASTNAME : <input type="text" name="lastName" value="KIM"/> <br />
		BIRTHDATE : <input type="date" name="birthDate" value="1990-01-01" /> <br />
		PHOTO : <input type="text" name="photo" /> <br />
		NOTES : <input type="text" name="notes" value="etc." /> <br />
		<button>등록</button>
	</form>


</body>
</html>