<%@include file="/WEB-INF/views/layout/include.jspf"%>
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   <meta name="description" content="Bootstrap Admin App + jQuery">
   <meta name="keywords" content="app, responsive, jquery, bootstrap, dashboard, admin">
   <title>Artist Wagon</title>
   <!-- =============== VENDOR STYLES ===============-->
   <!-- FONT AWESOME-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/font-awesome.min.css">
   <!-- SIMPLE LINE ICONS-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/simple-line-icons/css/simple-line-icons.css">
   <!-- ANIMATE.CSS-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/animate.css/animate.min.css">
   <!-- WHIRL (spinners)-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/whirl/dist/whirl.css">
   <!-- =============== PAGE VENDOR STYLES ===============-->
   <!-- =============== APP STYLES ===============-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/app/css/app.css" id="maincss">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/custom/css/styles.css">
</head>

<body id="loginPage">

		<c:if test="${not empty error}">
			<div role="alert" class="alert alert-danger">
		  	<strong>ERROR:</strong> ${error}
			</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div role="alert" class="alert alert-info">
		  	<strong>INFO:</strong> ${msg}
			</div>
		</c:if>


 <div class="wrapper">
      <div class="block-center mt-xl wd-xl">
         <!-- START panel-->
         <div class="panel panel-info panel-flat radius-clear">
            <div class="panel-heading text-center radius-clear">
               <a href="#">
                  <div class="brand-logo">
                     <h2>Artist Wagon</h2>
                  </div>
               </a>
            </div>
            <div class="panel-body">
               <p class="text-center pv">SIGN IN TO CONTINUE.</p>
               <form action="login" method="POST" name="loginForm" role="form" class="mb-lg">
               		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                  <div class="form-group has-feedback">
                     <input id="exampleInputEmail1" name="username" type="text" placeholder="Enter email" autofocus="autofocus" autocomplete="off" class="form-control">
                     <span class="fa fa-envelope form-control-feedback text-muted"></span>
                  </div>
                  <div class="form-group has-feedback">
                     <input id="exampleInputPassword1" name="password" type="password" placeholder="Password" class="form-control">
                     <span class="fa fa-lock form-control-feedback text-muted"></span>
                  </div>
                  <div class="clearfix">
                     <div class="checkbox c-checkbox pull-left mt0">
                        <label>
                           <input type="checkbox" value="" name="remember">
                           <span class="fa fa-check"></span>Remember Me</label>
                     </div>
                     <div class="pull-right"><a href="recover.html" class="text-muted">Forgot your password?</a>
                     </div>
                  </div>
                  <button type="submit" class="btn btn-block btn-primary mt-lg">Login</button>
               </form>
               <p class="pt-lg text-center">Need to Signup?</p><a href="register" class="btn btn-block btn-default">Register Now</a>
            </div>
         </div>
         <!-- END panel-->
         <div class="p-lg text-center">
            <span>&copy;</span>
            <span>2015</span>
            <span>-</span>
            <span>Artist Wagon</span>
         </div>
      </div>
   </div>
   <!-- =============== VENDOR SCRIPTS ===============-->
   <!-- MODERNIZR-->
   <script src="${pageContext.request.contextPath}/assets/vendor/modernizr/modernizr.js"></script>
   <!-- JQUERY-->
   <script src="${pageContext.request.contextPath}/assets/vendor/jquery/dist/jquery.js"></script>
   <!-- BOOTSTRAP-->
   <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/dist/js/bootstrap.js"></script>
   <!-- STORAGE API-->
   <script src="${pageContext.request.contextPath}/assets/vendor/jQuery-Storage-API/jquery.storageapi.js"></script>
   <!-- JQUERY EASING-->
   <script src="${pageContext.request.contextPath}/assets/vendor/jquery.easing/js/jquery.easing.js"></script>
   <!-- ANIMO-->
   <script src="${pageContext.request.contextPath}/assets/vendor/animo.js/animo.js"></script>
   <!-- SLIMSCROLL-->
   <script src="${pageContext.request.contextPath}/assets/vendor/slimScroll/jquery.slimscroll.min.js"></script>
   <!-- SCREENFULL-->
   <script src="${pageContext.request.contextPath}/assets/vendor/screenfull/dist/screenfull.min.js"></script>
   <!-- LOCALIZE-->
   <script src="${pageContext.request.contextPath}/assets/vendor/jquery-localize-i18n/dist/jquery.localize.js"></script>

   <!-- =============== PAGE VENDOR SCRIPTS ===============-->
   <!-- =============== APP SCRIPTS ===============-->
   <script src="${pageContext.request.contextPath}/assets/app/js/app.js"></script>
</body>

</html>
