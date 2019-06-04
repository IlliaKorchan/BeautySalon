<html>
    <body>
        Create your personal account
        <#--${message}-->
        <form method="post" action="/registration">
            <div><label> Name : <input type="text" name="name"/> </label></div>
            <div><label> Surname : <input type="text" name="surname"/> </label></div>
            <div><label> Login : <input type="text" name="login"/> </label></div>
            <div><label> Password : <input type="password" name="password"/> </label></div>
            <div><label> Gender : <input type="text" name="gender"/> </label></div>
            <div><label> Email : <input type="text" name="email"/> </label></div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div><input type="submit" value="Sign Up"/></div>
        </form>
    </body>
</html>

