<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Fruit test</title>
</head>
<body>
<form action="/favorite_fruit" method="post">
    <h1>What is your favorite fruit ?</h1>

    <#list fruits as fruit>
        <p><input type="radio" name="fruit" value="${fruit}">${fruit}</input></p>
    </#list>
        <input type="submit" value="submit"/>
</form>


</body>
</html>