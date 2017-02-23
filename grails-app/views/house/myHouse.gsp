<!DOCTYPE html>
<html>
<head>
    <title>Welcome Home!</title>
</head>
<body>
    <div>
        <g:each in="${persons}" var="item">
            <li>${item}</li>
        </g:each>
    </div>
<a href="http://localhost:8080/house/index" onclick="signOut();">Sign out</a>
<script>
    function signOut() {
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
            console.log('User signed out.');

        });
        //window.location = "http://localhost:8080/";
    }

</script>
</body>

</html>