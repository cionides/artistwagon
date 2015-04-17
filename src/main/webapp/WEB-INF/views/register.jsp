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

<body id="registerPage">
	<div class="container">		
		<form:form method="POST" action="${pageContext.request.contextPath}/register/save" class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3" role="form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
			<div id="step1Panel" class="panel registration-panel radius-clear b animated">
				<div class="panel-heading text-center">
					<h1>Lets Get Started</h1>
					<h5>Create your basic profile below.</h5>
				</div>
				<div class="panel-body">
					<div class="form-group col-lg-12">
			      <label>Full Name</label>
			      <form:input path="user.password" type="text" placeholder="John Doe" class="form-control input-lg radius-clear" autofocus="autofocus" />
		      </div>
		      <div class="form-group col-lg-12">
			      <label>Email</label>
			      <form:input path="user.username" type="email" placeholder="john.doe@email.com" class="form-control input-lg radius-clear" />
		      </div>
		      <div class="form-group col-lg-12">
			      <label>Mobile Number</label>
			      <form:input path="user.password" type="text" placeholder="(888) 888-8888" class="form-control input-lg radius-clear" />
		      </div>
		      <div class="form-group col-lg-12">
			      <label>Password</label>
			      <form:input path="user.password" type="password" placeholder="********" class="form-control input-lg radius-clear" />
		      </div>
		      <div class="form-group col-lg-12">
			      <label>Reenter Password</label>
			      <form:input path="user.password" type="password" placeholder="********" class="form-control input-lg radius-clear" />
		      </div>
		      <div class="col-lg-12 mt-lg">
		      	<div class="pull-left">
		      		<h4>Step 1 of 2</h4>
		      	</div>
		      	<button id="goToStep2" type="button" class="btn btn-lg btn-primary radius-clear pull-right">Next Step</button>
		      </div>
				</div>
			</div>
			<div id="step2Panel" class="panel registration-panel radius-clear b animated bounceInRight hidden">
				<div class="panel-heading text-center">
					<h1>Link External Account</h1>
					<h5>Linking an external account allows you to transfer money to and from your account with ease.</h5>
				</div>
				<div class="panel-body">
					<div class="form-group col-lg-12">
			      <label>Routing Number</label>
			      <input id="routingNumber" type="text" placeholder="Routing Number" class="form-control input-lg radius-clear">
		      </div>
		      <div class="form-group col-lg-12">
			      <label>Account Number</label>
			      <input type="text" placeholder="Account Number" class="form-control input-lg radius-clear">
		      </div>
		      <div class="form-group col-lg-12">
		      	<label>Account Type?</label>
		      	<div class="radio">
						  <label>
						    <input type="radio" name="checkingOrSaving" id="optionsRadios1" value="yes">
						    	Checking
						  </label>
						</div>
						<div class="radio">
						  <label>
						    <input type="radio" name="checkingOrSaving" id="optionsRadios2" value="no">
						    	Savings
						  </label>
						</div>
		      </div>
		      <div class="col-lg-12 mt-lg">
		      	<div class="pull-left">
		      		<h4>Step 2 of 2</h4>
		      	</div>
		      	<button type=submit class="btn btn-lg btn-primary radius-clear pull-right">Submit</button>
		      </div>
				</div>
			</div>
		</form:form>
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
   <script src="${pageContext.request.contextPath}/assets/custom/js/registration.js"></script>
</body>

</html>
