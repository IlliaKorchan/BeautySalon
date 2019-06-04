<html>
    <body>
    Login page
    <form method="post" action="/login">
        <div><label> Login : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Sign In"/></div>
    </form>
    <a href="/registration">Add new user</a>
    </body>
</html>