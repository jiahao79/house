<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Create House Form</title>
</head>
<body>
<g:form controller="house" action="save">
    <label>House Name: </label>
    <g:textField name="houseName"/><br/>
    <label>House Id: </label>
    <g:textField name="houseId"/><br/>
    <g:actionSubmit value="Save"/>
</g:form>
</body>
</html>