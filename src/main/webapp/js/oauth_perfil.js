var auth2 = {};
var helper = (function() {
  return {
    /**
     * Hides the sign in button and starts the post-authorization operations.
     *
     * @param {Object} authResult An Object which contains the access token and
     *   other authentication information.
     */
    onSignInCallback: function(authResult) {
      $('#authResult').html('Auth Result:<br/>');
      for (var field in authResult) {
        $('#authResult').append(' ' + field + ': ' +
            authResult[field] + '<br/>');
      }
      if (authResult.isSignedIn.get()) {
        $('#authOps').show('slow');
        $('#gConnect').hide();
        $('#Conected').show();
        helper.profile();
        helper.people();
        helper.navbar();
      } else if (authResult['error'] ||
          authResult.currentUser.get().getAuthResponse() == null) {
        // There was an error, which means the user is not signed in.
        // As an example, you can handle by writing to the console:
        console.log('There was an error: ' + authResult['error']);
        $('#authResult').append('Logged out');
        $('#authOps').hide('slow');
        $('#gConnect').show();
      }

      console.log('authResult', authResult);
      var request = gapi.client.plus.people.get({
        'userId' : 'me'
      });

      request.execute(function(resp) {
        console.log('ID: ' + resp.id);
        console.log('Display Name: ' + resp.displayName);
        console.log('Image URL: ' + resp.image.url);
        console.log('Profile URL: ' + resp.url);
        console.log('Birthday: '+resp.birthday);
        var id_c = resp.id;
        var foto_c = resp.image.url;
        var nombre_c = resp.displayName;
        var cumple_c = resp.birthday;               
      });
    },

    /**
     * Calls the OAuth2 endpoint to disconnect the app for the user.
     */
    disconnect: function() {
      // Revoke the access token.
      auth2.disconnect();
      location.href="https://kodding.herokuapp.com/index.jsp";
    },

    /**
     * Gets and renders the list of people visible to this app.
     */
    people: function() {
      gapi.client.plus.people.list({
        'userId': 'me',
        'collection': 'visible'
      }).then(function(res) {
        var people = res.result;
        $('#visiblePeople').empty();
        $('#visiblePeople').append('<h2>Total: ' +
            people.totalItems + '</h2><br/>');
          for (var personIndex in people.items) {
          person = people.items[personIndex];
          $('#visiblePeople').append('<div class="panel panel-default" style="background-color:transparent; border-color:transparent;">'
            +'<div class="panel-body"><p style="font-size: 17px;color: #00112B;">'
            +'<img style="margin-left: -2%;"src="' 
            + person.image.url + '"> '+person.displayName 
            +' <button type="button" class="btn" style="margin-left: 31%;border-color: black;">'
            +'<i class="glyphicon glyphicon-eye-open">'
            +'</i>Ver </button></p></div></div>');
        }
      });
    },
                      
    /**
     * Gets and renders the currently signed in user's profile data.
     */
    profile: function(){
      gapi.client.plus.people.get({
        'userId': 'me'
      }).then(function(res) {
        var profile = res.result;
        console.log(profile);
        $('#profile').empty();
        $('#profile').append(
            $('<p><img src=\"' + profile.image.url + '\" style="width: 80px; height: 80px;"></p>'));
        $('#profile').append(
            $('<p style="font-size: 20px; color: #00112B;">Nombre: ' + profile.displayName + '<br />Fecha Nacimiento: ' +
            profile.birthday + '<br />Género: ' + profile.gender + '</p>'));
        if (profile.emails) {
          $('#profile').append('<p style="font-size: 20px; color: #00112B;">Email: '+ profile.emails[0].value +'</p>');
          }
          
        if (profile.cover && profile.coverPhoto) {
          $('#profile').append(
              $('<p><img src=\"' + profile.cover.coverPhoto.url + '\"></p>'));
        }
      }, function(err) {
        var error = err.result;
        $('#profile').empty();
        $('#profile').append(error.message);
      });
    },
    navbar: function(){
      gapi.client.plus.people.get({
        'userId': 'me'
      }).then(function(res) {
        var profile = res.result;
        console.log(profile);
        $('#navbar').empty();
        $('#navbar').append(
            $('<p style="font-size: 18px;"><img src=\"' + profile.image.url + '\"style="width: 40px; height: 40px;">|| ' + profile.displayName +' ||</p>'));
        if (profile.cover && profile.coverPhoto) {
          $('navbar').append(
              $('<p><img src=\"' + profile.cover.coverPhoto.url + '\"></p>'));
        }
      }, function(err) {
        var error = err.result;
        $('#navbar').empty();
        $('#navbar').append(error.message);
      });
    }
  };
})();

/*
 * Handler for when the sign-in state changes.
 *
 * @param {boolean} isSignedIn The new signed in state.
 */
var updateSignIn = function() {
  console.log('update sign in state');
  if (auth2.isSignedIn.get()) {
    console.log('signed in');
    helper.onSignInCallback(gapi.auth2.getAuthInstance());
  }else{
    console.log('signed out');
    helper.onSignInCallback(gapi.auth2.getAuthInstance());
    location.href = "https://kodding.herokuapp.com/index.jsp";
  }
}

/**
 * This method sets up the sign-in listener after the client library loads.
 */
function startApp() {
  gapi.load('auth2', function() {
    gapi.client.load('plus','v1').then(function() {
      gapi.signin2.render('signin-button', {
          scope: 'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.email',
          fetch_basic_profile: false });
      gapi.auth2.init({fetch_basic_profile: false,
          scope:'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/userinfo.email'}).then(
            function (){
              console.log('init');
              auth2 = gapi.auth2.getAuthInstance();
              auth2.isSignedIn.listen(updateSignIn);
              auth2.then(updateSignIn());
            });
    });
  });
}