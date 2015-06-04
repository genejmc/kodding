<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">

<?php
$NOMBRE = $_GET['Nombre'];
$CORREO =$_GET['Email'];
$Url =$_GET['Foto'];
$Cumple =$_GET['Nacimiento'];

?>
<%
	String nombre = request.getParameter("Nombre");
	System.out.println(nombre);
%>
  <head>
    <title>GSocial</title>
    <script type="text/javascript" src="js/oauth_perfil.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="https://apis.google.com/js/client:platform.js?onload=startApp" async defer></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="icon" type="image/x-icon" href="imagen/icono.png">
    <meta name="google-signin-client_id" content="829118522513-rkmv1er44hkhbbbiv0vspm751tkf352j.apps.googleusercontent.com"></meta>
    <meta name="generator" content="Bootply" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="css/styles.css" rel="stylesheet">      
  </head>
<body>
 

<div class="wrapper">
    <div class="box">
        <div class="row row-offcanvas row-offcanvas-left">
                  
            <!-- sidebar -->
            <div class="column col-sm-2 col-xs-1 sidebar-offcanvas" id="sidebar">
              
                <ul class="nav">
             <li><a href="#" data-toggle="offcanvas" class="visible-xs text-center"><i class="glyphicon glyphicon-chevron-right"></i></a></li>
              </ul>
               
                <ul class="nav hidden-xs" id="lg-menu">
                    <li>
                      <button type="button" class="btn" data-toggle="modal" data-target="#Modal-comentario" data-whatever="@mdo">
                        <i class="glyphicon glyphicon-comment"></i> Publicar</a>
                      </button>
                      <!-- Modal del comentario-->
                      <div class="modal fade" id="Modal-comentario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h3 class="modal-title" id="exampleModalLabel">Nueva Publicaci&oacute;n</h3>
                            </div>
                            <div class="modal_cuerpo">
                              <div class="form-group">
                                <p>
                                  T&iacute;tulo<input type="text" style="width: 528px;">
                                </p>
                                <P>
                                  <strong>Mensaje:</strong>
                                  <textarea class="form-control" id="message-text">
                                  </textarea>
                                </P>
                                <p>URL DE FOTO A POSTEAR: 
                                  <input type="text" placeholder="URL"style="width: 68%;">
                                </p>
                              </div>
                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-default" data-toggle="modal" data-target="#Modal-mapa">
                              <i class="glyphicon glyphicon-map-marker"></i>
                              </button>
                              <!-- Modal MAPA-->
                              <!-- FIN MODAL MAPA-->
                              <!--MODAL ADJUNTAR-->
                              <button type="button" class="btn btn-default" >
                                <a href="http://instagram.com" target="_blank">
                                  <i class="glyphicon glyphicon-camera">
                                  </i>
                                </a>
                              </button>
                                <!-- FIN MODAL ADJUNTAR-->
                              <button class="btn btn-cerrar" type="button" data-dismiss="modal" data-target="#Modal-comentario" aria-hidden="true">Cerrar</button>
                              <button type="button" class="btn btn-primary">Enviar</button>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!--Final Modal Comentario-->
                    </li>
                    <li><a href="#"><i class="glyphicon glyphicon-briefcase"></i> Grupos</a>
                    
                    <button type="button" class="btn" data-toggle="modal" data-target="#Modal_Amigos">
                        <li><i class="glyphicon glyphicon-thumbs-up"></i> Amigos</li>
                      </button>
                      <!--MODAL AMIGOS-->
                      <div class="modal fade" id="Modal_Amigos" role="dialog" aria-labelledby="gridSystemModalLabel" aria-hidden="false">
                       <div class="modal-dialog">
                           <div class="modal-content">
                            <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="false">&times;</span></button>
                              <h3 class="modal-title" id="gridSystemModalLabel">Amigos</h3>
                              <div class="form-group">
                                <div class="modal_cuerpo">
                                  
                                   <div id="gConnect">
                                    <div id="signin-button"></div>
                                  </div>
                                  <div id="visiblePeople"></div>
                                </div>
                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-cerrar" data-dismiss="modal">Cerrar</button>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div><!-- /.modal AMIGOS-->
                    </li>
                    <li>
                      <button type="button" class="btn" data-toggle="modal" data-target="#Modal" data-whatever="@mdo">
                        <i class="glyphicon glyphicon-user"></i> Perfil
                      </button>
                      <!--MODAL DATOS PERSONALES-->
                      <div class="modal fade" id="Modal" role="dialog" aria-labelledby="gridSystemModalLabel" aria-hidden="false">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="false">&times;</span></button>
                              <h3 class="modal-title" id="gridSystemModalLabel">Datos Personales</h3>
                              <div class="form-group">
                                 <div class="modal_cuerpo">
                                  <img src="<?PHP echo "$Url" ?>" >
                                  <h3><strong style="text-transform: capitalize;font-style: c;">
                                  <?php  echo "$NOMBRE" ?></strong></h3>
                                  <h3><strong>
                                  <?php  echo "$CORREO" ?></strong></h3>
                                  <h3><strong style="text-transform: capitalize;font-style: c;">
                                  <?php  echo "$Cumple" ?></strong></h3>
                                  
                               </div>
                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-cerrar" data-dismiss="modal">Cerrar</button>
                             </div>
                          </div><!-- /.modal-content -->
                        </div><!-- /.modal-dialog -->
                      </div><!-- /.modal DATOS PERSONALES -->
                    </li>
                    <li>
                      <button type="button" class="btn" id="signOut" onclick="auth2.signOut()">
                        <i class="glyphicon glyphicon-log-out"> </i> Salir</button>
                    </li>
                    <li>
                      <button type="button" class="btn" id="disconnect" onclick="auth2.disconnect();">
                        <i class="glyphicon glyphicon-ban-circle"></i> Dar de baja</button>
                    </li>
                </ul>
                <ul class="list-unstyled hidden-xs" id="sidebar-footer">
                    <li>
                      <img src="imagen/sidebar.png">
                      <a href="http://kodding.net46.net/">
                      <br>
                      <br>
                      <i class="glyphicon glyphicon-console"></i> Kodding</a>
                    </li>
                </ul>
              
                <!-- tiny only nav-->
              <ul class="nav visible-xs" id="xs-menu">
                    <li><a href="#" text-aling="center"><i class="glyphicon glyphicon-comment"></i></a></li>
                    <li><a href="#" text-aling="center"><i class="glyphicon glyphicon-briefcase"></i></a></li>
                    <li><a href="#" text-aling="center"><i class="glyphicon glyphicon-thumbs-up"></i></a></li>
                    <li><a href="#" text-aling="center"><i class="glyphicon glyphicon-user"></i></a></li>
                    <li><a href="#" text-aling="center"><i class="glyphicon glyphicon-log-out"></i></a></li>
                    <li><a href="#" text-aling="center"><i class="glyphicon glyphicon-ban-circle"></i></a></li>
              </ul>
              
            </div>
            <!-- /sidebar -->
          
            <!-- main right col -->
            <div class="column col-sm-10 col-xs-11" id="main">
                
                <!-- top nav -->
                <div class="navbar navbar-blue navbar-static-top">  
                    <div class="navbar-header" >
                      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                      </button>
                      <a href="http://kodding.herokuapp.com/perfil.jsp" class="navbar-brand logo">
                        <img src="imagen/navbar.png">
                      </a>
                    </div>
                    <nav class="collapse navbar-collapse" role="navigation">
                    <form class="navbar-form navbar-left">
                        <div class="input-group input-group-sm" style="max-width:360px;">
                          <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
                          <div class="input-group-btn">
                            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                          </div>
                        </div>
                    </form>
                    <ul class="nav navbar-nav">
                      <li>
                        <div class="perfil">
                          <img src="<?PHP echo "$Url" ?>" WIDTH=40 HEIGHT=40 >
                          <span>|| <strong style="text-transform: capitalize;font-style: c;">
                                  <?php  echo "$NOMBRE" ?></strong> </span>
                          ||
                          </div>
                      </li>
                    </ul>
                    </nav>
                </div>
                <!-- /top nav -->
              
                <div class="padding">
                    <div class="full col-sm-9">
                        
                        <!-- content -->                        
                        <div class="row">
                         <!-- main col left --> 
                         <div class="col-sm-9">
                          <!-- Add where you want your sign-in button to render -->
                            <!-- Use an image that follows the branding guidelines in a real app -->
                            <div id="gConnect">
                                    <div id="signin-button"></div>
                                  </div>
                            <div id="visiblePeople"></div>
                            <div class="panel panel-default">
                              <div class="panel-heading"><h4>Usuario</h4></div>
                              <div class="panel-body">
                                <img src="imagen/ucab.jpg"> 
                                Universidad Catolica Andres Bello
                                <div class="clearfix"></div>
                                  <hr>
                                  <form>
                                    <div class="input-group">
                                       <div class="input-group-btn">
                                      <button class="btn btn-default">
                                      <i class="glyphicon glyphicon-map-marker"></i></button>
                                      </div>
                                      <div class="input-group-btn">
                                      <button class="btn btn-default">
                                      <i class="glyphicon glyphicon-paperclip"></i></button>
                                      </div>
                                      <div>
                                      <input type="text" class="form-control" placeholder="comentar">
                                      </div>
                                      <div class="input-group-btn">
                                      <button class="btn btn-default"><i class="glyphicon glyphicon-ok">
                                      </i>
                                      </button>
                                      </div>
                                    </div>
                                  </form>
                                    
                                </div>
                              </div>  
                              <div class="panel panel-default">
                              <div class="panel-heading"><h4>Usuario</h4></div>
                              <div class="panel-body">
                                <img src="imagen/f0.png"> 
                                Kodding
                                <div class="clearfix"></div>
                                  <hr>
                                  <form>
                                    <div class="input-group">
                                      <div class="input-group-btn">
                                      <button class="btn btn-default">
                                      <i class="glyphicon glyphicon-map-marker"></i></button>
                                      </div>
                                      <div class="input-group-btn">
                                      <button class="btn btn-default">
                                      <i class="glyphicon glyphicon-paperclip"></i></button>
                                      </div>
                                      <div>
                                      <input type="text" class="form-control" placeholder="comentar">
                                      </div>
                                      <div class="input-group-btn">
                                      <button class="btn btn-default"><i class="glyphicon glyphicon-ok">
                                      </i>
                                      </button>
                                      </div>
                                    </div>
                                  </form>
                                    
                                </div>
                              </div>  
                         </div>
                          
                        </div><!--/row-->
                                        
                      <h4 class="text-center">
                      <a href="gsocial.kodding.net46.net"><img src="imagen/kodding.png"></a>

                    </div><!-- /col-9 -->
                </div><!-- /padding -->
            </div>
            <!-- /main -->
          
        </div>
    </div>
</div>


<!--post modal-->
<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
      Update Status
      </div>
      <div class="modal-body">
          <form class="form center-block">
            <div class="form-group">
              <textarea class="form-control input-lg" autofocus placeholder="What do you want to share?"></textarea>
            </div>
          </form>
      </div>
      <div class="modal-footer">
          <div>
          <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">Post</button>
            <ul class="pull-left list-inline"><li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li><li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li><li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>

      </div>  
      </div>
  </div>
  </div>
</div>
  <!-- script references -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script src="js/modal.js"></script>
  </body>
</html>