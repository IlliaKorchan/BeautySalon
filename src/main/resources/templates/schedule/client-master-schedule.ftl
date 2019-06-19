
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

    <#--<title><fmt:message key="title.schedule"/></title>-->
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light sticky-top"
     style="background-color: #FFE3F5 ">
    <a href="/client/menu" class="navbar-brand">
        <img src="https://image.freepik.com/free-vector/_53876-43323.jpg" width="30" height="30" alt="logo">
    </a>
    <a href="/client/appointments" class="navbar-brand letter"
       style="color: deeppink; font-size:11pt">My appointments</a>
    <a href="/client/make-appointment" class="navbar-brand letter"
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
</nav>
<br>

<form method="post" action="/client/make-appointment/choose-master">
    <p align="center" style="color: deeppink"> Choose master
        <#--<fmt:message key="choose.master"/><br>-->
        <select id="surnameEn" name="surnameEn"
                style="font-size: 11pt; background-color: #FFE3F5; color: deeppink">
            <#list masters as m>
                <option value="${m.surnameEn}">${m.surnameEn}</option>
            </#list>

        </select>
        <br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-success" style="background-color: #FFA9EB" type="submit">
            Find
        </button>
    </p>
</form>

<#--<form method="post" action="">-->
    <p style="color: deeppink" align="center"><fmt:message key="choose.date"/><br>
        <select id="workingDays" name="workingDays"
                style="font-size: 11pt; background-color: #FFE3F5; color: deeppink" onchange="">
            <#list workingDays as w>
                <#--<#list w.masterId as master>-->
                <#--<option value="${master.surnameEn}">${master.surnameEn}</option>-->
                <option value="${w}">${w}</option>
                <#--</#list>-->
            </#list>
            <#--<c:forEach var="day" items="${requestScope.workingDays}">-->
                <#--<option value="${day}" style="color: deeppink">${day}</option>-->
            <#--</c:forEach>-->
        </select>
        <br><br>
        <button class="btn btn-success" style="background-color: #FFA9EB" type="submit">
            <input type="hidden" value="_csrf" >
            Find
        </button>
    </p>
<#--</form>-->

<#--<form method="post" action="${pageContext.request.contextPath}/salon/make-appointment">-->
    <#--<p align="center"><fmt:message key="choose.procedure"/><br>-->
        <#--<select id="selectedProcedure" name="selectedProcedure"-->
                <#--style="font-size: 11pt; background-color: #FFE3F5; color: deeppink">-->
            <#--<c:forEach var="procedure" items="${requestScope.procedures}">-->
                <#--<option value="${procedure.name}" style="color: deeppink">${procedure.name}</option>-->
            <#--</c:forEach>-->
        <#--</select>-->
        <#--<br><br>-->
    <#--</p>-->
    <#--<p align="center"><fmt:message key="choose.time"/><br>-->
        <#--<select id="time" name="time"-->
                <#--style="font-size: 11pt; background-color: #FFE3F5; color: deeppink">-->
            <#--<c:forEach var="time" items="${requestScope.freeTimes}">-->
                <#--<option value="${time}" style="color: deeppink">${time}</option>-->
            <#--</c:forEach>-->
        <#--</select>-->
        <#--<br><br>-->
        <#--<button class="btn btn-success" style="background-color: #FFA9EB" type="submit">-->
            <#--<fmt:message key="navbar.user.appoint"/>-->
        <#--</button>-->
    <#--</p>-->
<#--</form>-->
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
