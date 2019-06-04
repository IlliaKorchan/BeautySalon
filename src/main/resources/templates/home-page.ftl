<html>
    <body>
        <form action="/main">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Main</button>
        </form>

        <form action="/registration">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Sign up</button>
        </form>
    </body>
</html>