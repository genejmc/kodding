 function auth() {
        var config = {
          'client_id': '829118522513-rkmv1er44hkhbbbiv0vspm751tkf352j.apps.googleusercontent.com',
          'scope': 'http://www.google.com/m8/feeds'
        };
        gapi.auth.authorize(config, function() {
          fetch(gapi.auth.getToken());
        });
      }
   function fetch(token) {
      var datos = null;      
      $.ajax({
        url:"https://www.google.com/m8/feeds/contacts/default/full?access_token=" + token.access_token + "&alt=json",
        dataType: "jsonp",
        success:function(data) {
                  //console.log(JSON.stringify(data));
              
              datos = JSON.stringify(data);
               //console.log(datos);
               
               var json = JSON.parse(datos);
               console.log (json);
               //console.log(json.feed.author["0"].email.$t);
              document.getElementById("demo").innerHTML =
                json.feed.author["0"].email.$t
              
            
          }
      });

}
