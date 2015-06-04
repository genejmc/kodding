<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
  <title>GSocial Inicio </title>
  <script src="https://apis.google.com/js/client:platform.js?onload=startApp" async defer></script>
  <!-- JavaScript specific to this application that is not related to API
     calls -->
  <link rel="icon" type="image/x-icon" href="http://gsocial.kodding.net46.net/imagen/icono.png">
  <script type="text/javascript" src="http://gsocial.kodding.net46.net/js/oauth.js"></script>
  <link rel="stylesheet" type="text/css" href="http://gsocial.kodding.net46.net/css/index_css.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" ></script>
  <meta name="google-signin-client_id" content="829118522513-rkmv1er44hkhbbbiv0vspm751tkf352j.apps.googleusercontent.com"></meta>
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">  
</head>
<body style="overflow-x:hidden">
  <div class="contenedor">
    <header>
      <img src="http://gsocial.kodding.net46.net/imagen/header.png">
    </header>
    <div class="wrapper"style="padding: 4%;">
        <form id="datos" method="POST" action="http://gsocial.kodding.net46.net/perfil.jsp">
        <input type="text" name="ID" id="ID" hidden="">
        <input type="text" name="Email" id="Email" hidden="">
        <input type="text" name="Nombre" id="Nombre" hidden="" >
        <input type="text" name="Foto" id="Foto" hidden="">
        <input type="text" name="Nacimiento" id="Nacimiento" hidden="">
        
        
        <p class="titulo"><img src="http://gsocial.kodding.net46.net/imagen/title.png" class="title"></p>
        
        <button form="datos" style="width: 334px; background-color: transparent; border: black;" value="Submit">
          <div id="gConnect" style="margin-left: 63%;">
            <div id="signin-button"></div>
          </div>

        </button>
        <button form="datos" id="Conected" type="submit"  hidden=""s
        value="Submit" Style="background: url(http://gsocial.kodding.net46.net/imagen/signin.png); width: 317px;Height: 72px;border-color: transparent;">
          <div id="Conected"></div>
        </button>

      </form>
         
    </div>
    <footer>
      <img src="http://gsocial.kodding.net46.net/imagen/footer.png">
    </footer>
  </div>
</body>
</html>