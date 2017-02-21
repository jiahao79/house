<!DOCTYPE>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Persons</title>
</head>
<body>
<g:each in="${persons}" var="person" status="i">
    <h3>${i+1}. ${person.lastName}, ${person.firstName}</h3>
    <p>
        sub_ID: ${person.sub_id}, houseId: ${person.houseId}
    </p>
    <br/>
</g:each>
</body>


</html>