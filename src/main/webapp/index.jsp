<!DOCTYPE html>

<html>
<head>
  <title>GSocial Inicio </title>
  <script src="//apis.google.com/js/client:platform.js?onload=startApp" async defer></script>
  <!-- JavaScript specific to this application that is not related to API
     calls -->
  <link rel="icon" type="image/x-icon" href="//gsocial.kodding.net46.net/imagen/icono.png">
  <script type="text/javascript" src="//gsocial.kodding.net46.net/js/oauth.js"></script>
  <link rel="stylesheet" type="text/css" href="//gsocial.kodding.net46.net/index_css.css">
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" ></script>
  <meta name="google-signin-client_id" content="245241056128-9umi8s4l94rfb1389l8d92i5eqga3601.apps.googleusercontent.com"></meta>
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">  
</head>
<body style="overflow-x:hidden">
  <div class="contenedor">
    <header>
      <img src="http://prueba.profit.com.ve/header.png">
    </header>
    <div class="wrapper"style="padding: 4%;">
        <form id="datos" method="GET" action="//localhost:8080/spring-rest-client/perfil.jsp">
        <input type="text" name="ID" id="ID" hidden="">       
        <p class="titulo"><img src="//gsocial.kodding.net46.net/imagen/title.png" class="title"></p>
        
        <button form="datos" style="width: 334px; background-color: transparent; border: black;" value="Submit">
          <div id="gConnect" style="margin-left: 63%;">
            <div id="signin-button"></div>
          </div>

        </button>
        <button form="datos" id="Conected" type="submit"  hidden=""
        value="Submit" Style="background: url(//gsocial.kodding.net46.net/imagen/signin.png); width: 317px;Height: 72px;border-color: transparent;">
          <div id="Conected"></div>
        </button>

      </form>
         
    </div>
    <footer>
      <img src="WEB-INF/imagen/footer.png">
    </footer>
  </div>
</body>
</html>
