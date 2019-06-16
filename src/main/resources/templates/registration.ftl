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

    <title>Registration</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light sticky-top"
     style="background-color: #FFE3F5 ">
    <a href="/" class="navbar-brand">
        <img src="https://image.freepik.com/free-vector/_53876-43323.jpg" width="30" height="30" alt="logo">
    </a>
    <a href="/login" class="navbar-brand letter"
       style="color: deeppink; font-size:11pt" >
        Sign in
    </a>
</nav>
<br>
<form method="post" action="/registration">
    <p align="center">
    <div class="form-col" align="center">
        <div class="col">
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt">Your name in Ukrainian: </a>
            <input type="text" required placeholder="name" name="nameUkr"><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt">Your name in English: </a>
            <input type="text" required placeholder="name" name="nameEn"><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt">Your surname in Ukrainian: </a>
            <input type="text" required placeholder="name" name="surnameUkr"><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt">Your surname in English: </a>
            <input type="text" required placeholder="name" name="surnameEn"><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt">Login: </a>
            <input type="text" required placeholder="login" name="login"><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt">Password: </a>
            <input type="password" required placeholder="password" name="password"><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt">Gender: </a>
            <select name="gender">
                <option value="male">Male</option>
                <option value="female">Female</option>
            </select><br>
            <a class="navbar-brand letter" style="color: deeppink; font-size:11pt">Email: </a>
            <input type="text" required placeholder="email" name="email"><br>
            <small id="help" class="form-text text-muted">All fields are required!</small>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button class="btn btn-success" style="background-color: #FFA9EB">Sign up</button>
        </div>
    </div>
</form>
<div class="container">

</div>

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

