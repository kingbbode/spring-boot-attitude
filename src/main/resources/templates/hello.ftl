<html>
    <head>
        <title>hello world</title>
    </head>
    <body>
        <h1>Hello World</h1>
        <div>
            <#list students as student>
                <ul>
                    <li>${student.idx}</li>
                    <li>${student.name}</li>
                </ul>
            </#list>
        </div>
    </body>
</html>