<html>
    <body>
        Hello, ${user.name}!<br>
        <div>
            <form action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="submit" value="Sign Out"/>
            </form>
        </div>
    </body>
</html>