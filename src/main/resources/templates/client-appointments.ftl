<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

    <title>My appointments</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light sticky-top"
     style="background-color: #FFE3F5 ">
    <a href="/client/menu" class="navbar-brand">
        <img src="https://image.freepik.com/free-vector/_53876-43323.jpg" width="30" height="30" alt="logo">
    </a>
    <a href="/client/appointments" class="navbar-brand letter"
       style="color: deeppink; font-size:11pt">My appointments</a>
    <a href="/client/master-schedule" class="navbar-brand letter"
       style="color: deeppink; font-size:11pt" >Make an appointment</a>
    <a href="/client/procedures" class="navbar-brand letter"
       style="color: deeppink; font-size:11pt" >Procedures</a>
    <a href="/client/reviews" class="navbar-brand letter"
       style="color: deeppink; font-size:11pt" >Write a review</a>
    <form method="post" action="/logout">
        <input type="hidden"  name="_csrf" value="${_csrf.token}" />
        <p align="center"><button class="btn btn-success" style="background-color: #FFA9EB" type="submit">
            Logout
        </button>
        </p>
    </form>
<#--<form  method="get" action="${pageContext.request.contextPath}/change-language/salon/menu">-->
<#--<label for="language"></label>-->
<#--<select id="language" name="language"-->
<#--onchange="submit()" style="font-size: 11pt; background-color: #FFE3F5; color: deeppink">-->
<#--<option value="en" ${language == 'en' ? 'selected' : ''} style="color: deeppink">English</option>-->
<#--<option value="uk" ${language == 'uk' ? 'selected' : ''} style="color: deeppink">Українська</option>-->
<#--</select>-->
<#--</form>-->
</nav>
<br>

<table>
    <tbody>
    <#list clientAppointments as appointment>
    <tr>
        <td><li>Master: ${appointment.masterId.surnameEn}</li>
            <li>Date: ${appointment.date}</li>
            <li>Time: ${appointment.time}</li>
            <li>Procedure: ${appointment.procedureId.nameEn}</li>
            <li>Price: ${appointment.procedureId.price} UAH</li>
            <hr>
            <br/>
    </tr>
    </#list>
    </tbody>
</table>

<#--<c:forEach var="appointment" items="${requestScope.clientAppointments}">-->
<#--<ul>-->
<#--<li><fmt:message key="appointment.master.name"/>: <c:out value="${appointment.surname}"/></li>-->
<#--<li><fmt:message key="appointment.date"/>: <c:out value="${appointment.date}"/></li>-->
<#--<li><fmt:message key="appointment.time"/>: <c:out value="${appointment.time}"/></li>-->
<#--<li><fmt:message key="appointment.procedure.name"/>: <c:out value="${appointment.procedureName}"/></li>-->
<#--<li><fmt:message key="appointment.procedure.price"/>: <c:out value="${appointment.procedurePrice}"/> <fmt:message key="currency"/></li>-->
<#--</ul>-->
<#--<hr/>-->
<#--</c:forEach>-->

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous">
</script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous">
</script>
</body>
</html>
