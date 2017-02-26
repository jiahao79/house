<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Add Your Roommates</title>
</head>
<body>
<h3>${message}</h3>
<div>
    <h2>Add Roommates</h2>
    <br/>
    <br/><br/>
    <h4>Our Database told us you are not yet registered...Please Create A House, then add your roommates</h4>
    <br/>
    <<g:form controller="house" action="sendLink">
        <label>Person Name: </label>
        <g:textField name="emailName"/><br/>
        <label>Email Address: </label>
        <g:textField name="emailAddres"/><br/>
        <g:textField name="text"/><br/>
        <g:actionSubmit value="Save"/>
    </g:form>

</div>
</body>
</html>