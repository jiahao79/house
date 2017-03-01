<!doctype html>
<head>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="724926326266-dhm6bt52ttmrlaessmt8rqp5oc6ueute.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>
    <h1>Message: ${params['message']}</h1>
    <h5>Session: ${session['subId']}</h5>
    <div>
        <g:form controller="PersonHouse" action="logout">
            <g:submitButton name="logout" controller="PersonHouse" action="logout" value="logout" />
        </g:form>
    </div>

    <br/>
    <h2>Welcome To House Mates!</h2>
    <br/>
    <h5>Before we get you setp up... please login to your google gmail account by clicking the button below</h5>
    <h5>Then click the enter button</h5>
    <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>
            var subId;
            var email;
            var firstName;
            var lastName;

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
                subId = profile.getId();
                email = profile.getEmail();
                firstName = profile.getGivenName();
                lastName = profile.getFamilyName();

            };
            jQuery(function () {
                jQuery("[name='jftForm']").submit(function () {
                    jQuery("[name='googleProfile']").val([firstName,lastName,subId,email]);
                });
            })
        </script>
        <br/>
        <div>
            <br/>
            <h4>Already a member... please click login button below</h4>
            <g:form name="jftForm" controller="PersonHouse" action="login">
                <g:hiddenField name="googleProfile" value=""/>
                <g:submitButton name="login" value="Enter"/>
            </g:form>
        <br/>
        </div>
        <br/>
        <div>
        <a href="#" onclick="signOut();">Sign out</a>
            <script>
              function signOut() {
                var auth2 = gapi.auth2.getAuthInstance();
                auth2.signOut().then(function () {
                  console.log('User signed out.');
                  location.reload();
                });
              }
            </script>
    </div>
    <div>
        <br/><br/>
        <h4>Please click button below to join</h4>
        <g:form name="jftForm" controller="person" action="createperson">
            <g:hiddenField name="googleProfile" value=""/>
            <g:submitButton name="Login" value="Enter"/>
        </g:form>
    </div>

</body>
</html>