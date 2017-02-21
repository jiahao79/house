<!doctype html>
<head>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="182214251148-klka0iqjht5m2bt5430q5mnk5aqtlusp.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>
<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script>
        var ret;
        var email;
        var name;
        function onSignIn(googleUser) {
            // The ID token you need to pass to your backend:
            // Useful data for your client-side scripts:
            var profile = googleUser.getBasicProfile();
            console.log("ID: " + profile.getId()); // Don't send this directly to your server!
            console.log('Full Name: ' + profile.getName());
            console.log('Given Name: ' + profile.getGivenName());
            console.log('Family Name: ' + profile.getFamilyName());
            console.log("Image URL: " + profile.getImageUrl());
            console.log("Email: " + profile.getEmail());

            // The ID token you need to pass to your backend:
            var id_token = googleUser.getAuthResponse().id_token;
            console.log("ID Token: " + id_token);
            ret = profile.getId();
            email = profile.getEmail();
            name = profile.getGivenName();


        };
        jQuery(function () {
            jQuery("[name='jftForm']").submit(function () {
                jQuery("[name='ret']").val([ret,email,name]);
            });
        })
    </script>
    <g:form name="jftForm" controller="person" action="results">
        <g:hiddenField name="ret" value=""/>
        <g:submitButton name="submit" value="Submit"/>
    </g:form>

</body>
</html>